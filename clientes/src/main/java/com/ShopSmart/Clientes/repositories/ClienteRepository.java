package com.ShopSmart.Clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ShopSmart.Clientes.models.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    @Query("SELECT COUNT(c) > 0 FROM Cliente c WHERE c.run_cli = ?1")
    boolean existsByRun_cli(String run_cli);

    @Query("SELECT COUNT(c) > 0 FROM Cliente c WHERE c.email_cli = ?1")
    boolean existsByEmail_cli(String email_cli);
}
