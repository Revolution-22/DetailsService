package com.revolution.DetailsService.domain.adapters

import com.revolution.DetailsService.api.port.AddressRepository
import com.revolution.DetailsService.api.port.DetailsService
import com.revolution.DetailsService.domain.DetailsBeanConfiguration

class TestBeanConfiguration {

    private final DetailsBeanConfiguration detailsBeanConfiguration = new DetailsBeanConfiguration()

    private final AddressRepository addressRepository = new TestAddressRepository()

    DetailsService getDetailsService() {
        detailsBeanConfiguration.getDetailsService(addressRepository)
    }

    def clear() {
        addressRepository.database.clear()
    }
}
