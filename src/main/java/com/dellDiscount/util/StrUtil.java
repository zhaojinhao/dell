package com.dellDiscount.util;

import java.io.IOException;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StrUtil extends StrKit {
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(StrUtil.class);

	static final char[] hexDigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };
	static final char[] digits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	static final Random rand = new Random();
	static final String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	static final String phoneCheck = "^1[3-5,7,8]{1}[0-9]{9}";
	public static boolean isEmail(String email) {
		if (isBlank(email)) {
			return false;
		} else {
			Pattern pattern = Pattern.compile(check);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		}
	}

	public static boolean isPhone(String phone){
		if(isBlank(phone))
			return false;
		else {
			Pattern pattern = Pattern.compile(phoneCheck);
			Matcher matcher = pattern.matcher(phone);
			return matcher.matches();
		}
	}

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}

	public static String randomString(int length) {
		StringBuffer sb = new StringBuffer();
		for (int loop = 0; loop < length; ++loop) {
			sb.append(hexDigits[rand.nextInt(hexDigits.length)]);
		}
		return sb.toString();
	}

	public static String randomNumber(int length) {
		StringBuffer sb = new StringBuffer();
		for (int loop = 0; loop < length; ++loop) {
			sb.append(digits[rand.nextInt(digits.length)]);
		}
		return sb.toString();
	}



	

	public static String noHtml(String s) {
		if (isBlank(s))
			return "";
		else
			return s.replaceAll("<[.[^<]]*>", "");
	}

	public static String transHtml(String s) {
		if (isBlank(s))
			return "";
		else
			return s.replace("<", "&lt;").replace(">", "&gt;");
	}

	public static List<String> fetchUsers(String str) {
		List<String> ats = new ArrayList<String>();
		String pattern = "@([a-zA-Z_0-9-/b]+)\\s";
		Pattern regex = Pattern.compile(pattern);
		Matcher regexMatcher = regex.matcher(str);
		while (regexMatcher.find()) {
			ats.add(regexMatcher.group(1));
		}
		return ats;
	}

	public static int str2int(String s) {
		if (s == null || s.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(s);
		}
	}

	/**
	 * json字符串转换成 Map 依赖Gson包
	 */
	public static Map<String, Object> parseToMap(String jsonString) {
		return new Gson().fromJson(jsonString, new TypeToken<HashMap<String, Object>>() {
		}.getType());
	}

	public static String encryptOfSHA512(String strText) {
		return SHA(strText, "SHA-512");
	}

	/**
	 * 字符串 SHA512 加密
	 * 
	 * @param strSourceText
	 * @return
	 */
	public static String SHA(final String strText, final String strType) {
		String strResult = null;

		if (strText != null && strText.length() > 0) {
			try {
				MessageDigest messageDigest = MessageDigest.getInstance(strType);
				messageDigest.update(strText.getBytes());
				byte byteBuffer[] = messageDigest.digest();
				StringBuffer strHexString = new StringBuffer();
				for (int i = 0; i < byteBuffer.length; i++) {
					String hex = Integer.toHexString(0xff & byteBuffer[i]);
					if (hex.length() == 1) {
						strHexString.append('0');
					}
					strHexString.append(hex);
				}
				strResult = strHexString.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return strResult;
	}

	public static String toJson(Object obj) {
		StringWriter sw = new StringWriter();

		try {
			@SuppressWarnings("deprecation")
			JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
			mapper.writeValue(gen, obj);
			gen.close();
		} catch (JsonGenerationException e) {
			logger.error("", e);
		} catch (JsonMappingException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		String json = sw.toString();

		return json;
	}

	public static void main(String[] args) {
		// System.out.println(getEncryptionToken("d1ec214a68524107828427221c346b51"));
		System.out.println(randomNumber(6));
	}

}
