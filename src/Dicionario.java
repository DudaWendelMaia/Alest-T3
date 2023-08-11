import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dicionario {
    private Node root; // Raiz da árvore

    public Dicionario() {
         this.root = new Node(' ');
    }

    public void construirDicionario(String filePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
             int lineIndex = 0; 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                     String palavra = parts[0].trim().toLowerCase();
                     String significado = parts[1].trim();
                      if (lineIndex == 0) {
                    // Pular a primeira letra da primeira palavra
                    palavra = parts[0].substring(1).trim().toLowerCase();
                    significado = parts[1].trim();
                } else {
                    palavra = parts[0].trim().toLowerCase();
                    significado = parts[1].trim();
                }
                    inserePalavra(palavra, significado);
                }
                lineIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public void inserePalavra(String palavra, String significado) {
        Node nodoAtual = root;

        for (int i = 0; i < palavra.length(); i++) {
             char letra = Character.toLowerCase(palavra.charAt(i)); 
            Node filho = nodoAtual.getFilho(letra);

            if (filho == null) {
                filho = new Node(letra);
                nodoAtual.addFilho(filho);
            }

            nodoAtual = filho;
        }

        nodoAtual.setSignificado(significado);
    }

     public String[] buscarPalavrasComPrefixo(String prefixo) {
        String[] palavrasEncontradas = new String[100]; 
        int count = 0;
        prefixo = prefixo.toLowerCase();
        Node nodoAtual = root;

        for (int i = 0; i < prefixo.length(); i++) {
            char letra = Character.toLowerCase(prefixo.charAt(i));
            Node filho = nodoAtual.getFilho(letra);

            if (filho == null) {
                return palavrasEncontradas;
            }

            nodoAtual = filho;
        }

        count = buscarPalavrasRecursivo(nodoAtual, prefixo, palavrasEncontradas, count);
        return resizeArray(palavrasEncontradas, count);
    }

    private int buscarPalavrasRecursivo(Node node, String prefix, String[] palavrasEncontradas, int count) {
    if (node.getSignificado() != null) {
        palavrasEncontradas[count] = prefix;
        count++;
    }

    Node child = node.getPrimeiroFilho();
    while (child != null) {
        count = buscarPalavrasRecursivo(child, prefix + child.getLetra(), palavrasEncontradas, count);
        child = child.getProximoIrmao();
    }

    return count;
}

    public void escolherPalavra(String[] palavras) {
        if (palavras[0] == null) {
            System.out.println("Nenhuma palavra encontrada com o prefixo fornecido.");
            return;
        }

        System.out.println("Palavras encontradas:");
        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i] != null) {
                System.out.println((i + 1) + ". " + palavras[i]);
            }
        }

        int escolha = 0;
        do {
            System.out.print("Escolha uma palavra (1-" + palavras.length + "): ");
            escolha = lerInteiro();

            if (escolha < 1 || escolha > palavras.length) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha < 1 || escolha > palavras.length);

        String palavraEscolhida = palavras[escolha - 1];
        exibirSignificado(palavraEscolhida);
    }

    private void exibirSignificado(String palavra) {
        Node nodoAtual = root;

        for (int i = 0; i < palavra.length(); i++) {
            char letra = Character.toLowerCase(palavra.charAt(i));
            Node filho = nodoAtual.getFilho(letra);

            if (filho == null) {
                System.out.println("Palavra não encontrada no dicionário.");
                return;
            }

            nodoAtual = filho;
        }

        String significado = nodoAtual.getSignificado();
        if (significado != null) {
            System.out.println("Significado de " + palavra + ": " + significado);
        } else {
            System.out.println("Palavra não encontrada no dicionário.");
        }
    }

    private int lerInteiro() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            return Integer.parseInt(input);
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }

    private String[] resizeArray(String[] array, int newSize) {
        String[] newArray = new String[newSize];
        System.arraycopy(array, 0, newArray, 0, newSize);
        return newArray;
    }

     public void procurarPalavras(String prefixo) {
        prefixo = prefixo.toLowerCase();
        Node nodoAtual = root;

        for (int i = 0; i < prefixo.length(); i++) {
            char letra = Character.toLowerCase(prefixo.charAt(i));
            Node filho = nodoAtual.getFilho(letra);

            if (filho == null) {
                System.out.println("Nenhuma palavra encontrada com o prefixo fornecido.");
                return;
            }

            nodoAtual = filho;
        }

        System.out.println("Palavras encontradas com o prefixo '" + prefixo + "':");
        printPalavras(nodoAtual, prefixo);
    }

    private void printPalavras(Node node, String prefix) {
    if (node.getSignificado() != null) {
        System.out.println(prefix + " - " + node.getSignificado());
    }

    Node child = node.getPrimeiroFilho();
    while (child != null) {
        printPalavras(child, prefix + child.getLetra());
        child = child.getProximoIrmao();
    }
}

}



