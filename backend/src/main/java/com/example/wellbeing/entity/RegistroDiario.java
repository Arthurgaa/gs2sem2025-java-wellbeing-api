package com.example.wellbeing.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registros_diarios")
public class RegistroDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "nivel_humor", nullable = false)
    private Integer nivelHumor;

    @Column(name = "nivel_ansiedade", nullable = false)
    private Integer nivelAnsiedade;

    @Column(name = "horas_sono", nullable = false)
    private Integer horasSono;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }
    public Integer getNivelHumor() { return nivelHumor; }
    public void setNivelHumor(Integer nivelHumor) { this.nivelHumor = nivelHumor; }
    public Integer getNivelAnsiedade() { return nivelAnsiedade; }
    public void setNivelAnsiedade(Integer nivelAnsiedade) { this.nivelAnsiedade = nivelAnsiedade; }
    public Integer getHorasSono() { return horasSono; }
    public void setHorasSono(Integer horasSono) { this.horasSono = horasSono; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}
