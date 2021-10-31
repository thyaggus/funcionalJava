package url;

public class Json {

    private String json;

    public Json() {
        this.json = "{";
    }

    public void addJsonElement(String elemento) {
        if (this.json .length() > 1) {
            this.json += "," + elemento;
        } else {
            this.json += elemento;
        }

    }

    public void addJsonElement(String chave, String valor) {
        String elemento = "\"" + chave + "\":\"" + valor + "\"";
        addJsonElement(elemento);
    }

    public String formatarValor(String valor) {
        return "\"" + valor + "\",";
    }

    public void addJsonArrayElement(String chave, String valores) {
        String elemento = "\"" + chave + "\":[" + valores.substring(0, valores.length()-1) + "]";
        addJsonElement(elemento);
    }

    public String getJson() {
        return this.json += "}";
    }

}
