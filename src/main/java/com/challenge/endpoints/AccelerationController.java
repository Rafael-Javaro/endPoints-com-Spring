package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    AccelerationService accelerationService;

    @Autowired
    AccelerationRepository accelerationRepository;

    @GetMapping
    public List<Acceleration> findAll() {
        return this.accelerationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Acceleration> findAccelerationById(@PathVariable("id") Long id) { return this.accelerationService.findById(id); }

    @GetMapping(params = "companyId")
    public List<Acceleration> findAccelerationByCompanyId(@RequestParam Long companyId) { return this.accelerationService.findByCompanyId(companyId); }
    
}
