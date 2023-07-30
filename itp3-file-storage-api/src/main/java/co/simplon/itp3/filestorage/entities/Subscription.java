package co.simplon.itp3.filestorage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription extends AbstractEntity {

    @Column(name = "subscription_code")
    private String subscriptionCode;

    @Column(name = "subscription_name")
    private String subscriptionName;

    @Column(name = "description")
    private String description;

    @Column(name = "free_subscription")
    private boolean freeSubscription;

    @Column(name = "duration_in_months")
    private int durationInMonths;

    @Column(name = "maximum_stored_files")
    private int maximumStoredFiles;

    public Subscription() {

    }

    public String getSubscriptionCode() {
	return subscriptionCode;
    }

    public void setSubscriptionCode(
	    String subscriptionCode) {
	this.subscriptionCode = subscriptionCode;
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
	return "{subscriptionCode=" + subscriptionCode
		+ ", subsciptionName=" + subscriptionName
		+ ", description=" + description
		+ ", freeSubscription=" + freeSubscription
		+ ", durationInMonths=" + durationInMonths
		+ ", maximumStoredFiles="
		+ maximumStoredFiles + "}";
    }

}
