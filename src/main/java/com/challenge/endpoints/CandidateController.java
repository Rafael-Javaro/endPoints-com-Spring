package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    // @GetMapping("{?????}")
    // public Optional<Candidate> findAll(@PathVariable("candidateDTO") CandidateDTO candidateDTO) {
    //   return this.candidateService.findById(candidateDTO.getUserId(), candidateDTO.getCompanyId(), candidateDTO.getAccelerationId());
    // }

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public Optional<Candidate> findAll(
            @PathVariable("userId") Long userId,
            @PathVariable("companyId") Long companyId,
            @PathVariable("accelerationId") Long accelerationId ) {
        return this.candidateService.findById(userId, companyId, accelerationId);
    }

    @GetMapping(params = "companyId")
    public List<Candidate> findByCompanyId(@RequestParam("companyId") Long companyId) {
        return this.candidateService.findByCompanyId(companyId);
    }

    @GetMapping(params = "accelerationId")
    public List<Candidate> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId) {
        return this.candidateService.findByAccelerationId(accelerationId);
    }
}
