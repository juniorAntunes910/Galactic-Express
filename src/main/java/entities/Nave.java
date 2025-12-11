package entities;

public class Nave {
    private int id;
    private String nome;
    private int capacidade;
    private double precoBase;
    private boolean disponivel;

    public Nave(String nome, int capacidade, double precoBase, boolean disponivel) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.precoBase = precoBase;
        this.disponivel = disponivel;
    }

    public Nave(int id, String nome, int capacidade, double precoBase, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.precoBase = precoBase;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capacidade=" + capacidade +
                ", precoBase=" + precoBase +
                ", disponivel=" + disponivel +
                '}';
    }
}
