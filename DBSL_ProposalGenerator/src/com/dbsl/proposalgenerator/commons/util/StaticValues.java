package com.dbsl.proposalgenerator.commons.util;

import java.io.File;

public abstract class StaticValues {

	public static final String PERSISTENCE_UNIT = "dbsl";
	public static final String IMAGE_UPLOAD_DIRECTORY = System
			.getProperty("catalina.home") + "/temp/uploads/images";
	public static final String FILE_UPLOAD_DIRECTORY = System
			.getProperty("catalina.home") + "/temp/uploads/files";

	public static boolean initUploadDirectory(String uploadPath) {
		File file = new File(uploadPath);
		if (file.exists())
			return true;
		else
			return file.mkdirs();
	}
}
