package com.revolution.details.service.infrastructure.database;

import com.revolution.details.service.api.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
class AddressMapper {

    public AddressDto toDto(AddressEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AddressDto(
                entity.getUserId(),
                entity.getCountry(),
                entity.getVoivodeship(),
                entity.getCity(),
                entity.getStreet(),
                entity.getApartmentNumber(),
                entity.getHouseNumber(),
                entity.getZipCode()
        );
    }

    public AddressEntity toEntity(AddressDto dto) {
        if (dto == null) {
            return null;
        }
        return AddressEntity.builder()
                .userId(dto.userId())
                .country(dto.country())
                .voivodeship(dto.voivodeship())
                .city(dto.city())
                .street(dto.street())
                .apartmentNumber(dto.apartmentNumber())
                .houseNumber(dto.houseNumber())
                .zipCode(dto.zipCode())
                .build();
    }
}
