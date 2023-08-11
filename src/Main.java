public class Main {
    public static void main(String[] args) {
        
        Dicionario dicionario = new Dicionario();
        dicionario.construirDicionario("dicionario.csv"); 

        String prefixo = "z";
        String[] palavrasEncontradas = dicionario.buscarPalavrasComPrefixo(prefixo);
        dicionario.escolherPalavra(palavrasEncontradas);
    }
}
