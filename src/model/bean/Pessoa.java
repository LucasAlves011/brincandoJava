package model.bean;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private String cpf;
    private LocalDate nasc;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        String[] formador = nascimento.split("/");
        this.nasc = LocalDate.of((Integer.parseInt(formador[2])),Integer.parseInt(formador[1]),Integer.parseInt(formador[0]));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNasc() {
        return nasc;
    }

    public void setNasc(LocalDate nasc) {
        this.nasc = nasc;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nasc=" + nasc +
                '}';
    }
}
