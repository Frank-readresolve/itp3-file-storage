package co.simplon.itp3.filestorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.itp3.filestorage.entities.AnonymousFile;

@Repository
public interface FilesStatRepository
	extends JpaRepository<AnonymousFile, Long> {

    @Query("SELECT count(a) FROM AnonymousFile a")
    long countFileUpload();

    @Query("SELECT count(a) FROM AnonymousFile a WHERE a.success = true")
    long countSuccessFileUpload();

    @Query("SELECT count(a) FROM AnonymousFile a WHERE a.success = false")
    long countFaileFileUpload();

    @Query("SELECT MAX(a.fileSize) FROM AnonymousFile a")
    long maxFileSize();

    // @Query(value = "SELECT a.fileType FROM AnonymousFile a GROUP BY a.fileType
    // ORDER BY COUNT(a) DESC LIMIT 1", nativeQuery = true)
    // String frequentlyType();

}
