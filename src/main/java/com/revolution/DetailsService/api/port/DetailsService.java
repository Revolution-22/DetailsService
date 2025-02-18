package com.revolution.DetailsService.api.port;

import com.revolution.DetailsService.api.request.AddressRequest;
import com.revolution.DetailsService.api.response.AddressResponse;

public interface DetailsService {

    AddressResponse createAddress(long userId);
    AddressResponse updateAddress(AddressRequest addressRequest);
    AddressResponse getAddress(long userId);
}
