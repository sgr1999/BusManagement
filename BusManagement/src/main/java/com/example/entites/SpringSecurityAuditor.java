package com.example.entites;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        
        return Optional.ofNullable("sagar").filter(s -> !s.isEmpty());
    }
    
}
