package model;

public class ProjetosMarinhos {

    private String nome;
    private String data;
    private String localizacao;

    public ProjetosMarinhos(String nome, String data, String localizacao) {
        this.nome = nome;
        this.data = data;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
