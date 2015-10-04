package com.dbsl.proposalgenerator.commons.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ImageUploadPanel extends Panel {
	public Layout panelContent;
	final Embedded image = new Embedded("Uploaded Image");
	public File file;

	public ImageUploadPanel() {
		ImageUploader receiver = new ImageUploader();
		image.setVisible(false);

		Upload upload = new Upload("Upload Image Here", receiver);
		upload.setButtonCaption("Start Upload");
		upload.addSucceededListener(receiver);
		panelContent = new VerticalLayout();
		panelContent.addComponents(upload, image);
		setContent(panelContent);
	}

	class ImageUploader implements Receiver, SucceededListener {

		public OutputStream receiveUpload(String filename, String mimeType) {
			// Create upload stream
			FileOutputStream fos = null; // Stream to write to
			try {
				// Open the file for writing.
				if (StaticValues
						.initUploadDirectory(StaticValues.IMAGE_UPLOAD_DIRECTORY))
					file = new File(StaticValues.IMAGE_UPLOAD_DIRECTORY
							+ filename);
				fos = new FileOutputStream(file);
			} catch (final java.io.FileNotFoundException e) {
				new Notification("Could not open file<br/>", e.getMessage(),
						Notification.Type.ERROR_MESSAGE)
						.show(Page.getCurrent());
				return null;
			}
			return fos; // Return the output stream to write to
		}

		public void uploadSucceeded(SucceededEvent event) {
			// Show the uploaded file in the image viewer
			image.setVisible(true);
			image.setSource(new FileResource(file));
		}
	};

	public String getImagePath() {
		return file.getPath();
	}
}
