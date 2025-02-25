package com.revolution.DetailsService.api.port;

import com.revolution.DetailsService.api.request.UpdateAddressRequest;
import com.revolution.DetailsService.api.response.AddressResponse;

public interface DetailsService {

    AddressResponse createAddress(long userId);
    AddressResponse updateAddress(UpdateAddressRequest updateAddressRequest);
    AddressResponse getAddress(long userId);
}
