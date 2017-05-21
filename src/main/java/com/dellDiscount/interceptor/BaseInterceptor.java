package com.dellDiscount.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class BaseInterceptor extends HandlerInterceptorAdapter {

	public String getCookie(String name, String defaultValue, HttpServletRequest request) {
		Cookie cookie = getCookieObject(name, request);
		return cookie != null ? cookie.getValue() : defaultValue;
	}

	/**
	 * Get cookie value by cookie name.
	 */
	public String getCookie(String name, HttpServletRequest request) {
		return getCookie(name, null, request);
	}

	/**
	 * Get cookie value by cookie name and convert to Integer.
	 */
	public Integer getCookieToInt(String name, HttpServletRequest request) {
		String result = getCookie(name, request);
		return result != null ? Integer.parseInt(result) : null;
	}

	/**
	 * Get cookie value by cookie name and convert to Integer.
	 */
	public Integer getCookieToInt(String name, Integer defaultValue, HttpServletRequest request) {
		String result = getCookie(name, request);
		return result != null ? Integer.parseInt(result) : defaultValue;
	}

	/**
	 * Get cookie value by cookie name and convert to Long.
	 */
	public Long getCookieToLong(String name, HttpServletRequest request) {
		String result = getCookie(name, request);
		return result != null ? Long.parseLong(result) : null;
	}

	/**
	 * Get cookie value by cookie name and convert to Long.
	 */
	public Long getCookieToLong(String name, Long defaultValue, HttpServletRequest request) {
		String result = getCookie(name, request);
		return result != null ? Long.parseLong(result) : defaultValue;
	}

	public Cookie getCookieObject(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals(name))
					return cookie;
		return null;
	}

}
