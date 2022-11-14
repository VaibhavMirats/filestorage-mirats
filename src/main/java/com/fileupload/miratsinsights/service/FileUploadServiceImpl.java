package com.fileupload.miratsinsights.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.miratsinsights.filedemo.exception.FileStorageException;
import com.fileupload.miratsinsights.filedemo.exception.MyFileNotFoundException;
import com.fileupload.miratsinsights.model.Filestorage;
import com.fileupload.miratsinsights.repository.FileStorageDBFileRepository;

@Service("fileservice")
@Transactional
public class FileUploadServiceImpl  implements FileUploadService{
	
	@Autowired
	FileStorageDBFileRepository FileRepository;

	@Override
	public Filestorage FilestorageFile(MultipartFile file, String userid,String admin_status) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		
			try {
				// Check if the file's name contains invalid characters
				if (fileName.contains("..")) {
					throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
				}

				Filestorage dbFile = new Filestorage(fileName, userid,admin_status, file.getContentType(), file.getBytes());

				return FileRepository.save(dbFile);
			} catch (IOException ex) {
				throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
			}
	}

	@Override
	public Filestorage FileStoragegetFile(String fileId) {
		// TODO Auto-generated method stub
		return FileRepository.FilefindByUId(fileId)
				.orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	}

	@Override
	public void deleteFilestorageDBFile(String id) {
		// TODO Auto-generated method stub
		FileRepository.deleteById(id);
	}

}
