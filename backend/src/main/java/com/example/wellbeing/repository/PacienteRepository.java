package com.example.wellbeing.repository;

import com.example.wellbeing.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> { boolean existsByEmail(String email); }
