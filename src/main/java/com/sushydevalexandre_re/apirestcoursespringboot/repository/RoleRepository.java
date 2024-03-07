package com.sushydevalexandre_re.apirestcoursespringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sushydevalexandre_re.apirestcoursespringboot.configsecurity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
	Optional<Role> findByAuthority(String authority);
}
