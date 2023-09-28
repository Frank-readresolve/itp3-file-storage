package co.simplon.itp3.filestorage.services;

import co.simplon.itp3.filestorage.dtos.DirectoryData;
import co.simplon.itp3.filestorage.dtos.DirectoryView;

public interface DirectoryService {

    DirectoryView createDirectory(DirectoryData inputs);
}
