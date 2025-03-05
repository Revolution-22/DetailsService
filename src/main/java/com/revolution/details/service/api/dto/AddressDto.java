package com.revolution.details.service.api.dto;

public record AddressDto(
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
