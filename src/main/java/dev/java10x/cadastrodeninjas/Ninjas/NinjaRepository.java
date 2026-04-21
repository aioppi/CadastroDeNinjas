package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
    // JpaRepository já fornece métodos prontos:
    // save(), findById(), findAll(), deleteById(), etc.
}