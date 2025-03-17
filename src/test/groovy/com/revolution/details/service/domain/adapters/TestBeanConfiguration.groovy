package com.revolution.details.service.domain.adapters

import com.revolution.details.service.api.port.AddressRepository
import com.revolution.details.service.api.port.AddressService
import com.revolution.details.service.domain.DetailsBeanConfiguration

class TestBeanConfiguration {

    private final DetailsBeanConfiguration detailsBeanConfiguration = new DetailsBeanConfiguration()

    private final AddressRepository addressRepository = new TestAddressRepository()

    AddressService getDetailsService() {
        detailsBeanConfiguration.getAddressService(addressRepository)
    }

    def clear() {
        addressRepository.database.clear()
    }
}
