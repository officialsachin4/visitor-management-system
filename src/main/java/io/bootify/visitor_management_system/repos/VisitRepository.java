package io.bootify.visitor_management_system.repos;

import io.bootify.visitor_management_system.domain.Flat;
import io.bootify.visitor_management_system.domain.Visit;
import io.bootify.visitor_management_system.model.VisitStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VisitRepository extends JpaRepository<Visit, Long>
{
    List<Visit> findAllByFlatAndStatus(Flat flat, VisitStatus status);

}
