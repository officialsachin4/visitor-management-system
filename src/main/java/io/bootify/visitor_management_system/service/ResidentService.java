package io.bootify.visitor_management_system.service;
import io.bootify.visitor_management_system.domain.Flat;
import io.bootify.visitor_management_system.domain.User;
import io.bootify.visitor_management_system.domain.Visit;
import io.bootify.visitor_management_system.model.VisitDTO;
import io.bootify.visitor_management_system.model.VisitStatus;
import io.bootify.visitor_management_system.repos.UserRepository;
import io.bootify.visitor_management_system.repos.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitService visitService;



    public List<VisitDTO> findAllVisitsWithStatus(Long userId, VisitStatus visitStatus) {
        User user = userRepository.findById(userId).get();
        Flat flat = user.getFlat();
        List<Visit> visitList = visitRepository.findAllByFlatAndStatus(flat,visitStatus);
        return visitList
                .stream()
                .map(visit -> visitService.mapToDTO(visit, new VisitDTO()))
                .collect(Collectors.toList());
    }
}