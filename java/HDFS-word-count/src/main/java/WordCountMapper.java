import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author ZhangZhe
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text, IntWritable> {
    Text outKey = new Text();
    IntWritable outValue = new IntWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


        String[] words = value.toString().split(" ");
        for (String word:
             words ) {
            outKey.set(word);
            outValue.set(1);
            context.write(outKey,outValue);
        }
    }
}
