package br.com.prontuni.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity(name="PACIENTE")
public class Paciente {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DT_NASC")
    private String dataNascimento;

    @Column(name = "GENERO")
    private char genero;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "TELEFONE")
    private Long telefone;

    @Column(name = "UBS")
    private String ubs;

    public Paciente(String nome, String dataNascimento, char genero, String endereco, String cidade, Long telefone, String ubs) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.ubs = ubs;
    }

    public Paciente() {

    }
}
