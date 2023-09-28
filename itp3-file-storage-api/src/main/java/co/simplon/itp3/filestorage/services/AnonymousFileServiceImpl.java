package co.simplon.itp3.filestorage.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;

@Service
public class AnonymousFileServiceImpl
	implements AnonymousFileService {

    @Value("${itp3-file-storage-api.uploads.location}")
    private String uploadDir;

    public AnonymousFileServiceImpl() {
    }

    @Override
    @Async
    public CompletableFuture<FileView> upload(
	    AnonymousFileData inputs) {
	FileView view = new FileView();
	MultipartFile file = inputs.getFile();
	String baseName = UUID.randomUUID().toString();
	String fileSuffix = file.getOriginalFilename();
	String fileName = baseName + fileSuffix;
	store(file, fileName);
	view.setName(fileName);
	return CompletableFuture.completedFuture(view);
	// wait for the response to return it
    };

    private void store(MultipartFile file,
	    String fileName) {
	Path uploadPath = Paths.get(uploadDir);
	Path target = uploadPath.resolve(fileName);
	try (InputStream in = file.getInputStream()) {
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}
    };

}
