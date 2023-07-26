package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SubscriptionData {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 1000)
    private String description;

    private Boolean free_subscription;

    @NotBlank
    @Size(max = 12)
    private int duration_in_month;

    @NotBlank
    @Size(min = 11, max = 10000)
    private int maximum_stored_files;

    public SubscriptionData() {

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Boolean getFree_subscription() {
	return free_subscription;
    }

    public void setFree_subscription(
	    Boolean free_subscription) {
	this.free_subscription = free_subscription;
    }

    public int getDuration_in_month() {
	return duration_in_month;
    }

    public void setDuration_in_month(
	    int duration_in_month) {
	this.duration_in_month = duration_in_month;
    }

    public int getMaximum_stored_files() {
	return maximum_stored_files;
    }

    public void setMaximum_stored_files(
	    int maximum_stored_files) {
	this.maximum_stored_files = maximum_stored_files;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", description="
		+ description + ", free_subscription="
		+ free_subscription + ", duration_in_month="
		+ duration_in_month
		+ ", maximum_stored_files="
		+ maximum_stored_files + "}";
    }

}
