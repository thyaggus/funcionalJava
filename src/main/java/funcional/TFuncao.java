package funcional;

import java.util.function.Consumer;
import java.util.function.Function;

public class TFuncao {

    public void execucao() {

        System.out.println("Inioio da exexução");
        Funcao<TBeanTransacao, TBean> funcao = new Funcao<>();

        funcao.setDados(new TBeanTransacao(3, "tres"));

        TBean retorno = funcao.processar(t -> new TBean(t.getIdentificador() * 10, t.getDescritor() + "******"));

        System.out.println(retorno);

    }
}
