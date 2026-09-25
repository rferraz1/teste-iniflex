# Teste Prático - Iniflex

Solução do teste prático de programação Java proposto pela Iniflex (processo seletivo via Gupy).

## Requisitos atendidos

1. Classe `Pessoa` (nome, dataNascimento).
2. Classe `Funcionario` que estende `Pessoa` (salario, funcao).
3. Classe `Principal` executando, em ordem:
   - 3.1 Inserção de todos os funcionários da tabela.
      - 3.2 Remoção do funcionário "João".
         - 3.3 Impressão de todos os funcionários (data em `dd/MM/yyyy`, valores com separador de milhar `.` e decimal `,`).
            - 3.4 Aumento de 10% no salário de todos.
               - 3.5 Agrupamento por função em um `Map<String, List<Funcionario>>`.
                  - 3.6 Impressão dos funcionários agrupados por função.
                     - 3.8 Impressão dos funcionários que fazem aniversário nos meses 10 e 12.
                        - 3.9 Impressão do funcionário com maior idade (nome e idade).
                           - 3.10 Impressão da lista em ordem alfabética.
                              - 3.11 Impressão do total dos salários.
                                 - 3.12 Impressão de quantos salários mínimos cada funcionário recebe (salário mínimo = R$ 1.212,00).

                                 ## Como executar

                                 ### Via Maven
                                 ```
                                 mvn compile exec:java -Dexec.mainClass="com.iniflex.teste.Principal"
                                 ```
                                 ou gerar o jar e executar:
                                 ```
                                 mvn package
                                 java -jar target/teste-iniflex.jar
                                 ```

                                 ### Via linha de comando (sem Maven)
                                 ```
                                 javac -d out $(find src -name "*.java")
                                 java -cp out com.iniflex.teste.Principal
                                 ```

                                 ### Via IDE (Eclipse, NetBeans, IntelliJ)
                                 Importe a pasta como projeto Maven e execute a classe `com.iniflex.teste.Principal`.

                                 ## Observação sobre o requisito 3.9

                                 A "maior idade" é calculada com base na data atual do sistema (`LocalDate.now()`), portanto o valor impresso reflete a idade no momento da execução.
                                 
