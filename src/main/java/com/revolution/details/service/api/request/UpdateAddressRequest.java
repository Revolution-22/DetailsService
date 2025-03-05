package com.revolution.details.service.api.request;

public record UpdateAddressRequest(
        Long userId,
        String country,
        String voivodeship,
        String city,
        String street,
        String apartmentNumber,
        String houseNumber,
        String zipCode
){
}
