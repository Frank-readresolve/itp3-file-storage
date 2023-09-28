package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DirectoryData {

    private String parentFolderId;

    @NotBlank(message = "Folder name is required")
    @Size(max = 255, message = "Folder name must be at most 255 characters")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "Folder name must consist of letters and digits only")
    private String folderName;

    public DirectoryData(String parentFolderId,
	    @NotBlank(message = "Folder name is required") @Size(max = 255, message = "Folder name must be at most 255 characters") @Pattern(regexp = "[a-zA-Z0-9]*", message = "Folder name must consist of letters and digits only") String folderName) {
	this.parentFolderId = parentFolderId;
	this.folderName = folderName;
    }

    public String getParentFolderId() {
	return parentFolderId;
    }

    public void setParentFolderId(String parentFolderId) {
	this.parentFolderId = parentFolderId;
    }

    public String getFolderName() {
	return folderName;
    }

    public void setFolderName(String folderName) {
	this.folderName = folderName;
    }

    @Override
    public String toString() {
	return "{parentFolderId=" + parentFolderId + ", folderName=" + folderName + "}";
    }
}
