package com.example.wellbeing.controller;

import com.example.wellbeing.dto.PacienteRequestDTO;
import com.example.wellbeing.dto.PacienteResponseDTO;
import com.example.wellbeing.entity.Paciente;
import com.example.wellbeing.mapper.PacienteMapper;
import com.example.wellbeing.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService service;
    public PacienteController(PacienteService service){ this.service = service; }

    @GetMapping
    public List<PacienteResponseDTO> listar(){
        return service.listar().stream().map(PacienteMapper::toResponse).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscar(@PathVariable Long id){
        Paciente p = service.buscar(id);
        return ResponseEntity.ok(PacienteMapper.toResponse(p));
    }
    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criar(@Valid @RequestBody PacienteRequestDTO dto){
        Paciente p = service.criar(dto);
        return ResponseEntity.created(URI.create("/api/pacientes/"+p.getId())).body(PacienteMapper.toResponse(p));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PacienteRequestDTO dto){
        Paciente p = service.atualizar(id, dto);
        return ResponseEntity.ok(PacienteMapper.toResponse(p));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
