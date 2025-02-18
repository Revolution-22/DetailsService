package com.revolution.DetailsService.api.response;

public record AddressResponse(
        String country,
        String voivodeship,
        String city,
        String street,
        String apartmentNumber,
        String houseNumber,
        String zipCode
){
}
