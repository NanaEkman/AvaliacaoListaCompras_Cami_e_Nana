package ads.pdm.avaliacaolistacompras_cami_e_nana;

public class Item {

    private String nome;
    private String marca;
    private String quant;
    private String comprado;

    public Item(String nome, String marca, String quant) {
        this.nome = nome;
        this.marca = marca;
        this.quant = quant;
        this.comprado = "";
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getQuant() {
        return quant;
    }

    public String getComprado() {
        return comprado;
    }

    public void setComprado(String comprado) {
        this.comprado = comprado;
    }
}
