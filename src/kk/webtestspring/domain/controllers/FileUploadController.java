package kk.webtestspring.domain.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import kk.webtestspring.domain.beans.UploadedFile;
import kk.webtestspring.validators.FileValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	@Autowired
	FileValidator fileValidator;

	@RequestMapping("/fileUploadForm")
	public ModelAndView getUploadForm(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			BindingResult result) {
		return new ModelAndView("uploadFile");
	}

	@RequestMapping("/fileUpload")
	public ModelAndView fileUploaded(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		MultipartFile file = uploadedFile.getFile();
		fileValidator.validate(uploadedFile, result);

		String fileName = file.getOriginalFilename();

		if (result.hasErrors()) {
			return new ModelAndView("uploadForm");
		}

		try {
			inputStream = file.getInputStream();

			File newFile = new File(fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			System.out.println(newFile.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(outputStream!=null)
					outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return new ModelAndView("showFile", "message", fileName);
	}
}
