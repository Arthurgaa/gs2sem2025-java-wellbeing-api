package com.example.wellbeing.service;

import com.example.wellbeing.dto.PacienteRequestDTO;
import com.example.wellbeing.entity.Paciente;
import com.example.wellbeing.exception.NotFoundException;
import com.example.wellbeing.mapper.PacienteMapper;
import com.example.wellbeing.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository repo;
    public PacienteService(PacienteRepository repo){ this.repo = repo; }
    public List<Paciente> listar(){ return repo.findAll(); }
    public Paciente buscar(Long id){ return repo.findById(id).orElseThrow(()-> new NotFoundException("Paciente não encontrado: " + id)); }
    @Transactional public Paciente criar(PacienteRequestDTO dto){ return repo.save(PacienteMapper.toEntity(dto)); }
    @Transactional public Paciente atualizar(Long id, PacienteRequestDTO dto){ Paciente p = buscar(id); PacienteMapper.update(p, dto); return repo.save(p); }
    @Transactional public void remover(Long id){ Paciente p = buscar(id); repo.delete(p); }
}
