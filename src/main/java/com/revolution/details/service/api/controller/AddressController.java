package com.revolution.details.service.api.controller;

import com.revolution.details.service.api.port.AddressService;
import com.revolution.details.service.api.request.UpdateAddressRequest;
import com.revolution.details.service.api.response.AddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PutMapping
    AddressResponse updateAddress(@RequestBody UpdateAddressRequest request, @RequestHeader("X-USER-ID") long userId) {
        return addressService.updateAddress(request, userId);
    }

    @GetMapping
    AddressResponse getAddress(@RequestHeader("X-USER-ID") long userId) {
        return addressService.getAddress(userId);
    }
}
