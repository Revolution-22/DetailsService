package com.revolution.details.service.domain

import com.revolution.details.service.api.exception.AddressNotFoundException
import com.revolution.details.service.api.port.AddressService
import com.revolution.details.service.api.request.UpdateAddressRequest
import com.revolution.details.service.api.response.AddressResponse
import com.revolution.details.service.domain.adapters.TestBeanConfiguration
import spock.lang.Specification
import spock.lang.Subject

class CoreAddressServiceSpec extends Specification implements Constants {

    private TestBeanConfiguration configuration = new TestBeanConfiguration()

    @Subject
    private AddressService detailsService = configuration.getDetailsService()

    def setup(){
        configuration.clear()
    }

    def "should update address and get" () {
        given: "Create address"
            detailsService.createAddress(1L)
        and: "Update address"
            detailsService.updateAddress(getUpdateRequest(1L), 1L)
        when: "Try to get address"
            AddressResponse response = detailsService.getAddress(1L)
        then: "Check if update correctly"
            response.country() == COUNTRY
            response.voivodeship() == VOIVODESHIP
            response.city() == CITY
            response.street() == STREET
            response.apartmentNumber() == APARTMENT_NUMBER
            response.houseNumber() == HOUSE_NUMBER
            response.zipCode() == ZIP_CODE
    }

    UpdateAddressRequest getUpdateRequest(long userId) {
        return new UpdateAddressRequest(COUNTRY, VOIVODESHIP, CITY, STREET, APARTMENT_NUMBER, HOUSE_NUMBER, ZIP_CODE)
    }

    def "should not update address because is not created" () {
        when: "Try update address"
            detailsService.updateAddress(getUpdateRequest(1L), 1L)
        then: "Check if thrown exception"
            thrown(AddressNotFoundException)
    }

    def "should not get address because is not created" () {
        when: "Try get address"
            detailsService.getAddress(1L)
        then: "Check if thrown exception"
            thrown(AddressNotFoundException)
    }
}
