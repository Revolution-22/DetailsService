package com.revolution.DetailsService.domain;

import com.revolution.DetailsService.api.dto.AddressDto;
import com.revolution.DetailsService.api.request.UpdateAddressRequest;
import com.revolution.DetailsService.api.response.AddressResponse;

public class AddressMapper {

    Address toModel(final AddressDto addressDto) {
        return new Address(addressDto.userId(), addressDto.country(), addressDto.voivodeship(), addressDto.city(), addressDto.street(), addressDto.apartmentNumber(), addressDto.houseNumber(), addressDto.zipCode());
    }

    AddressDto toDto(final Address address) {
        return new AddressDto(address.getUserId(), address.getCountry(), address.getVoivodeship(), address.getCity(), address.getStreet(), address.getApartmentNumber(), address.getHouseNumber(), address.getZipCode());
    }

    Address toModel(final UpdateAddressRequest updateAddressRequest) {
        return new Address(updateAddressRequest.userId(), updateAddressRequest.country(), updateAddressRequest.voivodeship(), updateAddressRequest.city(), updateAddressRequest.street(), updateAddressRequest.apartmentNumber(), updateAddressRequest.houseNumber(), updateAddressRequest.zipCode());
    }

    AddressResponse toResponse(final Address address) {
        return new AddressResponse(address.getCountry(), address.getVoivodeship(), address.getCity(), address.getStreet(), address.getApartmentNumber(), address.getHouseNumber(), address.getZipCode());
    }
}
