package co.simplon.itp3.filestorage.services;

import static org.assertj.core.api.Assertions.in;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;
import co.simplon.itp3.filestorage.entities.AnonymousFile;
import co.simplon.itp3.filestorage.entities.HttpHeader;
import co.simplon.itp3.filestorage.repositories.AnonymousFileRepository;
import co.simplon.itp3.filestorage.repositories.HttpHeaderRepository;

@Service
public class AnonymousFileServiceImpl
	implements AnonymousFileService {

    @Value("${itp3-file-storage-api.uploads.location}")
    private String uploadDir;
    private AnonymousFileRepository anonymousFiles;
    private HttpHeaderRepository httpHeaders;

    public AnonymousFileServiceImpl(
	    AnonymousFileRepository anonymousFiles,
	    HttpHeaderRepository httpHeaders) {
	this.anonymousFiles = anonymousFiles;
	this.httpHeaders = httpHeaders;
    }

    @Override
    @Async
    public CompletableFuture<FileView> upload(
	    @RequestHeader Map<String, String> headers,
	    AnonymousFileData inputs) {
	FileView view = new FileView();
	MultipartFile file = inputs.getFile();
	String baseName = UUID.randomUUID().toString();
	String fileSuffix = file.getOriginalFilename();
	String fileName = baseName + fileSuffix;

	/* File's infos */
	long fileSize = file.getSize();
	String fileType = file.getContentType();
	boolean success = false;
	String errorMessage = "";
	try {
	    store(file, fileName);
	    success = true;

	} catch (IOException ex) {

	    errorMessage = ex.getMessage();
	}
	AnonymousFile anonymousFile = new AnonymousFile();
	anonymousFile.setFileName(fileName);
	anonymousFile.setFileType(fileType);
	anonymousFile.setFileSize(fileSize);
	anonymousFile.setSuccess(success);
	anonymousFile.setErrorMessage(errorMessage);
	anonymousFiles.save(anonymousFile);

	/* store header's infos */
	for (Map.Entry<String, String> entry : headers
		.entrySet()) {
	    String key = entry.getKey();
	    String value = entry.getValue();

	    HttpHeader header = new HttpHeader();
	    header.setHeaderName(key);
	    header.setHeaderValue(value);

	    httpHeaders.save(header);
	}

	view.setName(fileName);
	return CompletableFuture.completedFuture(view);
	// wait for the response to return it
    };

    private void store(MultipartFile file, String fileName)
	    throws IOException {
	Path uploadPath = Paths.get(uploadDir);
	Path target = uploadPath.resolve(fileName);
	try (InputStream in = file.getInputStream()) {
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	}
    }

}