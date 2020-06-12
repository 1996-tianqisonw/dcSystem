package com.hx.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

/**
 * Created by admin on 2020/5/21.
 */
public class Erweima {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    public static void main(String[] args) {
        //关于二维码的操作,这里是二维码的生成，
        //一是关于二维码的生成，生成一个怎样的二维码，二维码带有哪些参数。
        //二是关于二维码的存储，及一怎样的形式储存及怎么存取的问题
        //三是关于二维码的界面展示，怎样展示二维码的问题，关于界面的展示是以src路径的问题
        //也就是怎样保证二维码与餐桌编号一致的问题
        //四关于完整的逻辑路径的问题,因为数据库存储的是字符串，在添加的时候，不经过二维码的生成
        //也就是说存的是餐桌二维码要生成的参数，然后在查询展示的时候，把相应的参数查询出来
        //经过二维码的生成器，生成二维码图片，并展示到界面
        try {
            // create();
            create();
        } catch (Exception e) {
            e.printStackTrace();
        }

     /*   String text = "https://www.baidu.com?departid=1&tableid=88"; // 这里是URL ，扫描之后就跳转到这个界面
        String path = "e:/testdir"; // 图片生成的位置
        int width = 900;
        int height = 900;
        // 二维码图片格式
        String format = "gif";
        // 设置编码，防止中文乱码
        Hashtable<EncodeHintType, Object> ht = new Hashtable<EncodeHintType, Object>();
        ht.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置二维码参数(编码内容，编码类型，图片宽度，图片高度,格式)

        BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
                BarcodeFormat.QR_CODE, width, height, ht);
        // 生成二维码(定义二维码输出服务器路径)
        File outputFile = new File(path);
        if (!outputFile.exists()) {
            // 创建文件夹
            outputFile.mkdir();
        }
        int b_width = bitMatrix.getWidth();
        int b_height = bitMatrix.getHeight();
        // 建立图像缓冲器
        BufferedImage image = new BufferedImage(b_width, b_height,
                BufferedImage.TYPE_3BYTE_BGR);
        for (int x = 0; x < b_width; x++) {
            for (int y = 0; y < b_height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
            }
        }
        // 生成二维码
        ImageIO.write(image, format, new File(path + "/erweima." + format)); // 二维码的名称
        // 是
        // erweima.sgif*/
    }

    /*
    参数需要：
    1、二维码扫描后跳转的路径（可以带参数）,
    2、图片的存放路径，3
    3、图片的宽
    4、图片的高
    5、图处的格式
     */
    public static void create(String url,String basePath,int w,int h,String f ) throws Exception{
        String text = url;//"https://www.baidu.com/deptId=a001&deskId=33"; //这里是URL ，扫描之后就跳转到这个界面
        String path = basePath;//"e:/"; //图片生成的位置
        int width =w;// 900;
        int height = h;//900;
        // 二维码图片格式
        String format = f;// "gif";
        // 设置编码，防止中文乱码
        Hashtable<EncodeHintType, Object> ht = new Hashtable<EncodeHintType, Object>();
        ht.put (EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置二维码参数(编码内容，编码类型，图片宽度，图片高度,格式)

        BitMatrix bitMatrix = new MultiFormatWriter().encode (text, BarcodeFormat.QR_CODE, width, height, ht);
        // 生成二维码(定义二维码输出服务器路径)
        File outputFile = new File (path);
        if (!outputFile.exists ())
        {
            //创建文件夹
            outputFile.mkdir ();
        }
        int b_width = bitMatrix.getWidth ();
        int b_height = bitMatrix.getHeight ();
        // 建立图像缓冲器
        BufferedImage image = new BufferedImage (b_width, b_height, BufferedImage.TYPE_3BYTE_BGR);
        for ( int x = 0; x < b_width; x++ )
        {
            for ( int y = 0; y < b_height; y++ )
            {
                image.setRGB (x, y, bitMatrix.get (x, y) ? BLACK : WHITE);
            }
        }
        // 生成二维码
        ImageIO.write (image, format, new File (path + "erweima." + format)); //二维码的名称 是 erweima.sgif
    }

    ////参数需要：1店铺的标记,2餐桌编号，3长，4，宽
    // public static void create(String sId,String tNo,Integer w,Integer h) throws Exception{
    public static void create( ) throws Exception{
        String text = "https://www.baidu.com"; //这里是URL ，扫描之后就跳转到这个界面
        String path = "D:/wordTool/git-repo/clone-repo1/rpo3/dcSystem/dcSystem/src/main/webapp/erweima"; //图片生成的位置
        int width = 10;
        int height = 10;
        // 二维码图片格式
        String format = "gif";
        // 设置编码，防止中文乱码
        Hashtable<EncodeHintType, Object> ht = new Hashtable<EncodeHintType, Object> ();
        ht.put (EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置二维码参数(编码内容，编码类型，图片宽度，图片高度,格式)

        BitMatrix bitMatrix = new MultiFormatWriter ().encode (text, BarcodeFormat.QR_CODE, width, height, ht);
        // 生成二维码(定义二维码输出服务器路径)
        File outputFile = new File (path);
        if (!outputFile.exists ()) {
            //创建文件夹
            outputFile.mkdir ();
        }
        int b_width = bitMatrix.getWidth ();
        int b_height = bitMatrix.getHeight ();
        // 建立图像缓冲器
        BufferedImage image = new BufferedImage (b_width, b_height, BufferedImage.TYPE_3BYTE_BGR);
        for ( int x = 0; x < b_width; x++ ) {
            for ( int y = 0; y < b_height; y++ ) {
                image.setRGB (x, y, bitMatrix.get (x, y) ? BLACK : WHITE);
            }
        }
        // 生成二维码,文件名可以设计成根据 “店的编号+"_"+餐桌号”生成唯一。
        ImageIO.write (image, format, new File (path + "erweima." + format)); //二维码的名称 是 erweima.sgif
    }

    public static void create(String url,String piceName,String filePath) throws Exception{
        String text = url; //这里是URL ，扫描之后就跳转到这个界面
        String path = filePath; //图片生成的位置
        int width = 10;
        int height = 10;
        // 二维码图片格式
        String format = "gif";
        // 设置编码，防止中文乱码
        Hashtable<EncodeHintType, Object> ht = new Hashtable<EncodeHintType, Object> ();
        ht.put (EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置二维码参数(编码内容，编码类型，图片宽度，图片高度,格式)

        BitMatrix bitMatrix = new MultiFormatWriter ().encode (text, BarcodeFormat.QR_CODE, width, height, ht);
        // 生成二维码(定义二维码输出服务器路径)
        File outputFile = new File (path);
        if (!outputFile.exists ())
        {
            //创建文件夹
            outputFile.mkdir ();
        }
        int b_width = bitMatrix.getWidth ();
        int b_height = bitMatrix.getHeight ();
        // 建立图像缓冲器
        BufferedImage image = new BufferedImage (b_width, b_height, BufferedImage.TYPE_3BYTE_BGR);
        for ( int x = 0; x < b_width; x++ ) {
            for ( int y = 0; y < b_height; y++ ) {
                image.setRGB (x, y, bitMatrix.get (x, y) ? BLACK : WHITE);
            }
        }
        // 生成二维码,文件名可以设计成根据 “店的编号+"_"+餐桌号”生成唯一。
        ImageIO.write (image, format, new File (path +"/"+piceName+ "." + format)); //二维码的名称 是 erweima.sgif
    }

}
