package co.simplon.itp3.filestorage.services;

import java.util.concurrent.CompletableFuture;

import co.simplon.itp3.filestorage.dtos.AuthenticatedFileData;
import co.simplon.itp3.filestorage.dtos.FileView;

public interface AuthenticatedFileService {

    CompletableFuture<FileView> upload(
	    AuthenticatedFileData inputs);

}
