package com.revolution.DetailsService.api.request;

public record AddressRequest(
        long userId,
        String country,
        String voivodeship,
        String city,
        String street,
        String apartmentNumber,
        String houseNumber,
        String zipCode
){
}
