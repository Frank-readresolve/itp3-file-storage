package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CustomerData {

    @NotBlank
    @Size(max = 100)
    private String customer_name;

    @NotBlank
    @Size(max = 100)
    private String first_name;

    @NotBlank
    @Size(max = 100)
    private String last_name;

    @NotBlank
    private String email;

    private Boolean consent;

    public CustomerData() {
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
	return "{customer_name=" + customer_name
		+ ", first_name=" + first_name
		+ ", last_name=" + last_name + ", email="
		+ email + ", consent=" + consent + "}";
    }

}
