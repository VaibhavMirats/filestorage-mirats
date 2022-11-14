package com.fileupload.miratsinsights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fileupload.miratsinsights.model.Filestorage;
import com.fileupload.miratsinsights.payload.UploadFileResponse;
import com.fileupload.miratsinsights.service.FileUploadServiceImpl;


@RestController
@RequestMapping(value = "/MIFileStorage")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FilestorageController {
	
	@Autowired
	FileUploadServiceImpl fileservice;

	@RequestMapping("/welcome")
	public String welcome() {

		return "hello this is my File Storage api in docker";
	}
	@PostMapping("/FilestorageFile")
	public UploadFileResponse FilestorageFile(@RequestParam("file") MultipartFile file,
			@RequestParam("userid") String userid,@RequestParam("admin_status") String admin_status) {
		Filestorage dbFile = fileservice.FilestorageFile(file, userid,admin_status);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/MIFileStorage/FileStoragegetFile/").path(dbFile.getId()).toUriString();

		return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize(),dbFile.getUserid(),dbFile.getAdmin_status());
	}

	@GetMapping("/FileStoragegetFile/{fileId}")
	public ResponseEntity<Resource> FileStoragegetFile(@PathVariable String fileId) {
		// Load file from database
		Filestorage dbFile = fileservice.FileStoragegetFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
				.body(new ByteArrayResource(dbFile.getData()));
	}

	@DeleteMapping("/deleteFilestorageDBFile/{id}")
	private void deleteFilestorageDBFile(@PathVariable("id") String id) {
		fileservice.deleteFilestorageDBFile(id);
	}

}
