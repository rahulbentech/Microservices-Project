package com.in28minutes.rest.webservices.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.rest.bean.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
