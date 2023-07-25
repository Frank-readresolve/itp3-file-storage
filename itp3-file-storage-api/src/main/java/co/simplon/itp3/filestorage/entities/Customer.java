package co.simplon.itp3.filestorage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "consent")
    private Boolean consent;

    public Customer() {
	// TODO Auto-generated constructor stub
    }

    public String getCustomer_name() {
	return customer_name;
    }

    public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
    }

    public String getFirst_name() {
	return first_name;
    }

    public void setFirst_name(String first_name) {
	this.first_name = first_name;
    }

    public String getLast_name() {
	return last_name;
    }

    public void setLast_name(String last_name) {
	this.last_name = last_name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Boolean getConsent() {
	return consent;
    }

    public void setConsent(Boolean consent) {
	this.consent = consent;
    }

    @Override
    public String toString() {
	return "{customer_name=" + customer_name + ", first_name=" + first_name
		+ ", last_name=" + last_name + ", email=" + email + ", consent="
		+ consent + "}";
    }

}
