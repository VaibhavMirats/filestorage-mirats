package com.fileupload.miratsinsights.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fileupload.miratsinsights.model.Filestorage;


public interface FileStorageDBFileRepository extends JpaRepository<Filestorage, String> {

	@Query("SELECT l FROM Filestorage l WHERE id=:fileId")
	public Optional<Filestorage> FilefindByUId(@Param("fileId") String fileId);

}
