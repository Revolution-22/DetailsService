package com.revolution.DetailsService.domain.adapters

import com.revolution.DetailsService.api.dto.AddressDto
import com.revolution.DetailsService.api.port.AddressRepository

class TestAddressRepository implements AddressRepository {

    protected Map<Long, AddressDto> database = new HashMap<>()

    @Override
    Optional<AddressDto> findByUserId(long userId) {
        Optional.ofNullable(database.get(userId))
    }

    @Override
    boolean existsByUserId(long userId) {
        database.get(userId) != null
    }

    @Override
    AddressDto save(AddressDto addressDto) {
        long id = addressDto.userId() == null ? database.size() : addressDto.userId()
        AddressDto withIdAddressDto = new AddressDto(id, addressDto.country(), addressDto.voivodeship(), addressDto.city(), addressDto.street(), addressDto.apartmentNumber(), addressDto.houseNumber(), addressDto.zipCode())
        database.put(id, addressDto)
        addressDto
    }
}
