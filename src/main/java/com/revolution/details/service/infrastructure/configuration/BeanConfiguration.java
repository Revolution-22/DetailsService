package com.revolution.details.service.infrastructure.configuration;

import com.revolution.details.service.api.port.AddressRepository;
import com.revolution.details.service.api.port.AddressService;
import com.revolution.details.service.domain.DetailsBeanConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.revolution.details.service.infrastructure.*")
class BeanConfiguration {

    private final DetailsBeanConfiguration detailsBeanConfiguration = new DetailsBeanConfiguration();

    @Bean
    AddressService addressService(AddressRepository addressRepository) {
        return detailsBeanConfiguration.getAddressService(addressRepository);
    }
}
