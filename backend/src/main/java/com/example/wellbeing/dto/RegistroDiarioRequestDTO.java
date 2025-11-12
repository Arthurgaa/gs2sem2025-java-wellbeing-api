package com.example.wellbeing.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class RegistroDiarioRequestDTO {
    @NotNull
    private LocalDate dataRegistro;
    @NotNull @Min(1) @Max(5)
    private Integer nivelHumor;
    @NotNull @Min(0) @Max(10)
    private Integer nivelAnsiedade;
    @NotNull @Min(0) @Max(24)
    private Integer horasSono;
    @NotNull
    private Long pacienteId;
    public LocalDate getDataRegistro(){return dataRegistro;} public void setDataRegistro(LocalDate v){dataRegistro=v;}
    public Integer getNivelHumor(){return nivelHumor;} public void setNivelHumor(Integer v){nivelHumor=v;}
    public Integer getNivelAnsiedade(){return nivelAnsiedade;} public void setNivelAnsiedade(Integer v){nivelAnsiedade=v;}
    public Integer getHorasSono(){return horasSono;} public void setHorasSono(Integer v){horasSono=v;}
    public Long getPacienteId(){return pacienteId;} public void setPacienteId(Long v){pacienteId=v;}
}
