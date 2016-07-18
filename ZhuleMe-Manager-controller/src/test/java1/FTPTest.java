package java1;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by lz on 2016/6/7.
 */
public class FTPTest {
    @Test
    public void testFtpClient() {
        try{
        //创建一个FtpClient对象
        FTPClient ftpClient=new FTPClient();
        //创建ftp链接
        ftpClient.connect("115.28.110.26",21);
        //登录,使用用户
            System.out.println(ftpClient.login("lizhao","woshiLIZHAO"));
        //上传
        FileInputStream inputStream=new FileInputStream(new File("D:\\kobe.jpg"));
        //上传文件格式
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.changeWorkingDirectory("/home/lizhao/www/images");
            System.out.println(ftpClient.storeFile("kobe.jpg",inputStream));
        //关闭
        ftpClient.logout();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
