package co.simplon.itp3.filestorage.services;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;

public interface AnonymousFileService {

    FileView upload(AnonymousFileData inputs);

}
