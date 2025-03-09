package com.revolution.details.service.domain;

import com.revolution.details.service.api.port.AddressRepository;
import com.revolution.details.service.api.port.AddressService;

public class DetailsBeanConfiguration {

    public AddressService getAddressService(AddressRepository addressRepository) {
        return new CoreAddressService(addressRepository, new AddressMapper());
    }
}
