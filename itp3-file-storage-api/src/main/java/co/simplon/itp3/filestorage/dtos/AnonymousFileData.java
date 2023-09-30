package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import co.simplon.itp3.filestorage.customValidation.FileSize;
import co.simplon.itp3.filestorage.customValidation.FileType;

public class AnonymousFileData {

    @NotNull
    @FileSize(maxSizeInKB = 100)
    @FileType
    private MultipartFile file;

    public AnonymousFileData() {
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
