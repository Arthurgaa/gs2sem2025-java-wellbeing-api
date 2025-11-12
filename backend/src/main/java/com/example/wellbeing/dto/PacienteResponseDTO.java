package com.example.wellbeing.dto;

import java.time.LocalDate;

public class PacienteResponseDTO {
    private Long id; private String nome; private String email; private LocalDate dataNascimento;
    public PacienteResponseDTO(){}
    public PacienteResponseDTO(Long id,String nome,String email,LocalDate dataNascimento){this.id=id;this.nome=nome;this.email=email;this.dataNascimento=dataNascimento;}
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getNome(){return nome;} public void setNome(String v){nome=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public LocalDate getDataNascimento(){return dataNascimento;} public void setDataNascimento(LocalDate v){dataNascimento=v;}
}
