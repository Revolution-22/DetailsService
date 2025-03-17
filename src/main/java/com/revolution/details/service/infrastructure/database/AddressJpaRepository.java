package com.revolution.details.service.infrastructure.database;

import com.revolution.details.service.api.dto.AddressDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressJpaRepository extends JpaRepository<AddressEntity, Long> {
    Optional<AddressEntity> findByUserId(long userId);

    boolean existsByUserId(long userId);
}
