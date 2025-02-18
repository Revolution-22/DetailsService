package com.revolution.DetailsService.api.exception;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(long userId) {
        super("Address of user with id " + userId + " does not exist");
    }
}
