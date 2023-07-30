package co.simplon.itp3.filestorage.services;

import co.simplon.itp3.filestorage.dtos.SubscriptionData;

public interface SubscriptionService {
    void create(SubscriptionData inputs);

    Boolean existsBySubscriptionName(
	    String subscriptionName);
}
