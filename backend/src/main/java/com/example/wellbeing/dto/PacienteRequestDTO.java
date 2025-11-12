package com.example.wellbeing.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class PacienteRequestDTO {
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotNull @Past
    private LocalDate dataNascimento;
    public String getNome(){return nome;} public void setNome(String v){nome=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public LocalDate getDataNascimento(){return dataNascimento;} public void setDataNascimento(LocalDate v){dataNascimento=v;}
}
