package entities;

public class Passageiro {
    private int id;
    private String nome;
    private String rgEspacial;
    private String email;

    public Passageiro(String nome, String rgEspacial, String email) {
        this.nome = nome;
        this.rgEspacial = rgEspacial;
        this.email = email;
    }

    public Passageiro(int id, String nome, String rgEspacial, String email) {
        this.id = id;
        this.nome = nome;
        this.rgEspacial = rgEspacial;
        this.email = email;
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

    public String getRgEspacial() {
        return rgEspacial;
    }

    public void setRgEspacial(String rgEspacial) {
        this.rgEspacial = rgEspacial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rgEspacial='" + rgEspacial + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
