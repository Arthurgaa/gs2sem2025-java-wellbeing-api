package com.example.wellbeing.dto;

import java.time.LocalDate;

public class RegistroDiarioResponseDTO {
    private Long id; private LocalDate dataRegistro; private Integer nivelHumor; private Integer nivelAnsiedade; private Integer horasSono; private Long pacienteId; private String pacienteNome;
    public RegistroDiarioResponseDTO(){}
    public RegistroDiarioResponseDTO(Long id, LocalDate dataRegistro, Integer nivelHumor, Integer nivelAnsiedade, Integer horasSono, Long pacienteId, String pacienteNome){
        this.id=id; this.dataRegistro=dataRegistro; this.nivelHumor=nivelHumor; this.nivelAnsiedade=nivelAnsiedade; this.horasSono=horasSono; this.pacienteId=pacienteId; this.pacienteNome=pacienteNome;
    }
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public LocalDate getDataRegistro(){return dataRegistro;} public void setDataRegistro(LocalDate v){dataRegistro=v;}
    public Integer getNivelHumor(){return nivelHumor;} public void setNivelHumor(Integer v){nivelHumor=v;}
    public Integer getNivelAnsiedade(){return nivelAnsiedade;} public void setNivelAnsiedade(Integer v){nivelAnsiedade=v;}
    public Integer getHorasSono(){return horasSono;} public void setHorasSono(Integer v){horasSono=v;}
    public Long getPacienteId(){return pacienteId;} public void setPacienteId(Long v){pacienteId=v;}
    public String getPacienteNome(){return pacienteNome;} public void setPacienteNome(String v){pacienteNome=v;}
}
