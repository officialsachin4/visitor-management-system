package io.bootify.visitor_management_system.rest;

import io.bootify.visitor_management_system.model.VisitDTO;
import io.bootify.visitor_management_system.model.VisitStatus;
import io.bootify.visitor_management_system.service.ResidentService;
import io.bootify.visitor_management_system.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/resident", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResidentController {


    @Autowired
    private ResidentService residentService;


    @Autowired
    private VisitService visitService;


    @PutMapping("/visit/{id}/{status}")
    public ResponseEntity<Void> updateVisit(@PathVariable final Long id, @PathVariable VisitStatus status) {
        visitService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/visits/{status}")
    public ResponseEntity<List<VisitDTO>> getVisitsByStatus(@PathVariable VisitStatus status, @RequestHeader Long userId) {
        return ResponseEntity.ok(residentService.findAllVisitsWithStatus(userId,status));
    }

}