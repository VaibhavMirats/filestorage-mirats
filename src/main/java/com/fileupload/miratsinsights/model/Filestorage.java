package com.fileupload.miratsinsights.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "filestorage")
public class Filestorage {
	
	 @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;

	    private String fileName;
	    
	    private String userid;
	    
	    private String admin_status;
	    private String fileType;

	    @Lob
	    private byte[] data;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		
		
		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getAdmin_status() {
			return admin_status;
		}

		public void setAdmin_status(String admin_status) {
			this.admin_status = admin_status;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

		public Filestorage(String fileName,String userid,String admin_status, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.userid = userid;
	        this.admin_status = admin_status;
	        this.fileType = fileType;
	        this.data = data;
	    }

		@Override
		public String toString() {
			return "filestorage [id=" + id + ", fileName=" + fileName + ", userid=" + userid + ", fileType="
					+ fileType + ", data=" + Arrays.toString(data) + "]";
		}

		public Filestorage() {
			super();
		}
		
		
	    
	    
	    


}
