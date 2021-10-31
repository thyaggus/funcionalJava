package funcional;

import java.util.function.Consumer;
import java.util.function.Function;

public class Funcao<T, R> {

    private T dados;

    public R processar(Function<? super T, ? extends R> argumento) {
        return argumento.apply(dados);
    }

    public void setDados(T t) {
        this.dados = t;
    }

}
