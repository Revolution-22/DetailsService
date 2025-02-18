package com.revolution.DetailsService.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Address {

    @Setter
    private long userId;
    private String country;
    private String voivodeship;
    private String city;
    private String street;
    private String apartmentNumber;
    private String houseNumber;
    private String zipCode;

    public static Address ofUserId(long userId) {
        return new Address(userId, null, null, null, null, null, null, null);
    }
}
