package com.example.smart.util;

import java.math.BigInteger;

public class RadixUtil {
	/**
	 * 通过判断输入的卡号中是否含有字母来判断是否是16进制，如果有字母那么就是16进制*/
	public static boolean ifHexadecimal(String str) {
		String regex1 = ".*[a-zA-z].*";  
		boolean result = str.matches(regex1);
		return result;
	}
	
	/**
	 * 将大端16进制的字符串转为大端10进制的数*/
	public static String hexadecimalToDecimal(String str)  {
		String result = new BigInteger(str, 16).toString(10);
		return  result;
	}
	
	/**
	 * 将大端10进制的字符串转为大端16进制的数*/
	public static String decimalToHexadecimal(String str)  {
		String result = new BigInteger(str, 10).toString(16);
		return  result;
	}
	
	/**
	 * 将大端16进制的字符串转为小端16进制的数*/
	public static String maxHexadecimalTomixHexadecimal(String str)  {
		String result = new BigInteger(str, 10).toString(16);
		return  result;
	}
	
	public static long ToRevHex(long hex) {
        long result = 0;
        result |= (hex >> 24);
        result |= ((hex >> 8) & 0xff00);
        result |= ((hex << 8) & 0xff0000);
        result |= ((hex << 24) & 0xff000000L);
        System.out.printf("%02x\n", result);
        return result;
    }
	
	/**
	 * 通过读取jdbc.properties中iconfiguration的值（默认为1），将对应的16进制转为long类型，或10进制转为long类型*/
	public static Long saveData(String cardid) {
		Long tempt = 0L;
		//读取配置文件中的录入配置
		String tempTime =FtpUtils.getProperties("jdbc.properties", "iconfiguration");
		int a = Integer.parseInt(tempTime);
		if(a == 1) {//如果a的值为1，那么判断是否有字母，有字母默认是卡号显示16进制
			//判断卡号中是否含有字母
			boolean flag = RadixUtil.ifHexadecimal(cardid);
			if(flag == true) {
				//将16进制转为Long类型
				BigInteger bi = new BigInteger(cardid, 16);
				tempt = bi.longValue();
			}
			else
			{
				tempt = Long.parseLong(cardid);
			}
		}else if(a == 2) {//如果a的值为2，默认卡号显示是10进制
			tempt = Long.parseLong(cardid);
		}else {//如果a的值为3，默认卡号显示是16进制
			//将16进制转为Long类型
			BigInteger bi = new BigInteger(cardid, 16);
			tempt = bi.longValue();
		}
		return tempt;
	}

}
