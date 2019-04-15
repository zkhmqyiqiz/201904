package com.example.smart.util;

/**
 * <pre>
 * CRC32计算
 * </pre>
 *
 * @author  ManerFan 2015年8月4日
 */
public class CRC32 {
    /**
     * CRC32 = X32 + X26 + X23 + X22 + X16 + X12 + X11 + X10
     *  + X8 + X7 + X5 + X4 + X2 + X1 + X0 
     */

    private static final int CN = 0x04C11DB7;

    private static int[] ptiTable = new int[256];

    static {
        build(CN);
    }

    private static void build(int cn) {
        int nData = 0;
        int nAccum = 0;

        for (int i = 0; i < 256; i++) {
            nData = i << 24;
            nAccum = 0;
            for (int j = 0; j < 8; j++) {
                if (0 != ((nData ^ nAccum) & 0x80000000)) {
                    nAccum = (nAccum << 1) ^ cn;
                } else {
                    nAccum <<= 1;
                }
                nData <<= 1;
            }
            ptiTable[i] = nAccum;
        }
    }

    public static int calculate(byte[] datas) {
        int crc32 = 0xFFFFFFFF;

        if (null == datas || datas.length < 1) {
            return crc32;
        }

        for (byte data : datas) {
            crc32 = (crc32 << 8) ^ ptiTable[(crc32 >>> 24) ^ (data & 0xFF)];
        }

        return crc32;
    }
}