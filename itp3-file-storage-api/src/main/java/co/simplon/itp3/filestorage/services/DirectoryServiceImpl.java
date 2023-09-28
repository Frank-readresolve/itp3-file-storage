package co.simplon.itp3.filestorage.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.simplon.itp3.filestorage.dtos.DirectoryData;
import co.simplon.itp3.filestorage.dtos.DirectoryView;

@Service
public class DirectoryServiceImpl implements DirectoryService {

    @Value("${spring.servlet.createDirectory.location}")
    private String createDir;

    public DirectoryServiceImpl() {
    }

    @Override
    public DirectoryView createDirectory(DirectoryData inputs) {

	/*
	 * DirectoryView directoryView = new DirectoryView(); String parentFolderId =
	 * inputs.getParentFolderId(); String folderName = inputs.getFolderName();
	 *
	 * Path parentFolderPath = Paths.get(createDir, parentFolderId); if
	 * (!Files.exists(parentFolderPath) || !Files.isDirectory(parentFolderPath)) {
	 * return null; }
	 *
	 * String folderId = UUID.randomUUID().toString(); Path folderPath =
	 * Paths.get(createDir, parentFolderId, folderId);
	 *
	 * if (parentFolderId != null) { // append child folder to the parent folder's
	 * UUID folderName = parentFolderId + folderName; }
	 *
	 * // String folderId = UUID.randomUUID().toString(); // Path folderPath =
	 * Paths.get(createDir, folderId);
	 *
	 * try { Files.createDirectories(folderPath); } catch (Exception e) {
	 * e.printStackTrace(); return null; }
	 *
	 * directoryView.setParentFolderId(folderId);
	 *
	 * return directoryView;
	 */

	/*
	 * DirectoryView directoryView = new DirectoryView(); String parentFolderId =
	 * inputs.getParentFolderId();
	 *
	 * // Generate a new UUID for the child folder String folderId =
	 * UUID.randomUUID().toString(); Path folderPath = Paths.get(createDir,
	 * parentFolderId, folderId);
	 *
	 * try { Files.createDirectories(folderPath); } catch (Exception e) {
	 * e.printStackTrace(); return null; }
	 *
	 * directoryView.setParentFolderId(folderId); return directoryView;
	 */

	/*
	 * DirectoryView directoryView = new DirectoryView(); String parentFolderId =
	 * inputs.getParentFolderId();
	 *
	 * // Generate a new UUID for the child folder String childFolderId =
	 * UUID.randomUUID().toString();
	 *
	 * // Construct the path for the child directory within the parent directory
	 * Path childFolderPath = Paths.get(createDir, parentFolderId, childFolderId);
	 *
	 * try { // Check if the parent directory exists Path parentFolderPath =
	 * Paths.get(createDir, parentFolderId);
	 *
	 * if (!Files.exists(parentFolderPath) || !Files.isDirectory(parentFolderPath))
	 * { // If the parent folder doesn't exist, generate a new UUID for it
	 * parentFolderId = UUID.randomUUID().toString(); parentFolderPath =
	 * Paths.get(createDir, parentFolderId);
	 * Files.createDirectories(parentFolderPath); }
	 *
	 * // Create the child directory inside the parent directory
	 * Files.createDirectories(childFolderPath);
	 *
	 * // Set the parent folder ID in the directoryView
	 * directoryView.setParentFolderId(parentFolderId);
	 *
	 * } catch (Exception e) { e.printStackTrace(); return null; }
	 *
	 * return directoryView;
	 */

	DirectoryView directoryView = new DirectoryView();
	String parentFolderId = inputs.getParentFolderId();

	String childFolderId = UUID.randomUUID().toString();

	// Construct the path for the child directory within the parent directory
	Path childFolderPath = Paths.get(createDir, parentFolderId, childFolderId);

	try {
	    // Check if the parent directory exists
	    Path parentFolderPath = Paths.get(createDir, parentFolderId);

	    if (!Files.exists(parentFolderPath) || !Files.isDirectory(parentFolderPath)) {
		// If the parent folder doesn't exist, generate a new UUID for it
		parentFolderId = UUID.randomUUID().toString();
		parentFolderPath = Paths.get(createDir, parentFolderId);
		Files.createDirectories(parentFolderPath);
	    }

	    // Create the child directory inside the parent directory
	    Files.createDirectories(childFolderPath);

	    // Set the child folder ID in the directoryView
	    directoryView.setParentFolderId(childFolderId);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

	return directoryView;

    }
}
