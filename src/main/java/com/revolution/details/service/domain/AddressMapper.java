package com.revolution.details.service.domain;

import com.revolution.details.service.api.dto.AddressDto;
import com.revolution.details.service.api.request.UpdateAddressRequest;
import com.revolution.details.service.api.response.AddressResponse;

public class AddressMapper {

    Address toModel(final AddressDto addressDto) {
        return new Address(addressDto.userId(), addressDto.country(), addressDto.voivodeship(), addressDto.city(), addressDto.street(), addressDto.apartmentNumber(), addressDto.houseNumber(), addressDto.zipCode());
    }

    AddressDto toDto(final Address address) {
        return new AddressDto(address.getUserId(), address.getCountry(), address.getVoivodeship(), address.getCity(), address.getStreet(), address.getApartmentNumber(), address.getHouseNumber(), address.getZipCode());
    }

    AddressDto ofRequest(final UpdateAddressRequest request, final long userId) {
        return new AddressDto(userId, request.country(), request.voivodeship(), request.city(), request.street(), request.apartmentNumber(), request.houseNumber(), request.zipCode());
    }

    AddressResponse toResponse(final Address address) {
        return new AddressResponse(address.getCountry(), address.getVoivodeship(), address.getCity(), address.getStreet(), address.getApartmentNumber(), address.getHouseNumber(), address.getZipCode());
    }
}
