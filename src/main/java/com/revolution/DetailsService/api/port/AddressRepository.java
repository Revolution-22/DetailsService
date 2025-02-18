package com.revolution.DetailsService.api.port;

import com.revolution.DetailsService.api.dto.AddressDto;

import java.util.Optional;

public interface AddressRepository {

    Optional<AddressDto> findByUserId(long userId);

    boolean existsByUserId(long userId);

    AddressDto save(AddressDto addressDto);
}
