package co.simplon.itp3.filestorage.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;
import co.simplon.itp3.filestorage.entities.AnonymousFile;
import co.simplon.itp3.filestorage.repositories.AnonymousFileRepository;
import co.simplon.itp3.filestorage.repositories.HttpHeaderRepository;

@Service
public class AnonymousFileServiceImpl
	implements AnonymousFileService {

    @Value("${itp3-file-storage-api.uploads.location}")
    private String uploadDir;
    private AnonymousFileRepository anonymous_files;

    public AnonymousFileServiceImpl(
	    AnonymousFileRepository anonymous_files,
	    HttpHeaderRepository http_headers) {
	this.anonymous_files = anonymous_files;
    }

    @Override
    @Async
    public FileView upload(AnonymousFileData inputs) {
	FileView view = new FileView();
	MultipartFile file = inputs.getFile();
	String baseName = UUID.randomUUID().toString();
	String fileSuffix = file.getOriginalFilename();
	String fileName = baseName + fileSuffix;
	long fileSize = file.getSize();
	String fileType = file.getContentType();
	boolean success = false;
	String errorMessage = "";

	try {
	    store(file, fileName);
	    success = true;

	} catch (IOException ex) {

	    errorMessage = ex.getMessage();
	} finally {

	    view.setName(fileName);

	    AnonymousFile anonymousFile = new AnonymousFile();
	    anonymousFile.setFileName(fileName);
	    anonymousFile.setFileType(fileType);
	    anonymousFile.setFileSize(fileSize);
	    anonymousFile.setSuccess(success);
	    anonymousFile.setErrorMessage(errorMessage);
	    anonymous_files.save(anonymousFile);
	}
	    return view;
	
    }

    private void store(MultipartFile file, String fileName)
	    throws IOException {
	Path uploadPath = Paths.get(uploadDir);
	Path target = uploadPath.resolve(fileName);

	try (InputStream in = file.getInputStream()) {
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	}
    }
}