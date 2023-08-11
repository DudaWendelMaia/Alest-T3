class Node {
   private char letra;
    private String significado;
    private Node primeiroFilho;
    private Node proximoIrmao;


     public Node(char letra) {
        this.letra = letra;
        this.significado = null;
        this.primeiroFilho = null;
        this.proximoIrmao = null;
    }

   public char getLetra() {
        return letra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public Node getPrimeiroFilho() {
        return primeiroFilho;
    }

    public Node getProximoIrmao() {
        return proximoIrmao;
    }

    public Node getFilho(char letra) {
        Node filho = primeiroFilho;
        while (filho != null) {
            if (filho.getLetra() == letra) {
                return filho;
            }
            filho = filho.getProximoIrmao();
        }
        return null;
    }

    public void addFilho(Node filho) {
        if (primeiroFilho == null) {
            primeiroFilho = filho;
        } else {
            Node irmao = primeiroFilho;
            while (irmao.getProximoIrmao() != null) {
                irmao = irmao.getProximoIrmao();
            }
            irmao.proximoIrmao = filho;
        }
    }

    // public boolean isLeaf() {
    //     return primeiroFilho == null;
    // }
}

