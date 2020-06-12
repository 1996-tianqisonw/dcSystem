package com.hx.log.Impl;

import com.hx.log.LogService;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by admin on 2020/6/3.
 */
@Service
public class LogServiceImpl implements LogService {
    //这是异常日志接口,用以纪录一场信息和改善程序。
    //那么采用永久化的技术，则包括文件存储异常信息和数据库异常表进行异常的存储
    @Override
    public void writeLog(String log) {
        //System.out.println("这里写日志业务==========" + log);
        //这里采用文件的方式
        FileOutputStream fo = null;
        ObjectOutputStream oo = null;
        try {
            //这里还是要用相对路径来写，用绝对路径，到时布局到其它计算机上时会出现路径错误
            //要不然写死的话，就让其去生成一个文件，io流对象是有生成文件的功能的
            fo = new FileOutputStream(new File("E:/dcSystem/src/main/webapp/log/log.text"));
            oo = new ObjectOutputStream(fo);
            oo.writeObject(log);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
