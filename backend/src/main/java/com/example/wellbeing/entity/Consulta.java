package com.example.wellbeing.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_consulta", nullable = false)
    private LocalDateTime dataHoraConsulta;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_consulta", nullable = false)
    private StatusConsulta statusConsulta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profissional_id")
    private ProfissionalSaude profissional;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDataHoraConsulta() { return dataHoraConsulta; }
    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) { this.dataHoraConsulta = dataHoraConsulta; }
    public StatusConsulta getStatusConsulta() { return statusConsulta; }
    public void setStatusConsulta(StatusConsulta statusConsulta) { this.statusConsulta = statusConsulta; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public ProfissionalSaude getProfissional() { return profissional; }
    public void setProfissional(ProfissionalSaude profissional) { this.profissional = profissional; }
}
