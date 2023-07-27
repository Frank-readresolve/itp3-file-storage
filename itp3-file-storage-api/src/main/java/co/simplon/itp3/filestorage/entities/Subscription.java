package co.simplon.itp3.filestorage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription extends AbstractEntity {

    @Column(name = "subscription_code")
    private Long subscriptionCode;

    @Column(name = "subsciption_name")
    private String subsciptionName;

    @Column(name = "description")
    private String description;

    @Column(name = "free_subscription")
    private Boolean freeSubscription;

    @Column(name = "duration_in_months")
    private int durationInMonth;

    @Column(name = "maximum_stored_files")
    private int maximumStoredFiles;

    public Subscription() {

    }

    public Long getSubscriptionCode() {
	return subscriptionCode;
    }

    public void setSubscriptionCode(Long subscriptionCode) {
	this.subscriptionCode = subscriptionCode;
    }

    public String getSubsciptionName() {
	return subsciptionName;
    }

    public void setSubsciptionName(String subsciptionName) {
	this.subsciptionName = subsciptionName;
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
	return "{subscriptionCode=" + subscriptionCode
		+ ", subsciptionName=" + subsciptionName
		+ ", description=" + description
		+ ", freeSubscription=" + freeSubscription
		+ ", durationInMonth=" + durationInMonth
		+ ", maximumStoredFiles="
		+ maximumStoredFiles + "}";
    }

}
