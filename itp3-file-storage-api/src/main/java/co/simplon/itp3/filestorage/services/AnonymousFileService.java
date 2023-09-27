package co.simplon.itp3.filestorage.services;

import java.util.concurrent.CompletableFuture;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;

public interface AnonymousFileService {

    CompletableFuture<FileView> upload(
	    AnonymousFileData inputs);

}
