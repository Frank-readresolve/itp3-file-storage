package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import co.simplon.itp3.filestorage.customValidation.UniqueEmail;
import co.simplon.itp3.filestorage.customValidation.UniqueName;

public class CustomerData {

    @UniqueName
    @NotBlank
    @Size(max = 100)
    private String customerName;

    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotBlank
    @Size(max = 100)
    private String lastName;

    @UniqueEmail
    @NotBlank
    private String email;

    private Boolean consent;

    public CustomerData() {
	// TODO Auto-generated constructor stub
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

    public Boolean getConsent() {
	return consent;
    }

    public void setConsent(Boolean consent) {
	this.consent = consent;
    }

    @Override
    public String toString() {
	return "{customerName=" + customerName + ", firstName=" + firstName + ", lastName="
		+ lastName + ", email=" + email + ", consent=" + consent + "}";
    }

}
