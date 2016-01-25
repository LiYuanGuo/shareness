package com.shareness.web.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.shareness.domain.Site;
import com.shareness.service.SiteService;
import com.shareness.web.support.SupportAction;

/**
 *@Copy Right Information  501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2015年12月28日
 */
@Controller
@RequestMapping("site")
public class SiteController extends SupportAction{
	
	@Resource
	private SiteService siteService;
	
	/**
	 * 景点详情
	 * @param response
	 * @param siteId
	 */
	@RequestMapping("siteDetail")
	public void siteDetail(HttpServletResponse response,Long siteId){
		Site site=null;
		site=siteService.queryById(siteId);
		if(site==null){
			writeMsg2(response, 9,"查询异常");
		}else{
			String siteStr=JSONObject.toJSONString(site);
			writeInfo(response, siteStr);
		}
	}
	
	/**
	 * 查询指定数量的正热推荐的景点
	 * @param response
	 */
	@RequestMapping("topSite")
	public void topSite(HttpServletResponse response){
		List<Site> siteList=new ArrayList<Site>();
		siteList=siteService.queryTopSite(4);
		if(siteList==null){
			writeMsg2(response, 9, "查询出现异常!");
		}else{
			String siteListStr=JSONObject.toJSONString(siteList);
			writeInfo(response, siteListStr);
		}
	}
	
	/**
	 * 上传图片
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	@RequestMapping("/doUploadFile")
    public String doUploadFile(HttpServletRequest request,HttpServletResponse response, Model model,HttpSession session){

        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile file = multipartRequest.getFile("image");
        // 获得文件名：
        System.out.println("开始");  
       // String path = request.getSession().getServletContext().getRealPath("upload");  
        String path = "shareness-web/upload";
        String fileName = file.getOriginalFilename(); 
     // 获取图片的扩展名
        String extensionName = fileName
                .substring(fileName.lastIndexOf(".") + 1);
        // 新的图片文件名 = 获取时间戳+"."图片扩展名
        String newFileName = String.valueOf(System.currentTimeMillis())
                + "." + extensionName;
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        File targetFile = new File(path, newFileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileUrl", targetFile.getAbsoluteFile());  
        System.out.println(targetFile.getAbsoluteFile());
        return "site/result";  
    }
	
}
