package com.example.wellbeing.mapper;

import com.example.wellbeing.dto.PacienteRequestDTO;
import com.example.wellbeing.dto.PacienteResponseDTO;
import com.example.wellbeing.entity.Paciente;

public class PacienteMapper {
    public static Paciente toEntity(PacienteRequestDTO dto){
        Paciente p = new Paciente();
        p.setNome(dto.getNome());
        p.setEmail(dto.getEmail());
        p.setDataNascimento(dto.getDataNascimento());
        return p;
    }
    public static PacienteResponseDTO toResponse(Paciente p){
        return new PacienteResponseDTO(p.getId(), p.getNome(), p.getEmail(), p.getDataNascimento());
    }
    public static void update(Paciente p, PacienteRequestDTO dto){
        p.setNome(dto.getNome());
        p.setEmail(dto.getEmail());
        p.setDataNascimento(dto.getDataNascimento());
    }
}
