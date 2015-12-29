package com.shareness.web.support;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SupportAction {
	
	private static String defaultDomain = "501314.love";
	
	/**
	 * @param response
	 * @param info
	 */
	public void writeMsg2(HttpServletResponse response,int status, String msg) {
		String output  ="{\"status\":"+ status +",\"msg\":\"" + msg + "\"}";
		writeInfo(response, output);
	}
	
	/**
	 * @param response
	 * @param info
	 */
	public void writeMsg(HttpServletResponse response,boolean status, String msg) {
		String output  ="{\"status\":"+ status +",\"msg\":\"" + msg + "\"}";
		writeInfo(response, output);
	}
	
	
    public void writeInfo(HttpServletResponse response, String info) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(info);
            response.getWriter().flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
	 * 写入到cookie
	 * 
	 * @param response
	 * @param name
	 * @param value
	 * @param days
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void writeCookie(HttpServletResponse response,HttpServletRequest request, String name, String value, int days) {
		writeCookie(response, defaultDomain, name, value, days);
	}

	/**
	 * 写入到cookie
	 * 
	 * @param response
	 * @param domain
	 * @param name
	 * @param value
	 * @param days
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void writeCookie(HttpServletResponse response, String domain,
			String name, String value, int days) {

		int day = 24 * 60 * 60;
		try {
			value = URLEncoder.encode(value,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(days * day);
		cookie.setPath("/");
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}
	
	/**
	 * 清除该请求下的所有cookie
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void clearCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}

	/**
	 * 删除默认域下面的指定名称的cookie
	 * @param request
	 * @param response
	 * @param name
	 */
	public void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, String name){
		deleteCookie(request, response, defaultDomain, name);
	}
	
	/**
	 * 删除指定域下面指定名称的cookie
	 * @param request
	 * @param response
	 * @param domain
	 *         域
	 * @param name
	 *        cookie 名称
	 */
	protected void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, String domain,String name) {
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (name.equals(cookie.getName())) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
				cookie.setValue("");
				cookie.setDomain(domain);
				response.addCookie(cookie);
			}
		}
	}

	
	/**
	 * 
	 * 通过Name取得Cookie
	 * 
	 * @param request
	 * @param name
	 *            cookie名称
	 * @return
	 */

	protected static Cookie getCookieByName(HttpServletRequest request,
			String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	protected static String getCookieValueByName(HttpServletRequest request,
			String name) {
		Cookie cookie = getCookieByName(request, name);
		if (cookie == null) {
			return "";
		}
		// return EncodesUtils.urlDecode(cookie.getValue());
		return name;
	}

	/**
	 * 
	 * 读取cookie
	 * 
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
	
}


