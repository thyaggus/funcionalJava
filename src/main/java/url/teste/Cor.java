package url.teste;

import java.util.List;

public class Cor {
    private int valor;
    private List<String> corlista;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<String> getCorlista() {
        return corlista;
    }

    public void setCorlista(List<String> corlista) {
        this.corlista = corlista;
    }

    @Override
    public String toString() {
        return "Cor{" +
                "valor=" + valor +
                ", corlista=" + corlista +
                '}';
    }
}
