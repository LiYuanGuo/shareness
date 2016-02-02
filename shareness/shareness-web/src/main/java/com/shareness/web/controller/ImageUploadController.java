/**
 * 
 */
package com.shareness.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.shareness.web.support.SupportAction;

/**
 * 图片上传信息的获取和分配
 *
 */
@Controller
@RequestMapping("/qiniu")
public class ImageUploadController extends SupportAction{

	/**
	 * 获取七牛上传的token
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="getToken")
	public void getToken(HttpServletResponse response)throws Exception{
		String token = getToken();
		Map<String,String> map= new HashMap<String,String>();
		map.put("uptoken",token);
		writeInfo(response, JSONObject.toJSONString(map));
	}
	
	/**
	 * 获得带回调方式的token,当Web端文件上传成功后，浏览器执行303跳转的URL。可以用于解决跨域问题
	 * @see http://developer.qiniu.com/docs/v6/api/reference/security/put-policy.html
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="getTokenCallback")
	public void getTokenCallback(HttpServletResponse response)throws Exception{
		
		String token = getTokenWithCallbackUrl();
		Map<String,String> map= new HashMap<String,String>();
		map.put("uptoken",token);
		writeInfo(response, JSONObject.toJSONString(map));
	}
	
	/**
	 * 图片上传回调方法
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	@RequestMapping("/callback")
	public void callbak( HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		
		String upload_ret = request.getParameter("upload_ret");
		if(upload_ret != null && !upload_ret.equals("")){
			upload_ret = new String(Base64.decode(upload_ret, 1),"utf-8");
			JSONObject jo = JSONObject.parseObject(upload_ret);
			String key = jo.getString("key");
			jo.put("url", "http://7xqmgd.com1.z0.glb.clouddn.com/" + key);
			jo.put("error", 0);
			writeInfo(response, jo.toJSONString());
			return;
		 }else{
			 upload_ret = "{\"error\":1,\"message\":\"图片上传失败！\"}";
		 }
		
		writeInfo(response, upload_ret);
	}
	
	public String getToken(){
		String ACCESS_KEY = "DVkCXM2pg7IXuOchBrH5E6Y_XLoyZNISNiAxv7cV";
		String SECRET_KEY = "VAiCidzv8ZZ1KLAr2YPq_9UEgDoXJVIx7GFaNJmw";
		String bucket = "shareness";
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		return auth.uploadToken(bucket);
	}
	
	public String getTokenWithCallbackUrl(){
		String ACCESS_KEY = "DVkCXM2pg7IXuOchBrH5E6Y_XLoyZNISNiAxv7cV";
		String SECRET_KEY = "VAiCidzv8ZZ1KLAr2YPq_9UEgDoXJVIx7GFaNJmw";
		String bucket = "shareness";
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String callbackBody = "key=$(key)&hash=$(etag)";
		String callbackHost = "";
		String callbackUrl ="";
		
		return auth.uploadToken(bucket, null, 3600, new StringMap().put("callbackUrl", callbackUrl).putNotEmpty("callbackHost", callbackHost).put("callbackBody", callbackBody));
	}
	
}
