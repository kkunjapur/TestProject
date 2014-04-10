package kk.webtestspring.domain.beans;

import java.sql.Timestamp;

import kk.webtestspring.entity.beans.BaseEntity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fileInfo")
public class FileInfoBean extends BaseEntity{
	
	private static final long serialVersionUID = 7581736879864481050L;

	private String fileName;
	
	private String fileExtension;
	
	private Float fileSize;
	
	private Timestamp fileUploadDate;
	
	private Timestamp fileReUploadDate;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Float getFileSize() {
		return fileSize;
	}

	public void setFileSize(Float fileSize) {
		this.fileSize = fileSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Timestamp getFileUploadDate() {
		return fileUploadDate;
	}

	public void setFileUploadDate(Timestamp fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}

	public Timestamp getFileReUploadDate() {
		return fileReUploadDate;
	}

	public void setFileReUploadDate(Timestamp fileReUploadDate) {
		this.fileReUploadDate = fileReUploadDate;
	}
	
	

}
