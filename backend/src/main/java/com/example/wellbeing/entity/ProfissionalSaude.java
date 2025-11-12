package com.example.wellbeing.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profissionais_saude")
public class ProfissionalSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "registro_profissional", nullable = false, unique = true)
    private String registroProfissional;

    @ManyToMany
    @JoinTable(name = "profissional_especialidade",
            joinColumns = @JoinColumn(name = "profissional_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    private Set<Especialidade> especialidades = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRegistroProfissional() { return registroProfissional; }
    public void setRegistroProfissional(String registroProfissional) { this.registroProfissional = registroProfissional; }
    public Set<Especialidade> getEspecialidades() { return especialidades; }
    public void setEspecialidades(Set<Especialidade> especialidades) { this.especialidades = especialidades; }
}
