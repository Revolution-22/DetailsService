package com.revolution.details.service.api.port;

import com.revolution.details.service.api.request.UpdateAddressRequest;
import com.revolution.details.service.api.response.AddressResponse;

public interface AddressService {

    AddressResponse createAddress(long userId);
    AddressResponse updateAddress(UpdateAddressRequest updateAddressRequest);
    AddressResponse getAddress(long userId);
}
