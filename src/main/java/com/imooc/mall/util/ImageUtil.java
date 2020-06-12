package com.imooc.mall.util;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static  String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random=new Random();
    private static Logger logger= LoggerFactory.getLogger(com.sun.imageio.plugins.common.ImageUtil.class);

    /**
     * 将CommonsMultipartFile转化为File
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFile(CommonsMultipartFile cFile)  {
        File newFile=new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 处理缩略图，并返回新生成图片的相对值路径
     * @param
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName,String targetAddr){
        String realFileName=getRandomFileName();
        String extension=getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr=targetAddr+realFileName+extension;
        logger.debug("current relativeAddr is:"+relativeAddr);
        File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
        logger.debug("current complete addr is :"+PathUtil.getImgBasePath()+relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream)
                    .size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"logo.png")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到到目录，即
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
        File dirPath=new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * @param
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分秒钟+五位随机数
     * @return
     */
    public static String getRandomFileName() {
        int rannum=random.nextInt(89999)+10000;
        String nowTimeStr=sDateFormat.format(new Date());
        return nowTimeStr+rannum;
    }
}
