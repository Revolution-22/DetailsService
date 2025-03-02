package com.revolution.details.service.domain;

import com.revolution.details.service.api.dto.AddressDto;
import com.revolution.details.service.api.exception.AddressNotFoundException;
import com.revolution.details.service.api.port.AddressRepository;
import com.revolution.details.service.api.port.AddressService;
import com.revolution.details.service.api.request.UpdateAddressRequest;
import com.revolution.details.service.api.response.AddressResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CoreAddressService implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse createAddress(long userId) {
        Address address = Address.ofUserId(userId);
        AddressDto savedDto = addressRepository.save(addressMapper.toDto(address));
        return addressMapper.toResponse(addressMapper.toModel(savedDto));
    }

    @Override
    public AddressResponse updateAddress(UpdateAddressRequest updateAddressRequest) {
        long userId = updateAddressRequest.userId();
        return addressMapper.toResponse(
                    addressMapper.toModel(
                            addressRepository.save(
                                    addressMapper.ofRequest(updateAddressRequest,
                                            addressRepository.findByUserId(userId)
                                               .orElseThrow(() -> new AddressNotFoundException(userId)
                                            ).userId()
                                    )
                            )
                    )
                );
    }

    @Override
    public AddressResponse getAddress(long userId) {
        return addressRepository.findByUserId(userId)
                .map(addressDto -> addressMapper.toResponse(addressMapper.toModel(addressDto)))
                .orElseThrow(() -> new AddressNotFoundException(userId));
    }
}
