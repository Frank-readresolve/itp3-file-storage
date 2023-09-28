package co.simplon.itp3.filestorage.dtos;

public class DirectoryView {

    private String parentFolderId;

    public DirectoryView() {
    }

    public String getParentFolderId() {
	return parentFolderId;
    }

    public void setParentFolderId(String parentFolderId) {
	this.parentFolderId = parentFolderId;
    }

    @Override
    public String toString() {
	return "{parentFolderId=" + parentFolderId + "}";
    }

}
