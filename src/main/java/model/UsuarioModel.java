package model;

public class UsuarioModel {

    private Long id_rebeldes;
    private String nome;
    private int idade;
    private String genero;
    private String localizacao;
    private String status;

    //Getters e Setters:


    public Long getId_rebeldes() {
        return id_rebeldes;
    }

    public void setId_rebeldes(Long id_rebeldes) {
        this.id_rebeldes = id_rebeldes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
