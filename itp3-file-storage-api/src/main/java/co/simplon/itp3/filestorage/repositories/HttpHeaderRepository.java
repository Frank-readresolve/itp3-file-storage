package co.simplon.itp3.filestorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.filestorage.entities.HttpHeader;

public interface HttpHeaderRepository
	extends JpaRepository<HttpHeader, Long> {

}
