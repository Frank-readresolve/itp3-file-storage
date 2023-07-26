package co.simplon.itp3.filestorage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Column(name = "subscription_code", insertable = false, updatable = false)
    private Long subscription_code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "free_subscription")
    private Boolean free_subscription;

    @Column(name = "duration_in_months")
    private int duration_in_month;

    @Column(name = "maximum_stored_files")
    private int maximum_stored_files;

    public Subscription() {

    }

    public Long getSubscription_number() {
	return subscription_code;
    }

    public void setSubscription_number(
	    Long subscription_number) {
	this.subscription_code = subscription_number;
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
	return "{subscription_code=" + subscription_code
		+ ", name=" + name + ", description="
		+ description + ", free_subscription="
		+ free_subscription + ", duration_in_month="
		+ duration_in_month
		+ ", maximum_stored_files="
		+ maximum_stored_files + "}";
    }

}
