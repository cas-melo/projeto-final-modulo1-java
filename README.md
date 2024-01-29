# Projeto Final - Agenda

Projeto final para o módulo I da formação em Java Back End para o Santander Coders 2023.2.
Essa aplicação consiste em uma agenda, onde o usuário pode adicionar, remover e editar contatos, bem como visualizar a lista de telefones associados a cada contato.
[(Documentation in english here.)](README_en.md)

## Funcionalidades

- Adicionar um novo contato com informações básicas (nome, sobrenome) e um ou mais números de telefone.
- Remover um contato existente.
- Editar as informações de um contato, incluindo nome, sobrenome e números de telefone.
- Exibir os detalhes de um contato específico.
- Salvar os contatos em um arquivo de texto para persistência de dados.
- Carregar os contatos a partir de um arquivo de texto.

## Estrutura do Projeto
O projeto está estruturado em quatro classes principais:

1. **Main.java**: Esta classe contém o método principal `main`, responsável por iniciar a aplicação e interagir com o usuário através de um menu de opções.

2. **Contato.java**: Representa um contato na agenda telefônica. Cada contato possui um ID único, nome, sobrenome e uma lista de números de telefone.

3. **Agenda.java**: Implementa a funcionalidade da agenda telefônica, incluindo operações como adicionar, remover, editar, exibir e salvar contatos. Além disso, esta classe também é responsável por carregar os contatos de um arquivo e salvar os contatos em um arquivo.

4. **Telefone.java**: Representa um número de telefone, contendo um DDD e um número.

## Instruções de Uso

Para utilizar a aplicação, basta executar o método `main` na classe `Main.java`. Isso iniciará a aplicação e exibirá um menu com as opções disponíveis. O usuário pode então escolher uma das opções digitando o número correspondente e pressionando Enter.


### Execução
1. Clone o repositório para sua máquina local.
2. Abra o terminal e navegue até o diretório do projeto. (ou abra com sua IDE de preferência.)
3. Compile o código-fonte executando o seguinte comando:
    ```
    javac Main.java
    ```
4. Execute o arquivo compilado com o seguinte comando:
    ```
    java Main
    ```
5. Siga as instruções apresentadas no console para interagir com a aplicação.

## Screenshot

*Aplicação*

![Menu](screenshot/Screenshot1.png)


## Contribuição

Sinta-se à vontade para contribuir ou reportar problemas. Basta abrir uma *issue* ou enviar um *pull request*.

## Licença

Este projeto está licenciado sob a [MIT License] - veja o arquivo [LICENSE.md](LICENSE.md) para detalhes.
