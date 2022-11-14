package com.fileupload.miratsinsights.payload;

public class UploadFileResponse {
	
	 private String fileName;
	    private String fileDownloadUri;
	    private String fileType;
	    private long size;
	    private String userid ;
	    private String admin_status;
	    

	    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size,String userid,String admin_status) {
	        this.fileName = fileName;
	        this.fileDownloadUri = fileDownloadUri;
	        this.fileType = fileType;
	        this.size = size;
	        this.userid = userid;
	        this.admin_status = admin_status;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }

	    public String getFileDownloadUri() {
	        return fileDownloadUri;
	    }

	    public void setFileDownloadUri(String fileDownloadUri) {
	        this.fileDownloadUri = fileDownloadUri;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public long getSize() {
	        return size;
	    }

	    public void setSize(long size) {
	        this.size = size;
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
	    
	    
	    
	    

}
