package acezhe;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

public class UserUtils {

    public static String generatePass(String password,String salt,int iter){
        String hashedPasswordBase64 = new Sha256Hash(password,salt,iter).toBase64();
        System.out.println("Hashed password with base64:"+hashedPasswordBase64);
        return hashedPasswordBase64;
    }

    public static void main(String[] args) {
        String username = "muti";
        String password = "muti";
        System.out.println(generatePass(password,username+password,1024));

    }

}
