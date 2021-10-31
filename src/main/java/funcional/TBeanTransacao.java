package funcional;

public class TBeanTransacao {

    private int identificador;
    private String descritor;

    public TBeanTransacao() {
    }

    public TBeanTransacao(int identificador, String descritor) {
        this.identificador = identificador;
        this.descritor = descritor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDescritor() {
        return descritor;
    }

    public void setDescritor(String descritor) {
        this.descritor = descritor;
    }

    @Override
    public String toString() {
        return "TBeanTransacao{" +
                "identificador=" + identificador +
                ", descritor='" + descritor + '\'' +
                '}';
    }
}
