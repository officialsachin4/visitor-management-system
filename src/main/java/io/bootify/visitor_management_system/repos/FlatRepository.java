package io.bootify.visitor_management_system.repos;

import io.bootify.visitor_management_system.domain.Flat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlatRepository extends JpaRepository<Flat, Long> {
}
