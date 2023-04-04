package io.bootify.visitor_management_system.repos;

import io.bootify.visitor_management_system.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
