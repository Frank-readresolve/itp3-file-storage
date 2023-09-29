package co.simplon.itp3.filestorage.dtos;

public class FilesStatDto {

    private long fileNumber;

    private long success;

    private long error;

    private long maxSize;

    private String frequentlyType;

    public void FileStat() {
    }

    public long getFileNumber() {
	return fileNumber;
    }

    public void setFileNumber(long fileNumber) {
	this.fileNumber = fileNumber;
    }

    public long getSuccess() {
	return success;
    }

    public void setSuccess(long success) {
	this.success = success;
    }

    public long getError() {
	return error;
    }

    public void setError(long error) {
	this.error = error;
    }

    public long getMaxSize() {
	return maxSize;
    }

    public void setMaxSize(long maxSize) {
	this.maxSize = maxSize;
    }

    public String getFrequentlyType() {
	return frequentlyType;
    }

    public void setFrequentlyType(String frequentlyType) {
	this.frequentlyType = frequentlyType;
    }

    @Override
    public String toString() {
	return "{fileNumber=" + fileNumber + ", success="
		+ success + ", error=" + error
		+ ", maxSize=" + maxSize
		+ ", frequentlyType=" + frequentlyType
		+ "}";
    }

}
