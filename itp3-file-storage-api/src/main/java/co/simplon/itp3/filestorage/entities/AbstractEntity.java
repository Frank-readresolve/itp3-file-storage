package co.simplon.itp3.filestorage.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    AbstractEntity() {
	// Package (default) visible
	// Required no-arg constructor
    }

    public Long getId() {
	return id;
    }

    @SuppressWarnings("unused")
    public void setId(Long id) {
	// Prevents from accidental assignment (set by DB)
	this.id = id;
    }
}
