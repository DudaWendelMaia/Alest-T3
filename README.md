Exercicio desenvolvido para o trabalho 3 da cadeira de Algoritmos e Estruturas de Dados

# T3 Alest 
Trabalhando com Árvores

## Instruções
O objetivo deste trabalho, é desenvolver uma solução para
gerenciar uma árvore de palavras para um dicionário. Para isto, deverá ser lido um arquivo de palavras com
seus significados que deverá ser armazenado em uma árvore. A partir de dois ou três caracteres digitados,
deverá ser apresentada a lista de palavras que começam com estes caracteres.

## Detalhamento
As palavras devem ser armazenadas, caractere a caractere, em uma árvore genérica da seguinte maneira:

Deve haver uma maneira de indicar que um nodo é o último caractere que forma uma palavra e que conterá o
significado da palavra. Assim, as palavras são compostas pelos caracteres armazenados nos nodos visitados da
raiz até o último caractere que forma a palavra.

Para possibilitar uma consulta ao dicionário, a entrada deve ser um conjunto de caracteres, e a saída deve ser
as possíveis palavras que podem ser formadas a partir deste conjunto de caracteres. Considerando a árvore
exemplificada acima, se fosse digitado “ba”, a lista de palavras de saída seria: baia, baiano, bala e bar. A partir
disso, é escolhida uma destas palavras para apresentar o seu significado.

## Estrutura de Dados:
A estrutura de dados a ser desenvolvida obrigatoriamente deve ser baseada em uma árvore genérica. Sugerese ter como referência a implementação de árvore genérica estudada. Neste caso, a classe
Node deve armazenar um caractere e sempre que for o último caractere que forma uma palavra, deve
armazenar também o seu significado (por exemplo, pode ser incluído um atributo “String significado”, se for null é
porque não é o último caractere que forma a palavra). Além disso, os seus métodos devem ser alterados para
darem suporte às funcionalidades necessárias.

## Aplicação:
Para usar e testar a estrutura de dados desenvolvida deverá ser feita uma aplicação para um dicionário. O
funcionamento deve ser o seguinte:

• É fornecido um conjunto de caracteres;
• Após a pesquisa na árvore é retornada uma lista de palavras que iniciam com os caracteres fornecidos;
• É escolhida uma palavra desta lista;
• É apresentado o significado desta palavra.

## Formato do Arquivo de Entrada:
O arquivo do dicionário deverá ter o seguinte formato:
Palavra 1; significado da palavra 1

Palavra 2; significado da palavra 2

Palavra 3; significado da palavra 3

Importante: este arquivo não pode conter caracteres com acento!
