package co.simplon.itp3.filestorage.services;

import co.simplon.itp3.filestorage.dtos.CustomerData;

public interface CustomerService {

    void create(CustomerData inputs);

    Boolean existsByCustomerName(String name);

    Boolean existsByEmail(String email);
}
