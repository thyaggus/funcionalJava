package url;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConversorJson {

    private Json json;
    private Map<String, List<String>> mapaParametro;

    private void iniciar() {
        this.mapaParametro = new HashMap<>();
        this.json = new Json();
    }

    private void addMapa(String chave, String valor) {
        List<String> lvalor = this.mapaParametro.get(chave);
        if (lvalor == null) {
            lvalor = new ArrayList<>();
        }
        lvalor.add(valor);
        this.mapaParametro.put(chave, lvalor);
    }

    private String converter () {
        mapaParametro.forEach((c, v) -> {
            if (v.size() == 1) {
                this.json.addJsonElement(c, v.get(0));
            } else {
                String valores = v.stream().map(e -> this.json.formatarValor(e)).collect(Collectors.joining());
                this.json.addJsonArrayElement(c, valores);
            }
        });
        return this.json.getJson();
    }

    public String urlToJson(String url) throws UnsupportedEncodingException {
        iniciar();
        url = URLDecoder.decode(url, StandardCharsets.UTF_8.name());
        String[] partes = url.split("\\?");
        if (partes.length < 2) {
            return null;
        }
        String uri = partes[1];
        String[] parametros = uri.split("&");
        Gson gson = new Gson();
        for (String p : parametros) {
            String[] chaveValor = p.split("=");
            addMapa(chaveValor[0], chaveValor[1]);
        }
        return converter();
    }
}
