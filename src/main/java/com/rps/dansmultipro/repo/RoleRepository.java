package com.rps.dansmultipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rps.dansmultipro.domain.Role;

/**
 * @author rudi_
 * Feb 11, 2023
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query(value = "select * from role where name = ?1", nativeQuery = true)
    Role findByName(String name);
}