package url.teste;

import com.google.gson.Gson;
import url.ConversorJson;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TesteStandAlone {

    public static void main(String[] args) {

        try {
            Gson gson = new Gson();
            CodigoDescricao cd = new CodigoDescricao();
            cd.setValor(2);
            cd.setDescricao("esse é um teste de descrição, né");

            Cor cor = new Cor();
            cor.setValor(1);
            List<String> lcor = new ArrayList<>();
            lcor.add("azul");
            lcor.add("amarelo");
            lcor.add("vermelho");
            lcor.add("verde");
            lcor.add("rosa");
            lcor.add("azul");
            cor.setCorlista(lcor);

            String uriGson1 = gson.toJson(cd, CodigoDescricao.class).replace("2", "\"2\"");
            String uriGson2 = gson.toJson(cor, Cor.class).replace("1", "\"2\"");

            System.out.println("---- Json gerado pelo Gson ----------------------------------------------------------");
            System.out.println("coversão uriGson1.......: " + uriGson1);
            System.out.println("coversão uriGson2.......: " + uriGson2 + "\n");


            String url1 = "https://quasar.com.br/teste?valor=2&descricao=esse%20%C3%A9%20um%20teste%20de%20descri%C3%A7%C3%A3o%2C%20n%C3%A9%3F";
            String url2 = "https://quasar.com.br/teste?valor=2&corlista=azul&corlista=amarelo&corlista=vermelho&corlista=verde&corlista=rosa&corlista=azul";

            ConversorJson conversorJson = new ConversorJson();
            String jsonC1 = conversorJson.urlToJson(url1);
            String jsonC2 = conversorJson.urlToJson(url2);

            System.out.println("---- Json gerado pelo conversor -----------------------------------------------------");
            System.out.println("Url Convertida 1........: " + jsonC1);
            System.out.println("Url Convertida 2........: " + jsonC2 + "\n");

            System.out.println("---- Verificando os jsons gerados pelo conversor com os gerados pelo gson -----------");
            System.out.println("uriGson1 == jsonC1......: " + jsonC1.equals(uriGson1));
            System.out.println("uriGson2 == jsonC2......: " + jsonC2.equals(uriGson2) + "\n");

            System.out.println("---- Iniciando teste com conversão Gson ---------------------------------------------");
            System.out.println("Json from uriGson1......: " + gson.fromJson(uriGson1, CodigoDescricao.class));
            System.out.println("Json from uriGson2......: " + gson.fromJson(uriGson2, Cor.class));
            System.out.println("Json 1 uriC1............: " + gson.fromJson(jsonC1, CodigoDescricao.class));
            System.out.println("Json 2 uriC2............: " + gson.fromJson(jsonC2, Cor.class) + "\n");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}