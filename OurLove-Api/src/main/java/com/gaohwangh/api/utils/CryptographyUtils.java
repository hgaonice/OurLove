package com.gaohwangh.api.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.UUID;

/**
 * 
 * @Description: 加密工具类
 *
 */
public class CryptographyUtils {

	/**
	 * Md5加密
	 * @param str
	 * @return
	 */
	public static String encMd5(String str) {
		return new Md5Hash(str).toString();
	}
	
	/**
	 * Md5盐值加密
	 * @param str
	 * @return
	 */
	public static String encMd5(String str, String salt) { //加盐提高加密复杂度(盐字符串应妥善保管)
		return new Md5Hash(str, salt).toString();
	}
	
	/**
     * Md5加密_转换为16位
     * @param str
     * @return
     */
    public static String encMd516(String str) {
        return Md5To16((new Md5Hash(str).toString()));
    }

	/**
	 * 32位Md5转16位
	 * @param md5
	 * @return
	 */
    public static String Md5To16(String md5) {
        return (md5.substring(8, md5.length())).substring(0, (md5.substring(8, md5.length())).length()-8);
    }

    /**
     * 生成32位的随机数（大写）
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }
    
    /**
     * 获取16位UUID（大写）
     * @return
     */
    public static String getUUID16() {
        return encMd516(UUID.randomUUID().toString()).toUpperCase();
    }

}
