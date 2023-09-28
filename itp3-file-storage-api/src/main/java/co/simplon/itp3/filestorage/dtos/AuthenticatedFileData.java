package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import co.simplon.itp3.filestorage.customValidation.FileSize;

public class AuthenticatedFileData {

    @NotNull
    @FileSize(maxSizeInKB = 1000)
    private MultipartFile file;

    public AuthenticatedFileData() {
    }

    public MultipartFile getFile() {
	return file;
    }

    public void setFile(MultipartFile file) {
	this.file = file;
    }

    @Override
    public String toString() {
	return " {file=" + file + "}";
    }
}
