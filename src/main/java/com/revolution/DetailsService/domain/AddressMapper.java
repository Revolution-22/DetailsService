package com.revolution.DetailsService.domain;

import com.revolution.DetailsService.api.dto.AddressDto;
import com.revolution.DetailsService.api.request.AddressRequest;
import com.revolution.DetailsService.api.response.AddressResponse;

public class AddressMapper {

    Address toModel(final AddressDto addressDto) {
        return new Address(addressDto.userId(), addressDto.country(), addressDto.voivodeship(), addressDto.city(), addressDto.street(), addressDto.apartmentNumber(), addressDto.houseNumber(), addressDto.zipCode());
    }

    AddressDto toDto(final Address address) {
        return new AddressDto(address.getUserId(), address.getCountry(), address.getVoivodeship(), address.getCity(), address.getStreet(), address.getApartmentNumber(), address.getHouseNumber(), address.getZipCode());
    }

    Address toModel(final AddressRequest addressRequest) {
        return new Address(addressRequest.userId(), addressRequest.country(), addressRequest.voivodeship(), addressRequest.city(), addressRequest.street(), addressRequest.apartmentNumber(), addressRequest.houseNumber(), addressRequest.zipCode());
    }

    AddressResponse toResponse(final Address address) {
        return new AddressResponse(address.getCountry(), address.getVoivodeship(), address.getCity(), address.getStreet(), address.getApartmentNumber(), address.getHouseNumber(), address.getZipCode());
    }
}
