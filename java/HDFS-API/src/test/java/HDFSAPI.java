import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSAPI {
    /**
     * 打印本地hadoop地址
     * IO的方式写代码
     */
    @Test
    public void initHDFS() throws IOException {
//        1. 创建配置信息对象
        Configuration conf = new Configuration();

//        2. 获取文件系统
        FileSystem fs = FileSystem.get(conf);

//        3. 打印文件系统
        System.out.println(fs.toString());
    }

    /**
     * 上传文件
     *
     * @throws IOException
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void putFileToHDFS() throws IOException, URISyntaxException, InterruptedException {
//        1. 创建配置信息对象
        Configuration conf = new Configuration();

//        2. 设置部分参数
        conf.set("dfs.replication", "2");

//        3. 设置HDFS的地址
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata111:9000"), conf, "root");

//        4. 上传本地文件的路径
        Path src = new Path("D:\\Downloads\\ideaIU-2019.1.exe");

//        5. 要上传到的HDFS的路径
        Path dst = new Path("hdfs://bigdata111:9000/");

//        6. 以拷贝的方式上传
        fs.copyFromLocalFile(src, dst);

//        7. 关闭
        fs.close();

        System.out.println("ok!");
    }

    /**
     * 下载文件
     *
     * @throws IOException
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void getFileFromHDFS() throws IOException, URISyntaxException, InterruptedException {
//        1. 创建配置信息对象
        Configuration conf = new Configuration();
//        2. 设置文件系统
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata111:9000"), conf, "root");
//        3. 要下载的文件路径
        Path src = new Path("hdfs://bigdata111:9000/AA");
//        4. 要保存到的路径
        Path dst = new Path("d:\\");
//        5. 以拷贝的方式下载
        fs.copyToLocalFile(src, dst);
//        6. 关闭
        fs.close();
    }

    /**
     * 创建文件夹
     *
     * @throws IOException
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void mkdirInHDFS() throws IOException, URISyntaxException, InterruptedException {
//        1. 创建配置信息对象
        Configuration conf = new Configuration();
//        2. 设置文件系统
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata111:9000"), conf, "root");
//        3. 要创建的文件夹路径和名称
        Path dir = new Path("hdfs://bigdata111:9000/guoxiaoru");
//        4. 创建文件夹
        fs.mkdirs(dir, new FsPermission("111"));
//        5. 关闭
        fs.close();
    }

    /**
     * 删除文件
     */
    @Test
    public void deleteFileInHDFS() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata111:9000"), conf, "root");
        Path file = new Path("hdfs://bigdata111:9000/guoxiaoru");
        fs.deleteOnExit(file);
        fs.close();
    }

    /**
     * 显示文件列表和文件信息
     */
    @Test
    public void showFileListAndInfo() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata111:9000"), conf, "root");
        Path root = new Path("/");
        RemoteIterator<LocatedFileStatus> files = fs.listFiles(root, true);

        while (files.hasNext()) {
            LocatedFileStatus file = files.next();

            // 文件还是文件夹
            if (file.isDirectory()) {
                System.out.println("文件夹");
            } else {
                System.out.println("文件");
            }
            // 名称
            System.out.println("文件名：" + file.getPath().getName());
            // 块大小
            System.out.println("块大小：" + file.getBlockSize() / 1024 / 1024 + "M");
            // 权限
            System.out.println("权限：" + file.getPermission());
            // 大小
            System.out.println("大小：" + file.getLen() / 1024 / 1024 + "M");
            // 拥有者
            System.out.println("拥有者：" + file.getOwner());
            // 组
            System.out.println("组：" + file.getGroup());

            BlockLocation[] blockLocations = file.getBlockLocations();
            // 块数量
            System.out.println("块数量：" + blockLocations.length);

            for (BlockLocation block :
                    blockLocations) {
                // 块偏移
                System.out.println("块 OFFSET：" + block.getOffset());
                String[] hosts = block.getHosts();
                for (String host : hosts) {
                    // 主机名
                    System.out.println("主机名：" + host);
                }
            }

            System.out.println("-------------------------------------------------");
        }

        FileStatus[] fileStatuses = fs.listStatus(root);
        for (FileStatus fss :
                fileStatuses) {
            // 文件还是文件夹
            if (fss.isDirectory()) {
                System.out.println("文件夹");
            } else {
                System.out.println("文件");
            }
            // 名称
            System.out.println("文件名：" + fss.getPath().getName());
            // 块大小
            System.out.println("块大小：" + fss.getBlockSize() / 1024 / 1024 + "M");
            // 权限
            System.out.println("权限：" + fss.getPermission());
            // 大小
            System.out.println("大小：" + fss.getLen() / 1024 / 1024 + "M");
            // 拥有者
            System.out.println("拥有者：" + fss.getOwner());
            // 组
            System.out.println("组：" + fss.getGroup());

            System.out.println("-------------------------------------------------");
        }
    }

    /**
     * IO方式上传文件
     */
    @Test
    public void putFileUseIO() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata111:9000"), conf, "root");
//        1. 创建输入流
        File file = new File("D:\\Downloads\\1.Hadoop基础+伪完全分布式.doc");
        FileInputStream fileInputStream = new FileInputStream(file);
//        2. 创建输入流
        Path path = new Path("/" + file.getName());
        FSDataOutputStream fsDataOutputStream = fileSystem.create(path);
//        3. 上传
        IOUtils.copyBytes(fileInputStream, fsDataOutputStream, 4 * 1024, true);
    }

    /**
     * IO方式下载文件
     */
    @Test
    public void getFileUseIO() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata111:9000"), conf, "root");
//        1. 创建输入流
        Path path = new Path("/BB");
        FSDataInputStream fsDataInputStream = fileSystem.open(path);
//        2. 创建输出流,用标准输出

//        3. 下载
        try {
            IOUtils.copyBytes(fsDataInputStream, System.out, 4 * 1024, false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(fsDataInputStream);
        }
    }

    /**
     * 按块下载
     */
    @Test
    public void getFileByBlock() throws URISyntaxException, InterruptedException, IOException {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata111:9000"), conf, "root");

//        1. 获取输入流
        Path path = new Path("/ideaIU-2019.1.exe");
        FSDataInputStream fsDataInputStream = fileSystem.open(path);
//        2. 获取输出流
        File outFile = new File("D:\\out.exe");
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
//        3. 获取文件信息,一块一块的获取
        FileStatus fileStatus = fileSystem.getFileStatus(path);
        BlockLocation[] fileBlockLocations = fileSystem.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        try {
            for (BlockLocation blockLocation : fileBlockLocations) {
                // 设置偏移量
                fsDataInputStream.seek(blockLocation.getOffset());
                // 按块长度读取文件，即一次只读取一块
                IOUtils.copyBytes(fsDataInputStream, fileOutputStream, blockLocation.getLength(), false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeStream(fileOutputStream);
            IOUtils.closeStream(fsDataInputStream);
        }
    }

}
