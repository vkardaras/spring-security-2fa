package com.vasiliskardaras.security_jpa.repository;

import com.vasiliskardaras.security_jpa.model.Authority;
import com.vasiliskardaras.security_jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
