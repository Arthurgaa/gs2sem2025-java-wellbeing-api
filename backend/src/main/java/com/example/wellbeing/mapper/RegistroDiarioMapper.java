package com.example.wellbeing.mapper;

import com.example.wellbeing.dto.RegistroDiarioRequestDTO;
import com.example.wellbeing.dto.RegistroDiarioResponseDTO;
import com.example.wellbeing.entity.Paciente;
import com.example.wellbeing.entity.RegistroDiario;

public class RegistroDiarioMapper {
    public static RegistroDiario toEntity(RegistroDiarioRequestDTO dto, Paciente paciente){
        RegistroDiario r = new RegistroDiario();
        r.setDataRegistro(dto.getDataRegistro());
        r.setNivelHumor(dto.getNivelHumor());
        r.setNivelAnsiedade(dto.getNivelAnsiedade());
        r.setHorasSono(dto.getHorasSono());
        r.setPaciente(paciente);
        return r;
    }
    public static RegistroDiarioResponseDTO toResponse(RegistroDiario r){
        return new RegistroDiarioResponseDTO(r.getId(), r.getDataRegistro(), r.getNivelHumor(), r.getNivelAnsiedade(), r.getHorasSono(), r.getPaciente().getId(), r.getPaciente().getNome());
    }
    public static void update(RegistroDiario r, RegistroDiarioRequestDTO dto, Paciente paciente){
        r.setDataRegistro(dto.getDataRegistro());
        r.setNivelHumor(dto.getNivelHumor());
        r.setNivelAnsiedade(dto.getNivelAnsiedade());
        r.setHorasSono(dto.getHorasSono());
        r.setPaciente(paciente);
    }
}
