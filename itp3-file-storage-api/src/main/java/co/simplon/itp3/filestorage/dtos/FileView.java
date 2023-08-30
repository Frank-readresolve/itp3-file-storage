package co.simplon.itp3.filestorage.dtos;

public class FileView {

    private String name;

    public FileView() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return " {name=" + name + "}";
    }

}
