package com.revolution.details.service.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface AddressJpaRepository extends JpaRepository<AddressEntity, Long> {
    Optional<AddressEntity> findByUserId(long userId);

    boolean existsByUserId(long userId);
}
