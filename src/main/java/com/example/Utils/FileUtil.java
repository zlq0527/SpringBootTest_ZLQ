package com.example.Utils;
/**
 * @ Author     ：赵棱泉.
 * @ Date       ：Created in 13:07 2022/3/6
 * @ Description：
 */
public class FileUtil {
	// 图片允许的后缀扩展名
	public static String[] IMAGE_FILE_EXTD = new String[] { "png", "bmp", "jpg", "jpeg","pdf" };

	public static boolean isFileAllowed(String fileName) {
		for (String ext : IMAGE_FILE_EXTD) {
			if (ext.equals(fileName)) {
				return true;
			}
		}
		return false;
	}
}
