package co.simplon.itp3.filestorage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "anonymous_files")
public class AnonymousFile extends AbstractEntity {

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private long fileSize;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "success")
    private boolean success;

    @Column(name = "error_message")
    private String errorMessage;

    public AnonymousFile() {

    }

    public String getFileName() {
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

    public long getFileSize() {
	return fileSize;
    }

    public void setFileSize(long fileSize) {
	this.fileSize = fileSize;
    }

    public String getFileType() {
	return fileType;
    }

    public void setFileType(String fileType) {
	this.fileType = fileType;
    }

    public boolean isSuccess() {
	return success;
    }

    public void setSuccess(boolean success) {
	this.success = success;
    }

    public String getErrorMessage() {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
	return "{fileName=" + fileName + ", fileSize="
		+ fileSize + ", fileType=" + fileType
		+ ", success=" + success + ", errorMessage="
		+ errorMessage + "}";
    }

}
