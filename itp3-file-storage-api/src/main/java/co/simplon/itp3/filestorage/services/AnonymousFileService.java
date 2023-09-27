package co.simplon.itp3.filestorage.services;

import java.util.Map;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;

public interface AnonymousFileService {

    FileView upload(Map<String, String> headers,
	    AnonymousFileData inputs);

}
