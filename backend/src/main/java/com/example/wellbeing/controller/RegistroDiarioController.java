package com.example.wellbeing.controller;

import com.example.wellbeing.dto.RegistroDiarioRequestDTO;
import com.example.wellbeing.dto.RegistroDiarioResponseDTO;
import com.example.wellbeing.entity.RegistroDiario;
import com.example.wellbeing.mapper.RegistroDiarioMapper;
import com.example.wellbeing.service.RegistroDiarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registros-diarios")
public class RegistroDiarioController {
    private final RegistroDiarioService service;
    public RegistroDiarioController(RegistroDiarioService service){ this.service = service; }

    @GetMapping
    public List<RegistroDiarioResponseDTO> listar(){
        return service.listar().stream().map(RegistroDiarioMapper::toResponse).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegistroDiarioResponseDTO> buscar(@PathVariable Long id){
        RegistroDiario r = service.buscar(id);
        return ResponseEntity.ok(RegistroDiarioMapper.toResponse(r));
    }
    @PostMapping
    public ResponseEntity<RegistroDiarioResponseDTO> criar(@Valid @RequestBody RegistroDiarioRequestDTO dto){
        RegistroDiario r = service.criar(dto);
        return ResponseEntity.created(URI.create("/api/registros-diarios/"+r.getId())).body(RegistroDiarioMapper.toResponse(r));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RegistroDiarioResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody RegistroDiarioRequestDTO dto){
        RegistroDiario r = service.atualizar(id, dto);
        return ResponseEntity.ok(RegistroDiarioMapper.toResponse(r));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
