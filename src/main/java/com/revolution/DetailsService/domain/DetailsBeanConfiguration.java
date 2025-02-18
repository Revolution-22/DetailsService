package com.revolution.DetailsService.domain;

import com.revolution.DetailsService.api.port.AddressRepository;
import com.revolution.DetailsService.api.port.DetailsService;

public class DetailsBeanConfiguration {

    public DetailsService getDetailsService(AddressRepository addressRepository) {
        return new CoreDetailsService(addressRepository, new AddressMapper());
    }
}
