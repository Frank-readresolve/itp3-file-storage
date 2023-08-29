package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.simplon.itp3.filestorage.customValidation.UniqueCustomerName;
import co.simplon.itp3.filestorage.customValidation.UniqueEmail;

public class CustomerData {

    @UniqueCustomerName
    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String customerName;

    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;

    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @UniqueEmail
    @NotBlank
    private String email;

    private boolean consent;

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

    public boolean getConsent() {
	return consent;
    }

    public void setConsent(boolean consent) {
	this.consent = consent;
    }

    @Override
    public String toString() {
	return "{customerName=" + customerName
		+ ", firstName=" + firstName + ", lastName="
		+ lastName + ", email=" + email
		+ ", consent=" + consent + "}";
    }

}
