package model.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Pessoa {

    private String nome;
    private String cpf;
    private LocalDate nasc;

    public Pessoa() throws IOException {
        String[] temp = fabric();
        this.nome = temp[0]+" " +temp[1];
        this.cpf = temp[3];
        String[] formador = temp[2].split("/");
        this.nasc = LocalDate.of((Integer.parseInt(formador[2])),Integer.parseInt(formador[1]),Integer.parseInt(formador[0]));
    }

    public Pessoa(String nome, String cpf, String nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        String[] formador = nascimento.split("/");
        this.nasc = LocalDate.of((Integer.parseInt(formador[2])),Integer.parseInt(formador[1]),Integer.parseInt(formador[0]));
    }

    public int idade(){
        return (int) LocalDate.now().until(nasc, ChronoUnit.YEARS)*-1;
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
                "}\n";
    }

    private String[] fabric() throws IOException {
        String path = "src\\PessoaComSobrenome.csv";
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        Random gerador = new Random();
        String linha = "";

        String[] pessoa = new String[4];
        int[] index = new int[4];
        for (int i = 0; i < 4; i++) {
            index[i] = gerador.nextInt(649) + 1;
        }

        String[] temp = new String[5];
        int completo = 0;
        while (true) {
            if (linha != null && completo < 4) {
                temp = linha.split(",");
                if (!linha.equals("")) {
                    temp[0] = temp[0].replaceAll("\uFEFF", "");
                    int x = Integer.parseInt(temp[0]);

                    if (x == index[0]) {
                        pessoa[0] = temp[1];
                        completo++;
                    }
                    if (x == index[1]) {
                        pessoa[1] = temp[2];
                        completo++;
                    }
                    if (x == index[2]) {
                        String[] datet = temp[3].split("/");
                        String p = datet[0];
                        datet[0] = datet[1];
                        datet[1] = p;
                        pessoa[2] = datet[0] + "/" + datet[1] + "/" + datet[2];
                        completo++;
                    }
                    if (x == index[3]) {
                        pessoa[3] = temp[4];
                        completo++;
                    }
                }
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
        return pessoa;
    }
}
