package co.simplon.itp3.filestorage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @Column(name = "customer_number")
    private Long customerNumber;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "consent")
    private boolean consent;

    @Column(name = "api_key")
    private String apiKey;

    public Customer() {
	// TODO Auto-generated constructor stub
    }

    public Long getCustomerNumber() {
	return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
	this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public boolean getConsent() {
	return consent;
    }

    public void setConsent(boolean consent) {
	this.consent = consent;
    }

    public String getApiKey() {
	return apiKey;
    }

    public void setApiKey(String apiKey) {
	this.apiKey = apiKey;
    }

    @Override
    public String toString() {
	return "{customerNumber=" + customerNumber + ", customerName=" + customerName
		+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
		+ ", consent=" + consent + ", apiKey=" + apiKey + "}";
    }

}