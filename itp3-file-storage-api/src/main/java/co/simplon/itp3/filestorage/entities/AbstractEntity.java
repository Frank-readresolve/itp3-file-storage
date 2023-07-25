package co.simplon.itp3.filestorage.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_number;

    AbstractEntity() {
	// Package (default) visible
	// Required no-arg constructor
    }

    public Long getCustomer_number() {
	return customer_number;
    }

    @SuppressWarnings("unused")
    public void setCustomer_number(Long customer_number) {
	// Prevents from accidental assignment (set by DB)
	this.customer_number = customer_number;
    }
}
