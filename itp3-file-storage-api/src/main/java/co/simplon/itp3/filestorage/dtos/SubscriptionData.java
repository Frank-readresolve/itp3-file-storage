package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.simplon.itp3.filestorage.customValidation.UniqueSubscriptionName;

public class SubscriptionData {

    @UniqueSubscriptionName
    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String subscriptionName;

    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    private String description;

    private boolean freeSubscription;

    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    private int durationInMonths;

    @NotNull
    @Min(value = 11)
    @Max(value = 10000)
    private int maximumStoredFiles;

    public SubscriptionData() {

    }

    public String getSubscriptionName() {
	return subscriptionName;
    }

    public void setSubscriptionName(
	    String subscriptionName) {
	this.subscriptionName = subscriptionName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public boolean getFreeSubscription() {
	return freeSubscription;
    }

    public void setFreeSubscription(
	    boolean freeSubscription) {
	this.freeSubscription = freeSubscription;
    }

    public int getDurationInMonths() {
	return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
	this.durationInMonths = durationInMonths;
    }

    public int getMaximumStoredFiles() {
	return maximumStoredFiles;
    }

    public void setMaximumStoredFiles(
	    int maximumStoredFiles) {
	this.maximumStoredFiles = maximumStoredFiles;
    }

    @Override
    public String toString() {
	return "{subscriptionName=" + subscriptionName
		+ ", description=" + description
		+ ", freeSubscription=" + freeSubscription
		+ ", durationInMonths=" + durationInMonths
		+ ", maximumStoredFiles="
		+ maximumStoredFiles + "}";
    }

}
