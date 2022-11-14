package com.fileupload.miratsinsights.service;

import org.springframework.web.multipart.MultipartFile;

import com.fileupload.miratsinsights.model.Filestorage;



public interface FileUploadService {
	
	public Filestorage FilestorageFile(MultipartFile file, String username,String admin_status);

	public Filestorage FileStoragegetFile(String fileId);

	public void deleteFilestorageDBFile(String id);

}
