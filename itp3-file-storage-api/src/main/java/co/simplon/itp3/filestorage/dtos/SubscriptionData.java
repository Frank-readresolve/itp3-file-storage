package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SubscriptionData {

    @NotBlank
    @Size(max = 100)
    private String subscriptionName;

    @NotBlank
    @Size(max = 1000)
    private String description;

    private Boolean freeSubscription;

    @NotBlank
    @Size(max = 12)
    private int durationInMonth;

    @NotBlank
    @Size(min = 11, max = 10000)
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

    public Boolean getFreeSubscription() {
	return freeSubscription;
    }

    public void setFreeSubscription(
	    Boolean freeSubscription) {
	this.freeSubscription = freeSubscription;
    }

    public int getDurationInMonth() {
	return durationInMonth;
    }

    public void setDurationInMonth(int durationInMonth) {
	this.durationInMonth = durationInMonth;
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
		+ ", durationInMonth=" + durationInMonth
		+ ", maximumStoredFiles="
		+ maximumStoredFiles + "}";
    }

}
