package com.revolution.details.service.api.port;

import com.revolution.details.service.api.dto.AddressDto;

import java.util.Optional;

public interface AddressRepository {

    Optional<AddressDto> findByUserId(long userId);

    boolean existsByUserId(long userId);

    AddressDto save(AddressDto addressDto);
}
