package com.revolution.details.service.api.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateAddressRequest(
        @NotBlank
        String country,

        @NotBlank
        String voivodeship,

        @NotBlank
        String city,

        @NotBlank
        String street,

        @NotBlank
        String apartmentNumber,

        @NotBlank
        String houseNumber,

        @NotBlank
        String zipCode
){
}
