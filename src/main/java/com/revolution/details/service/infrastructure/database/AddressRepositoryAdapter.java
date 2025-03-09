package com.revolution.details.service.infrastructure.database;

import com.revolution.details.service.api.dto.AddressDto;
import com.revolution.details.service.api.port.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
class AddressRepositoryAdapter implements AddressRepository {

    private final AddressJpaRepository addressJpaRepository;
    private final AddressMapper addressMapper;

    @Override
    public Optional<AddressDto> findByUserId(long userId) {
        return addressJpaRepository.findByUserId(userId)
                .map(addressMapper::toDto);
    }

    @Override
    public boolean existsByUserId(long userId) {
        return addressJpaRepository.existsByUserId(userId);
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        return addressMapper.toDto(
                    addressJpaRepository.save(
                        addressMapper.toEntity(addressDto)));
    }
}
