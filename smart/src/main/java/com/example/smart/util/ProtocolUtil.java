package com.example.smart.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Created by Administrator on 2017/1/6.
 */

public class ProtocolUtil {
	static private CRC32 crc = new CRC32();
	
	/**
	 * getGuidFromByteArray
	 * 
	 * @param bytes
	 * @return UUID String
	 * @since 4
	 */
	public static String getGuidFromByteArray(byte[] bytes) {
	    ByteBuffer bb = ByteBuffer.wrap(bytes);
	    long high = bb.getLong();
	    long low = bb.getLong();
	    UUID uuid = new UUID(high,low);
	    return uuid.toString();
	}
	
	static public int crc32(byte[] data) {
		// CRC32 crc = new CRC32();
		crc.update(data);
		long newcrc = crc.getValue();
		crc.reset();
		// int ncrc = (int)(0x0000ffffL & newcrc);
		// int ncrc2 = (int)(0xffff0000L & newcrc);
		int ncrc3 = (int) (newcrc);
		return ncrc3;
	}

	public static byte[] toLH(float f) {
		return toLH(Float.floatToRawIntBits(f));
	}
	
	public static byte[] UUIDToByte(UUID uuid) {
		ByteArrayOutputStream ba = new ByteArrayOutputStream(16);
		DataOutputStream da = new DataOutputStream(ba);
		try {
			da.writeLong(uuid.getMostSignificantBits());
			da.writeLong(uuid.getLeastSignificantBits());
			//da.writeLong(uuid.getLeastSignificantBits());
			//da.writeLong(uuid.getLeastSignificantBits());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ba.toByteArray();
	}
	
	public static float bytesTofloat(byte[] b, int index) {
		int l;
		l = b[index + 0];
		l &= 0xff;
		l |= ((long) b[index + 1] << 8);
		l &= 0xffff;
		l |= ((long) b[index + 2] << 16);
		l &= 0xffffff;
		l |= ((long) b[index + 3] << 24);
		return Float.intBitsToFloat(l);
	}

	public static byte[] charToByte(char c) {
		byte[] b = new byte[1];
		// b[0] = (byte) ((c & 0xFF00) >> 8);
		b[0] = (byte) (c & 0xFF);
		return b;
	}

	public static char byteToChar(byte[] b) {
		char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
		return c;
	}

	/**
	 * 将boolean转成byte[]
	 * 
	 * @param val
	 * @return byte[]
	 */
	public static byte[] Boolean2Byte(boolean val) {
		byte[] value = new byte[1];
		if (val == false) {
			value[0] = 0;
		} else {
			value[0] = 1;
		}

		return value;
	}

	/* int -> byte[] */
	public static byte[] intToBytes(int n) {
		byte[] b = new byte[4];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		b[2] = (byte) (n >> 16 & 0xff);
		b[3] = (byte) (n >> 24 & 0xff);
		return b;

	}

	public static int stringbytelen(byte[] ary) {
		int i = 0;
		for (; i < ary.length; i++) {
			if (ary[i] == 0)
				break;
		}
		return i;
	}

	public static int bytesToInt(byte[] ary) {
		int value;
		value = (int) ((ary[0] & 0xFF) | ((ary[1] << 8) & 0xFF00) | ((ary[2] << 16) & 0xFF0000)
				| ((ary[3] << 24) & 0xFF000000));
		return value;
	}

	/* short to byte[] */
	public static byte[] shortToBytes(short num) {
		byte[] b = new byte[2];

		for (int i = 0; i < 2; i++) {
			b[i] = (byte) (num >>> (i * 8));
		}

		return b;
	}

	/* short -> byte */
	public final static byte[] getBytes(short s, boolean asc) {
		byte[] buf = new byte[2];
		if (asc)
			for (int i = buf.length - 1; i >= 0; i--) {
				buf[i] = (byte) (s & 0x00ff);
				s >>= 8;
			}
		else
			for (int i = 0; i < buf.length; i++) {
				buf[i] = (byte) (s & 0x00ff);
				s >>= 8;
			}
		return buf;
	}

	public static boolean getBoolean(byte[] b) {
		return b[0] != 0;
	}

	public static short getShortForMainCtl(byte[] b) {
		return (short) (((b[0] << 8) | b[1] & 0xff));
	}

	public static short getShort(byte[] b) {
		return (short) (((b[1] << 8) | b[0] & 0xff));
	}

	/**
	 * 注释：short到字节数组的转换！
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] shortToByte(short number) {
		int temp = number;
		byte[] b = new byte[2];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Integer(temp & 0xff).byteValue();//
			temp = temp >> 8; // 向右移8位
		}
		return b;
	}

	/**
	 * float转byte
	 * 
	 * @param f
	 * @return
	 */
	public static byte[] float2byte(float f) {

		// 把float转换为byte[]
		int fbit = Float.floatToIntBits(f);

		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (fbit >> (24 - i * 8));
		}
		// 翻转数组
		int len = b.length;
		// 建立一个与源数组元素类型相同的数组
		byte[] dest = new byte[len];
		// 为了防止修改源数组，将源数组拷贝一份副本
		System.arraycopy(b, 0, dest, 0, len);
		byte temp;
		// 将顺位第i个与倒数第i个交换
		for (int i = 0; i < len / 2; ++i) {
			temp = dest[i];
			dest[i] = dest[len - i - 1];
			dest[len - i - 1] = temp;
		}
		return dest;
	}

//	/***
//	 * 解压Zip
//	 * 
//	 * @param data
//	 * @return
//	 */
//	public static byte[] unZip(byte[] data) {
//		byte[] b = null;
//		try {
//			ByteArrayInputStream bis = new ByteArrayInputStream(data);
//			ZipInputStream zip = new ZipInputStream(bis);
//			while (zip.getNextEntry() != null) {
//				byte[] buf = new byte[1024];
//				int num = -1;
//				ByteArrayOutputStream baos = new ByteArrayOutputStream();
//				while ((num = zip.read(buf, 0, buf.length)) != -1) {
//					baos.write(buf, 0, num);
//				}
//				b = baos.toByteArray();
//				baos.flush();
//				baos.close();
//			}
//			zip.close();
//			bis.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return b;
//	}

	/**
	 * 解压被压缩的数据
	 *
	 * @param data :要解压的数据
	 * @return:还原之后的新数据
	 */
	public static byte[] unZip(byte[] data, int nRawLen) {
		Inflater decompresser = new Inflater();
		decompresser.setInput(data, 0, data.length);
		// 对byte[]进行解压，同时可以要解压的数据包中的某一段数据，就好像从zip中解压出某一个文件一样。
		byte[] result = new byte[nRawLen];
		try {
			decompresser.inflate(result);

		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} // 返回的是解压后的的数据包大小，
		decompresser.end();
		// byte[] result2 = new byte[resultLength];
		// System.arraycopy(result, 0,result2 , 0, resultLength);
		return result;
	}

	public static byte[] toLH(int n) {
		byte[] b = new byte[4];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		b[2] = (byte) (n >> 16 & 0xff);
		b[3] = (byte) (n >> 24 & 0xff);
		return b;
	}

//	public static Integer ReflectToLength(Object model)
//			throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
//		String content = "";
//		Integer copyedlen = 0;
//		for (int j = 0; j < field.length; j++) { // 遍历所有属性
//			if (field[j].getType() == typedef.class) {
//				Integer length = ((typedef) field[j].get(model)).getLength();
//				copyedlen += length;
//			}
//		}
//		return copyedlen;
//	}

//	public static void ReflectWire(MiddleTcpEntity model, byte[] data)
//			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
//		String content = "";
//		Integer copyedlen = 0;
//		for (int j = 0; j < field.length; j++) { // 遍历所有属性
//			if (field[j].getType() == typedef.class) {
//
//				Integer length = ((typedef) PropertyUtils.getProperty(model, field[j].getName())).getLength();
//				byte[] thisType = new byte[length];
//				System.arraycopy(data, copyedlen, thisType, 0, thisType.length);
//				((typedef) PropertyUtils.getProperty(model, field[j].getName())).setEntity(thisType);
//				copyedlen += thisType.length;
//			}
//			;
//		}
//	}

	/***
	 * 压缩Zip
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] zip(byte[] data) {
		byte[] b = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ZipOutputStream zip = new ZipOutputStream(bos);
			ZipEntry entry = new ZipEntry("zip");
			entry.setSize(data.length);
			zip.putNextEntry(entry);
			zip.write(data);
			zip.closeEntry();
			zip.close();
			b = bos.toByteArray();
			bos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}
	
	/**
	 * 字符串转换成为16进制(无需Unicode编码)
	 * @param str
	 * @return
	 */
	public static String strToHex(String str) {
	    char[] chars = "0123456789ABCDEF".toCharArray();
	    StringBuilder sb = new StringBuilder("");
	    byte[] bs = str.getBytes();
	    int bit;
	    for (int i = 0; i < bs.length; i++) {
	        bit = (bs[i] & 0x0f0) >> 4;
	        sb.append(chars[bit]);
	        bit = bs[i] & 0x0f;
	        sb.append(chars[bit]);
	        // sb.append(' ');
	    }
	    return sb.toString().trim();
	}

	
	/**
	 * 16进制直接转换成为字符串(无需Unicode解码)
	 * @param hexStr
	 * @return
	 */
	public static String hexToString(String hexStr) {
	    String str = "0123456789ABCDEF";
	    char[] hexs = hexStr.toCharArray();
	    byte[] bytes = new byte[hexStr.length() / 2];
	    int n;
	    for (int i = 0; i < bytes.length; i++) {
	        n = str.indexOf(hexs[2 * i]) * 16;
	        n += str.indexOf(hexs[2 * i + 1]);
	        bytes[i] = (byte) (n & 0xff);
	    }
	    return new String(bytes);
	}
	
	public static byte[] long2Bytes(long num) {
        byte[] byteNum = new byte[8];
        for (int ix = 0; ix < 8; ++ix) {
            int offset = 64 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }

    public static long bytes2Long(byte[] byteNum) {
        long num = 0;
        for (int ix = 0; ix < 8; ++ix) {
            num <<= 8;
            num |= (byteNum[ix] & 0xff);
        }
        return num;
    }
    /**
     * @param source
     * @param left
     * @param right
     */
    public static void reverse(byte[] source, int left, int right) {
        while(left < right) {
            byte tmp = source[left];
            source[left] = source[right];
            source[right] = tmp;
            left++;
            right--;
        }
    }
    /**
     * @param b
     * @return
     */
    public static String toHex(byte b) {
        String result = Integer.toHexString(b & 0xFF);
        if (result.length() == 1) {
            result = '0' + result;
        }
        return result;
    }
    
    public static byte[] guidToStr(byte[] guid){
    	 ProtocolUtil.reverse(guid, 0, 3);
    	 ProtocolUtil.reverse(guid, 4, 5);
    	 ProtocolUtil.reverse(guid, 6, 7);
		
		for(int i = 0; i<guid.length;i++){
			if(i == 4|| i==6||i==8||i==10){
				String guid01=new String(guid,0,ProtocolUtil.stringbytelen(guid));
		 		System.arraycopy(guid01, 0, guid, 0, guid.length);
				guid01 += "-";
				guid=guid01.getBytes();
			}
			String guid02=new String(guid,0,ProtocolUtil.stringbytelen(guid));
	 		System.arraycopy(guid02, 0, guid, 0, guid.length);
			guid02 += ProtocolUtil.toHex(guid[i]);	
			guid=guid02.getBytes();
		}
		return guid;
    }
   


    /**
     * 07671000-e8c9-e541-ab82-a60f4b8366c7错误
	 * 00106707-c9e8-41e5-ab82-a60f4b8366c7正确
	 * 
     * @param uuid
     * @return
     */
    public static String stringToString(String uuid) {
    	char[]id01= uuid.toCharArray();
		for(int i=0;i<id01.length;i++) {
			if(i==0) {
				char a=id01[0];
				char b=id01[1];
				id01[0]=id01[6];
				id01[1]=id01[7];
				id01[6]=a;
				id01[7]=b;
			}
			if(i==2) {
				char a=id01[2];
				char b=id01[3];
				id01[2]=id01[4];
				id01[3]=id01[5];
				id01[4]=a;
				id01[5]= b;
			}
			if(i==9) {
				char a=id01[9];
				char b=id01[10];
				id01[9]=id01[11];
				id01[10]=id01[12];
				id01[11]=a;
				id01[12]= b;
			}
			if(i==14) {
				char a=id01[14];
				char b=id01[15];
				id01[14]=id01[16];
				id01[15]=id01[17];
				id01[16]=a;
				id01[17]= b;
			}
		}
		String id02=String.valueOf(id01);
		return id02;
    }
    
    
    public static int pingDevice2(String ip) {
        Runtime runtime =Runtime.getRuntime(); // 获取当前程序的运行进对象
        Process process = null; //声明处理类对象
        String line = null; //返回行信息
        InputStream is = null; //输入流
        InputStreamReader isr = null;// 字节流
        BufferedReader br = null;
//    	String ip = "www.baidu.com";
        int res = 0;// 结果
	  	try {
	  	    process =runtime.exec("ping " + ip+" -n 1 -w 1000 "); // PING
    	    is =process.getInputStream(); // 实例化输入流
    	    isr = new InputStreamReader(is);// 把输入流转换成字节流
    	    br = new BufferedReader(isr);// 从字节中读取文本
    	    while ((line= br.readLine()) != null) {
    	    	if(line.contains("TTL")) {
    	    		res= 1;
    	    		break;
    	    	}
    	    }
    	   is.close();
    	   isr.close();
    	   br.close();
    	   if (res==1){
    	       System.out.println("ping通  ..."+ip);
    	   } else{
    	       System.out.println("ping不通..."+ip);
    	   }
    	} catch (IOException e) {
    	   System.out.println(e);
    	   runtime.exit(1);
    	  }
		return res;
    }
    
    /**
     * 字符串截取ip
     */
    public static String StringToIp(String url) {
//    	String parentString="abdk d2.2d9(,dsf ]t202.33.1.8yff";
    	String regexString=".*(\\d{3}(\\.\\d{1,3}){3}).*";
    	String IPString=url.replaceAll(regexString,"$1");
//    	System.out.println(IPString);
		return IPString;
    }
    
    /**
     * list去重
     */
    public static  List<Object>  removeDuplicate(List<Object> list){       
    	  for(int i = 0;i<list.size()-1;i++ ){       
    	      for(int j=list.size()-1 ; j > i;j --){       
    	           if(list.get(j).equals(list.get(i))){       
    	              list.remove(j);       
    	           }        
    	      }        
    	  }        
    	    return list;       
    }  
}
