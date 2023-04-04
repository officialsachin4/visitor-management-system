package io.bootify.visitor_management_system.repos;

import io.bootify.visitor_management_system.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
