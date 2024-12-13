package com.vasiliskardaras.security_2fa.repository;

import com.vasiliskardaras.security_2fa.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
