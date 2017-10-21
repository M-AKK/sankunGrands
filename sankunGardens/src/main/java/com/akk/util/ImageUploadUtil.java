package com.akk.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @ClassName: ImageUploadUtil
 * @Description: 图片上传工具类，包括ckeditor操作
 */
public class ImageUploadUtil {


    //加载绝对路径
    @Value("${adImage.savePath}")
    private static String adImageSavePath;
    //访问路径
    @Value("${adImage.url}")
    private static String adImageUrl;

    // 图片类型
    private static List<String> fileTypes = new ArrayList<String>();

    static {
        fileTypes.add(".jpg");
        fileTypes.add(".jpeg");
        fileTypes.add(".bmp");
        fileTypes.add(".gif");
        fileTypes.add(".png");
    }

    /**
     * 图片上传
     *
     * @Title upload
     * @param request
     * @param DirectoryName
     *            文件上传目录：比如upload(无需带前面的/) upload/news ..
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String upload(HttpServletRequest request, String DirectoryName) throws IllegalStateException, IOException {

        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        // 图片名称
        String fileName = null;
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 记录上传过程起始时的时间，用来计算上传时间
                // int pre = (int) System.currentTimeMillis();
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 获得图片的原始名称
                        String originalFilename = file.getOriginalFilename();
                        // 获得图片后缀名称,如果后缀不为图片格式，则不上传
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
                        if (!fileTypes.contains(suffix)) {
                            continue;
                        }
                        // 获得上传路径的绝对路径地址(/upload)-->
                        String realPath = request.getSession().getServletContext().getRealPath("/" + DirectoryName);
                        //String realPath = adImageSavePath;
                        System.out.println(realPath);
                        // 如果路径不存在，则创建该路径
                        File realPathDirectory = new File(realPath);
                        if (realPathDirectory == null || !realPathDirectory.exists()) {
                            realPathDirectory.mkdirs();
                        }
                        // 重命名上传后的文件名 111112323.jpg
                        fileName = System.currentTimeMillis() + "_" + originalFilename;
                        //fileName = DateUtil.format(new Date(), DateUtil.DATE_FORMAT_1) + suffix;
                        // 定义上传路径 .../upload/111112323.jpg
                        File uploadFile = new File(realPathDirectory + "\\" + fileName);
                        System.out.println(uploadFile);
                        file.transferTo(uploadFile);
                    }
                }
                // 记录上传该文件后的时间
                // int finaltime = (int) System.currentTimeMillis();
                // System.out.println(finaltime - pre);
            }
        }
        return fileName;
    }

    /**
     * ckeditor文件上传功能，回调，传回图片路径，实现预览效果。
     *
     * @Title ckeditor
     * @param request
     * @param response
     * @param DirectoryName
     *            文件上传目录：比如upload(无需带前面的/) upload/..
     * @throws IOException
     */
    public static void ckeditor(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
        String fileName = upload(request, DirectoryName);
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        String imageContextPath = request.getContextPath() + "/" + DirectoryName + "/" + fileName;
        System.out.println(imageContextPath);
        //String imageContextPath = adImageUrl + fileName;
        response.setContentType("text/html;charset=UTF-8");
        String callback = request.getParameter("CKEditorFuncNum");
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
        out.println("</script>");
        out.flush();
        out.close();
    }

}


   /* Map<String,Object> map = new HashMap<String, Object>();
    String realName = null;
    String uuidName = null;
    String realPath = null;


    String fileName = System.currentTimeMillis() + "_" + file1.getOriginalFilename();

    File file = new File(adImageSavePath + fileName);

    File fileFolder = new File(adImageSavePath);//new一个这个文件夹
            if (!fileFolder.exists()) {//判断这个文件夹是否存在
                    fileFolder.mkdirs();//不存在就生成一个这个文件夹
                    }
                    try {
                    file1.transferTo(file);
                    //Image image  = new Image();
                    //文件原来的名称
                    realName = file1.getOriginalFilename();
                    //得到这个文件的uuidname
                    //uuidName = this.getUUIDFileName(file.getOriginalFilename());
                    //图片保存的工程
                    // realPath = request.getServletContext().getRealPath("/images");
                    //真实路径
                    //String roolPath = request.getSession().getServletContext().getRealPath("/");
            *//*image.setName(realName);
            image.setUrl(roolPath);
            image.setUuidname(uuidName);

            //得到文件的输入流
            InputStream in = new BufferedInputStream(file.getInputStream());
            //获得文件的输出流
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(realPath,uuidName)));

            IOUtils.copy(in, out);
            in.close();
            out.close();
            //将图片信息传递到我的数据库当中
            int flag = imageService.insertImage(image);*//*

                    //if(flag!=0){
                    map.put("state", "SUCCESS");// UEDITOR的规则:不为SUCCESS则显示state的内容
                    map.put("url",adImageSavePath+fileName);         //能访问到你现在图片的路径
                    map.put("title","123");
                    map.put("original","realName" );
                    //}
                    } catch (IOException e) {

                    map.put("state", "文件上传失败!"); //在此处写上错误提示信息，这样当错误的时候就会显示此信息
                    map.put("url","");
                    map.put("title", "");
                    map.put("original", "");
                    e.printStackTrace();
                    }
                    return map;
                    }


//下面是我的两个方法，取的uuidname防止文件同名问题
private String getExtName(String s, char split) {
        int i = s.lastIndexOf(split);
        int leg = s.length();
        return i > 0 ? (i + 1) == leg ? " " : s.substring(i+1, s.length()) : " ";
        }

private String getUUIDFileName(String fileName){
        UUID uuid = UUID.randomUUID();
        StringBuilder sb = new StringBuilder(100);
        sb.append(uuid.toString()).append(".").append(this.getExtName(fileName, '.'));
        return sb.toString();
//        }
*/