# Jogo Sudoku - Orientação a Objetos em Java
**Departamento de Ciência da Computação - DCC - UFJF**  
**Aluna: Vitória Isabela de Oliveira**  
**E-mail: vitoriaisabela.oliveira@estudante.ufjf.br**  

---

## Trabalho 1 – Sudoku

### ❖ Descrição Geral
O trabalho consiste em implementar o jogo Sudoku utilizando a linguagem de programação Java.  

#### Regras para Entrega:
- O exercício deve ser entregue em um arquivo no formato `.ZIP`, seguindo a nomenclatura: **“NNNN-MMMM.zip”**, onde **NNNN** é o nome do aluno e **MMMM** é a sua matrícula. Exercícios fora do formato `.zip` serão descartados.  
- Os projetos devem utilizar o **Maven** para construção, utilizando o comando `mvn install` através da configuração do `pom.xml`, conforme apresentado em sala de aula.  
- Os projetos devem utilizar o **JDK 21**.  
- Os arquivos devem ser enviados via **Google Classroom**, limitado à data e hora de entrega definida. **Não serão aceitos trabalhos enviados por e-mail ou com atraso.**  
- Exercícios que não seguirem as especificações serão desconsiderados.  

---

### ❖ Sudoku
Sudoku é um jogo de raciocínio e lógica que consiste em preencher, com números de 1 a 9, espaços em branco em uma tabela com nove linhas e nove colunas. Para completar esses espaços, as seguintes regras devem ser respeitadas:  
1. **Não repetir números na horizontal (linha).**  
2. **Não repetir números na vertical (colunas).**  
3. **Não repetir números nos quadrados de tamanho 3x3.**  

Na **Figura 1** é possível visualizar uma configuração inicial do jogo Sudoku, ainda não preenchido, com suas linhas, colunas e quadrados (cada um com tamanho 3x3).  

Na **Figura 2**, os números em vermelho representam a solução para o quebra-cabeça proposto na figura anterior. Observem que as regras 1, 2 e 3 estão sendo respeitadas e, portanto, essa solução é válida.  

**Implementação online disponível em:** [https://sudoku.com/pt](https://sudoku.com/pt)  

---

### ❖ Implementação
O aluno deve implementar um gerador automático de Sudoku e um menu interativo em Java no próprio console (não há necessidade de criação de janelas gráficas) para jogar. As seguintes atividades devem ser executadas:  

#### **Atividade 1 (Criando a Configuração Inicial do Jogo)**  
Criar uma tela de boas-vindas para o jogador e perguntar ao usuário se ele pretende gerar um jogo aleatório ou definir o próprio jogo.  

- **Jogo Aleatório:**  
  O programa pergunta ao usuário quantos números ele deseja sortear e criar o jogo.  

- **Definir Jogo:**  
  O usuário define os valores iniciais do jogo com o seguinte formato: **“([linha],[coluna],[valor])”**.  
  - Exemplo: `(2,5,3)` representa **linha=2**, **coluna=5** e **valor=3**.  
  - O programa também deve permitir várias entradas simultâneas, por exemplo:  
    `(2,5,3)(2,6,4)(2,9,1)` representa:  
    - Linha=2, Coluna=5, Valor=3;  
    - Linha=2, Coluna=6, Valor=4;  
    - Linha=2, Coluna=9, Valor=1.  
  - Quando o usuário estiver satisfeito, ele decide encerrar a inserção dos valores iniciais digitando a entrada **(-1, -1, -1)**.  

**Observação:** O domínio das linhas, colunas e valores são inteiros no intervalo **[1,9]**.  

---

#### **Atividade 2 (Vamos Jogar?)**  
Após a definição da configuração inicial do jogo, nessa atividade deve ser criada uma tela com a dinâmica do jogo com as seguintes opções:  

1. **Adicionar Jogada:**  
   - Para adicionar uma jogada, o usuário entra com os dados relacionados à linha, coluna e valor no seguinte formato: **“(linha,coluna,valor)”**, sem espaços, respeitando o domínio de entrada.  
   - Entradas fora do formato devem ser descartadas. Por exemplo:  
     - `(2 , 5, 9)` (espaço após a vírgula),  
     - `(1,2)` (faltando valor),  
     - `(0,0,0)` (fora do domínio).  
   - O usuário pode fornecer mais de uma entrada ao mesmo tempo, e todas devem ser processadas. Por exemplo, para a entrada `(1,1,2)(2,2,3)`, as duas jogadas devem ser processadas e adicionadas, caso nenhum outro valor já esteja na linha e coluna selecionada.  
   - No caso de rejeitar uma entrada, descreva o motivo. Por exemplo:  
     - Caso a entrada `(2,2,3)` já tenha um valor na mesma posição, crie uma mensagem dizendo:  
       **“A entrada (2,2,3) não foi inserida, pois já possui um valor atribuído.”**  

2. **Remover Jogada:**  
   - Para remover uma jogada, o usuário fornece o valor da linha e coluna a ser removida no formato **“(linha,coluna)”**, sem espaço e respeitando o domínio da entrada.  
   - **Observação:** Os valores definidos na **Atividade 1** não podem ser removidos.  

3. **Verificar:**  
   - Para avaliar se o jogo está correto até o momento. Caso alguma das três regras não sejam satisfeitas, o programa deve criar um relatório descrevendo as quebras.  

4. **Dica:**  
   - Oferecer uma opção de dica, informando quais os valores podem ser adicionados em uma posição específica.  
   - Para isso, o usuário deve fornecer a linha e coluna no formato **“(linha,coluna)”**, sem espaço e respeitando o domínio da entrada.  
   - A dica deverá retornar o conjunto dos valores que podem ser adicionados nessa posição.  

5. **Sair:**  
   - Para sair do jogo.  

---

#### **Atividade 3 (Indicar o Fim do Jogo)**  
Criar uma tela que escreva uma mensagem parabenizando o vencedor e ofereça a opção de jogar novamente.  

---

### ❖ Atividades Complementares
- O programa não deverá permitir adicionar valores inválidos ou posições inválidas; por exemplo:  
  - Tentar adicionar números maiores que nove.  
  - Tentar adicionar na posição `(-1,200)`.  
- O programa deve negar edições nas posições definidas na **Atividade 1**.  
- O programa deverá apresentar (imprimir) toda a tabela do jogo após cada inserção e remoção.  
- O programa deverá tratar todas as entradas e negar entradas inválidas sem parar a execução.  

---

### ❖ Avaliação
A avaliação vai considerar os seguintes aspectos:  

1. **Clareza e Organização do Código:**  
   - O código está bem estruturado, com indentação e formatação adequadas?  

2. **Nomenclatura:**  
   - Classes, métodos e atributos têm nomes significativos e seguem convenções?  

3. **Divisão Adequada em Classes e Pacotes:**  
   - O projeto foi dividido de maneira lógica, com classes organizadas em pacotes quando necessário?  

4. **Encapsulamento:**  
   - Os atributos estão devidamente privados, e o acesso é feito por métodos públicos?  

5. **Funcionalidade:**  
   - O programa funciona conforme o esperado?  
   - Ele resolve o problema ou atende aos requisitos propostos?  
   - A lógica implementada é eficiente e apresenta boa performance?  

6. **Usabilidade:**  
   - A interface é intuitiva e fácil de usar?  
