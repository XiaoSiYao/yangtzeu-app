package com.rex.yuol.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.os.Environment;

public class Path {
	// SD������״̬
	public static boolean sdcard_status = Environment.MEDIA_MOUNTED
			.equals(Environment.getExternalStorageState());
	// �����ļ�
	public static File testfile = new File(Path.sdcard2_path(), "rextest.txt");

	/**
	 * SD��·��
	 * 
	 * @return
	 */
	public static File sdcard_path() {
		if (!sdcard_status) {
			return null;
		} else {
			return Environment.getExternalStorageDirectory();
		}
	}

	/**
	 * ����SD��·��
	 * 
	 * @return
	 */
	public static File sdcard2_path() {
		if (!sdcard_status) {
			return null;
		}
		File sdcard2 = new File(Path.sdcard_path(), "../sdcard2");
		if (sdcard2.exists()) {
			return sdcard2;
		} else {
			return Path.sdcard_path();
		}
	}

	// �ļ�д�����
	public static void save_file(File file, String content) {
		FileOutputStream fops;
		try {
			fops = new FileOutputStream(file);
			fops.write(content.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
