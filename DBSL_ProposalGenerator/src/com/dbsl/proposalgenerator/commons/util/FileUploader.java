package com.dbsl.proposalgenerator.commons.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileUploader {
	public static File file;

	public static String saveFile(String fileName, String content)
			throws IOException {
		if (StaticValues
				.initUploadDirectory(StaticValues.FILE_UPLOAD_DIRECTORY)) {
			file = new File(StaticValues.FILE_UPLOAD_DIRECTORY + "/" + fileName);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			return file.getPath();

		}
		return null;
	}

	public static File getFile(String fileName) {
		if (StaticValues
				.initUploadDirectory(StaticValues.FILE_UPLOAD_DIRECTORY)) {
			file = new File(StaticValues.FILE_UPLOAD_DIRECTORY + "/" + fileName);
		}
		return file;
	}

	public static String getContent(String fileName) throws IOException {
		File f = getFile(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String s;
		StringBuilder buffer = new StringBuilder();
		while ((s = reader.readLine()) != null)
			buffer.append(s);
		reader.close();
		return buffer.toString();
	}

}
