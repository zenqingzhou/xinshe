//package com.xinshe.web.common.util.upload;
//
//import com.bidewu.kaipan.common.constant.RestfulServiceErrorCodeEnum;
//import com.bidewu.kaipan.common.restmodel.AgentApiResult;
//import com.google.gson.Gson;
//import com.qiniu.common.Zone;
//import com.qiniu.http.Response;
//import com.qiniu.storage.Configuration;
//import com.qiniu.storage.UploadManager;
//import com.qiniu.storage.model.DefaultPutRet;
//import com.qiniu.util.Auth;
//import org.apache.commons.lang3.ArrayUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.URLEncoder;
//import java.util.UUID;
//
///**
// * zhangjinglei 2017/9/6 下午2:53
// */
//@Component
//public class UploadUtil {
//
//    private static final String PIC_STYLE = "-mask2";
//
//    private static final Logger logger = LoggerFactory.getLogger(UploadUtil.class);
//
//    private static String qiniu_Access_key;
//    @Value("${qiniu.access_key}")
//    public void setQiniu_Access_key(String v){
//        qiniu_Access_key=v;
//    }
//
//    private static String qiniu_Secret_key;
//    @Value("${qiniu.secret_key}")
//    public void setQiniu_Secret_key(String a) {
//        qiniu_Secret_key = a;
//    }
//
//    private static String qiniu_bucketname;
//    @Value("${qiniu.houseimg_buckname}")
//    public void setQiniu_bucketname(String a) {
//        qiniu_bucketname = a;
//    }
//
//    /**
//     * 身份证上传bucket
//     */
//    private static String idCardBucketName;
//
//    @Value("${qiniu.secret_buckname}")
//    public void setIdCardBucketName(String bucketName) {
//        idCardBucketName = bucketName;
//    }
//
//    /**
//     * 上传临时文件夹
//     */
//    private static String tempDir;
//    @Value("${img.temp.dir}")
//    public void setTempDir(String dir) {
//        tempDir = dir;
//    }
//
//    /**
//     * 身份证上传的七牛域名
//     */
//    private static String idCardQiNiuDomain;
//    @Value("${idcard.qiniu.domain}")
//    public void setIdCardQiNiuDomain(String domain) {
//        idCardQiNiuDomain = domain;
//    }
//
//    private static String qiniu_houseimg_path;
//    @Value("${qiniu.houseimg_directory}")
//    public void setQiniu_houseimg_path(String a) {
//        qiniu_houseimg_path = a;
//    }
//
//    @Value("${qiniu.img_domain}")
//    public String qiniuImgDomain;
//
//    private static Auth qiniu_auth=null;
//    private static Configuration qiniu_conf;
//
//    /**
//     * 允许的文件类型
//     */
//    private static String allowFileType;
//
//    @Value("${allow_file_type}")
//    public void setAllowFileType(String allowFileType) {
//        this.allowFileType = allowFileType;
//    }
//
//    /**
//     * 上传图片大小限制
//     */
//    private static Integer maxLength;
//
//    /**
//     * 身份证大小限制
//     */
//    private static Integer idCardMaxSize;
//
//    @Value("${img_maxlength}")
//    public void setMaxLength(Integer maxLength) {
//        this.maxLength = maxLength;
//    }
//
//    @Value("${idcard_maxlength}")
//    public void setIdCardMaxSize(Integer idCardMaxSize) {
//        this.idCardMaxSize = idCardMaxSize;
//    }
//
//    private static void init_qiniu(){
//        qiniu_auth=Auth.create(qiniu_Access_key, qiniu_Secret_key);
//        Zone z = Zone.zone1();
//        qiniu_conf= new Configuration(z);
//    }
//
//    /**
//     * 上传房源图片
//     * @param filename
//     * @param data
//     * @return
//     */
//    public static String uploadImg(String filename, byte[] data){
//        return upload(qiniu_houseimg_path, filename, data);
//    }
//
//    /**
//     * 上传excel
//     * @param filename
//     * @param data
//     * @return
//     */
//    public static String uploadErrorExcel(String filename,byte[] data){
//        return upload("/errorexcel",filename,data);
//    }
//
//    private static String upload(String path, String filename, byte[] data){
//        if(qiniu_auth==null){
//            init_qiniu();
//        }
//
//
//        ///////////////////////指定上传的Zone的信息//////////////////
//        //第一种方式: 指定具体的要上传的zone
//        //注：该具体指定的方式和以下自动识别的方式选择其一即可
//        //要上传的空间(bucket)的存储区域为华东时
//        // Zone z = Zone.zone0();
//        //要上传的空间(bucket)的存储区域为华北时
//        // Zone z = Zone.zone1();
//        //要上传的空间(bucket)的存储区域为华南时
//        // Zone z = Zone.zone2();
//
//        //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
//        String fileKey =StringUtils.strip(path,"/")+"/"+StringUtils.strip(filename,"/");
//        //创建上传对象
//        UploadManager uploadManager = new UploadManager(qiniu_conf);
//        String token = qiniu_auth.uploadToken(qiniu_bucketname);
//        try {
//            Response r = uploadManager.put(data, fileKey, token);
//
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//            return null;
//        }
//        return fileKey;
//    }
//
//    /**
//     * 图片上传
//     * @param file
//     * @return
//     */
//    public static AgentApiResult uploadImage(MultipartFile file) {
//
//        //图片大小超出限制
//        if (file.getSize() < 0 || file.getSize() > maxLength) {
//
//            return AgentApiResult.Fail(RestfulServiceErrorCodeEnum.IMAGE_SIZE_BEYOND_LIMIT);
//        }
//
//        //图片格式不正确
//        String filename = file.getOriginalFilename();
//        String extName = filename.substring(filename.lastIndexOf("."));
//        String[] allowExtName = allowFileType.split("\\|");
//        if (null == allowExtName || 0 == allowExtName.length
//                || !ArrayUtils.contains(allowExtName,extName)) {
//
//            return AgentApiResult.Fail(RestfulServiceErrorCodeEnum.IMAGE_FORMAT_INCORRECT);
//        }
//
//        if(qiniu_auth==null){
//            init_qiniu();
//        }
//
//        String upToken = qiniu_auth.uploadToken(qiniu_bucketname);
//
//        //构造一个带指定Zone对象的配置类
//        Configuration cfg = new Configuration(Zone.zone1());
//        UploadManager uploadManager = new UploadManager(cfg);
//
//        //生成uuid作为文件名称
//        String uuid = UUID.randomUUID().toString().replaceAll("-","");
//        //获得文件类型（可以判断如果不是图片，禁止上传）
//        String contentType = file.getContentType();
//        //获得文件后缀名称
//        String key = uuid + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//
//        AgentApiResult result;
//        try {
//            byte[] data = file.getBytes();
//            Response response = uploadManager.put(data, key, upToken);
//            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//
//            result = AgentApiResult.build(putRet);
//        } catch (IOException e) {
//            logger.error("图片上传失败", e);
//            return AgentApiResult.Fail(RestfulServiceErrorCodeEnum.IMAGE_UPLOAD_FAIL);
//        }
//
//        return result;
//    }
//
//    /**
//     * 身份证照片上传工具类
//     * @param file
//     * @return
//     */
//    public static AgentApiResult uploadIdCardPhoto(MultipartFile file) {
//
//        //图片大小超出限制
//        if (file.getSize() < 0 || file.getSize() > idCardMaxSize) {
//
//            return AgentApiResult.Fail(RestfulServiceErrorCodeEnum.IMAGE_SIZE_BEYOND_LIMIT);
//        }
//
//        //图片格式不正确
//        String filename = file.getOriginalFilename();
//        String extName = filename.substring(filename.lastIndexOf("."));
//        String[] allowExtName = allowFileType.split("\\|");
//        if (null == allowExtName || 0 == allowExtName.length
//                || !ArrayUtils.contains(allowExtName,extName)) {
//
//            return AgentApiResult.Fail(RestfulServiceErrorCodeEnum.IMAGE_FORMAT_INCORRECT);
//        }
//
//        if(qiniu_auth==null){
//            init_qiniu();
//        }
//
//        String upToken = qiniu_auth.uploadToken(idCardBucketName);
//
//        //构造一个带指定Zone对象的配置类
//        Configuration cfg = new Configuration(Zone.zone1());
//        UploadManager uploadManager = new UploadManager(cfg);
//
//        //生成uuid作为文件名称
//        String uuid = UUID.randomUUID().toString().replaceAll("-","");
//        //获得文件类型（可以判断如果不是图片，禁止上传）
//        String contentType = file.getContentType();
//        //获得文件后缀名称
//        String key = uuid + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//
//        //上传临时文件夹
//        uploadImageTempDir(file, key);
//
//        AgentApiResult result;
//        try {
//            byte[] data = file.getBytes();
//            Response response = uploadManager.put(data, key, upToken);
//            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//
//            ImageUpload imageUpload = new ImageUpload();
//            //可下载的私有空间地址
//            imageUpload.setImgUrl(privateDownloadUrl(key));
//            imageUpload.setFileName(key);
//
//            // 对字节数组Base64编码
//            // 返回Base64编码过的字节数组字符串
////            String base64Img = Base64.encodeBase64String(data);
////
////            imageUpload.setBase64Img(base64Img);
//
//            result = AgentApiResult.build(imageUpload);
//        } catch (IOException e) {
//            logger.error("图片上传失败", e);
//            return AgentApiResult.Fail(RestfulServiceErrorCodeEnum.IMAGE_UPLOAD_FAIL);
//        }
//
//        return result;
//    }
//
//    /**
//     * 上传图片至临时文件夹
//     * @return
//     */
//    public static void uploadImageTempDir(MultipartFile file, String path) {
//        try {
//            File f = new File(tempDir);
//            if (!f.exists()) {
//                f.mkdir();
//            }
//            String imgPath = f + "/" + path;
//            // 复制文件
//            InputStream is = file.getInputStream();
//            FileOutputStream fos = new FileOutputStream(imgPath);
//            byte b[] = new byte[1024 * 1024];
//            int length = 0;
//            while (-1 != (length = is.read(b))) {
//                fos.write(b, 0, length);
//            }
//            fos.flush();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取图片分辨率
//     * @param file
//     * @return
//     */
//    public static String getImageResolution(MultipartFile file) {
//
//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(file.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int srcWidth = image .getWidth();      // 源图宽度
//        int srcHeight = image .getHeight();    // 源图高度
//
//        return srcWidth + "X" + srcHeight;//分滨率格式 400X600
//    }
//
//    /**
//     * 下载私有空间文件
//     * @param fileName
//     * @return
//     */
//    public static String privateDownloadUrl(String fileName) {
//
//        if (StringUtils.isNotEmpty(fileName)) {
//            String encodedFileName = null;
//            try {
//                encodedFileName = URLEncoder.encode(fileName + PIC_STYLE, "utf-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            String publicUrl = String.format("%s/%s", idCardQiNiuDomain, encodedFileName);
//
//            if(qiniu_auth==null){
//                init_qiniu();
//            }
//
//            long expireInSeconds = 60;//1小时，可以自定义链接过期时间
//            String finalUrl = qiniu_auth.privateDownloadUrl(publicUrl, expireInSeconds) ;
//
//            return finalUrl;
//        }
//
//        return null;
//    }
//}
