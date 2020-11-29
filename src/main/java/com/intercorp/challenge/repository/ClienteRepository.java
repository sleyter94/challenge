package com.intercorp.challenge.repository;

import com.intercorp.challenge.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long> {


}
