package model.bean;

public class Carro {
    private Marcas marca;
    private float preco;
    private Pessoa dono;

    public Carro(Marcas marca, float preco, Pessoa dono) {
        this.marca = marca;
        this.preco = preco;
        this.dono = dono;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }
}
