package com.example.wellbeing.service;

import com.example.wellbeing.dto.RegistroDiarioRequestDTO;
import com.example.wellbeing.entity.Paciente;
import com.example.wellbeing.entity.RegistroDiario;
import com.example.wellbeing.exception.NotFoundException;
import com.example.wellbeing.mapper.RegistroDiarioMapper;
import com.example.wellbeing.repository.PacienteRepository;
import com.example.wellbeing.repository.RegistroDiarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RegistroDiarioService {
    private final RegistroDiarioRepository repo;
    private final PacienteRepository pacienteRepo;
    public RegistroDiarioService(RegistroDiarioRepository repo, PacienteRepository pacienteRepo){ this.repo = repo; this.pacienteRepo = pacienteRepo; }
    public List<RegistroDiario> listar(){ return repo.findAll(); }
    public RegistroDiario buscar(Long id){ return repo.findById(id).orElseThrow(()-> new NotFoundException("Registro não encontrado: " + id)); }
    @Transactional public RegistroDiario criar(RegistroDiarioRequestDTO dto){
        Paciente pac = pacienteRepo.findById(dto.getPacienteId()).orElseThrow(()-> new NotFoundException("Paciente não encontrado: " + dto.getPacienteId()));
        return repo.save(RegistroDiarioMapper.toEntity(dto, pac));
    }
    @Transactional public RegistroDiario atualizar(Long id, RegistroDiarioRequestDTO dto){
        RegistroDiario r = buscar(id);
        Paciente pac = pacienteRepo.findById(dto.getPacienteId()).orElseThrow(()-> new NotFoundException("Paciente não encontrado: " + dto.getPacienteId()));
        RegistroDiarioMapper.update(r, dto, pac);
        return repo.save(r);
    }
    @Transactional public void remover(Long id){ RegistroDiario r = buscar(id); repo.delete(r); }
}
