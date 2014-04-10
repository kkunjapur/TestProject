package kk.webtestspring.domain.beans;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {
	
	private MultipartFile multipartFile;

	public MultipartFile getFile() {
		return multipartFile;
	}

	public void setFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
