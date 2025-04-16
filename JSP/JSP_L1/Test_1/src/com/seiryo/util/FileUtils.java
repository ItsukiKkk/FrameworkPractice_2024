package com.seiryo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class FileUtils {
	public void writeFile(List<String[]> list, String name,String savePath) throws IOException {
		Iterator<String[]> it = list.iterator();
		FileWriter fw = null;//声明文件读写
		BufferedWriter bw = null;//声明文件读写
		boolean flag = false;
		try {
			System.out.println("写入文件开始: " + name);
			fw = new FileWriter(savePath + name + ".txt", true);//创建文件读写
			bw = new BufferedWriter(fw, 100);//创建文件读写
			String[] arr = null;
			String line = null;
			while (it.hasNext()) {
				arr = (String[]) it.next();
				line = StringUtils.join(arr, "|");
				bw.write(line);//添加内容
				bw.write("\r\n");//添加内容
			}
		} catch (IOException e) {
			System.out.println("写入文件出错: " + name+e);
			flag = false;
		} finally {
			if (bw != null) {
				bw.flush();
				bw.close();
			}
			if (fw != null)
				fw.close();
		}
	}
}
