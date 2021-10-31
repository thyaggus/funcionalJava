package url.teste;

public class CodigoDescricao {
    private int valor;
    private String descricao;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "codigoDescricao{" +
                "valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
