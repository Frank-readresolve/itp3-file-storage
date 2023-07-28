package co.simplon.itp3.filestorage.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.filestorage.dtos.SubscriptionData;
import co.simplon.itp3.filestorage.entities.Subscription;
import co.simplon.itp3.filestorage.repositories.SubscriptionRepository;

@Service
@Transactional(readOnly = true)
public class SubscriptionServiceImpl
	implements SubscriptionService {

    private SubscriptionRepository subscriptions;

    public SubscriptionServiceImpl(
	    SubscriptionRepository subscriptions) {
	this.subscriptions = subscriptions;
    }

    @Override
    @Transactional
    public void create(SubscriptionData inputs) {
	Subscription subscription = new Subscription();
	subscription
		.setSubscriptionCode("CD" + subscriptions
			.getNextSeriesCustomerNumber());
	subscription.setSubscriptionName(
		inputs.getSubscriptionName());
	subscription
		.setDescription(inputs.getDescription());
	subscription.setFreeSubscription(
		inputs.getFreeSubscription());
	subscription.setDurationInMonths(
		inputs.getDurationInMonths());
	subscription.setMaximumStoredFiles(
		inputs.getMaximumStoredFiles());

	subscriptions.save(subscription);
    }

    @Override
    public Boolean existsBySubscriptionName(String name) {
	return subscriptions.existsBySubscriptionName(name);
    }

}
