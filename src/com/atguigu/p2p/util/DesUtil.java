package com.atguigu.p2p.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DesUtil {

	private final static String DES = "DES";
	// 自定义密钥
	public final static String key = "zedkaOCJ72p&LHWyNdadOKry1YqXj2";

	public static void main(String[] args) throws Exception {

		// 请求参数组成结构(前缀标识:平台用户帐号:平台用户密码:数据客户端帐号:数据客户端密码:时间戳)
		// 一共六个参数,先后顺序不能错，任意一个参数校验失败将无法登录。
		//String data ="1"; 

		/*String data ="xforceplus:jialefu:JLF0001:"+System.currentTimeMillis();
//		String data = "xforceplus:admin:q1w2e3r4:DA100302:DA100302:"+System.currentTimeMillis();
		// 自定义密钥加密
		String dataEcrypt = encrypt(data, key);
		System.out.println(dataEcrypt);
		// 加密后进行URL转码
		String dataUrlEncode = urlEncode (dataEcrypt);
		// 加密转码后的结果
		System.out.println(dataUrlEncode);*/
       /*
		System.out.println("");
		
		// URL反转码
		String dataUrlDecode = urlDecode(dataUrlEncode);	
		// 自定义密钥解密
		String dataDecrypt = decrypt(dataUrlDecode, key);
		// 反转码解码后的结果
		System.out.println(dataDecrypt);

		// 生成时间戳 如：1440129488646
		System.out.println(System.currentTimeMillis());
*/
		String dataUrlDecode = urlDecode("YoO45SINRHg8tSKMzuVt7ddjchTinZ%2BrBV3ja%2Ff3gixz8K8WFp%2Bb3TTzbgx8Fuohh%2F%2B2wXt8j15H%0A5PYKbxu0kLp92Dvt4T7jVL%2F%2FWYcA5J8%3D");	
		// 自定义密钥解密
		String dataDecrypt = decrypt(dataUrlDecode, key);
		// 反转码解码后的结果
		System.out.println(dataDecrypt);
		
		
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
 	public static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String strs = new BASE64Encoder().encode(bt);
		return strs;
	} 

	/**
	 * Description 转urlEncode
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String urlEncode(String data) throws Exception {
		return URLEncoder.encode(data, "utf-8");
	}

	/**
	 * Description 反转转urlEncode
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String urlDecode(String data) throws Exception {
		return URLDecoder.decode(data, "utf-8");
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static String decrypt(String data, String key) throws IOException,
			Exception {
		if (data == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = decoder.decodeBuffer(data);
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt);
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}


    public String encryptWithDefaultKey(String datas) throws Exception{
    	String data=datas+System.currentTimeMillis();
    	// 自定义密钥加密
    	String dataEcrypt = encrypt(data, key);
    	// 加密后进行URL转码
    	String dataUrlEncode = urlEncode(dataEcrypt);
    	return dataUrlEncode;
    }

}