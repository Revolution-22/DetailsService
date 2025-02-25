package com.revolution.DetailsService.domain;

import com.revolution.DetailsService.api.dto.AddressDto;
import com.revolution.DetailsService.api.exception.AddressNotFoundException;
import com.revolution.DetailsService.api.port.AddressRepository;
import com.revolution.DetailsService.api.port.DetailsService;
import com.revolution.DetailsService.api.request.UpdateAddressRequest;
import com.revolution.DetailsService.api.response.AddressResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CoreDetailsService implements DetailsService {

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
        if (!addressRepository.existsByUserId(userId)) {
            throw new AddressNotFoundException(userId);
        }
        Address address = addressMapper.toModel(updateAddressRequest);
        address.setUserId(userId);
        AddressDto updatedDto = addressRepository.save(addressMapper.toDto(address));
        return addressMapper.toResponse(addressMapper.toModel(updatedDto));
    }

    @Override
    public AddressResponse getAddress(long userId) {
        return addressRepository.findByUserId(userId)
                .map(addressDto -> addressMapper.toResponse(addressMapper.toModel(addressDto)))
                .orElseThrow(() -> new AddressNotFoundException(userId));
    }
}
