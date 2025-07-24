# Trabalho Prático 02

- Peso: 15
- Número de integrantes: até 4 alunos
- Data de Entrega: 20/05/2024

##  Sistema de Gerenciamento de Biblioteca

Sua equipe foi contratada para implementar um sistema de gerenciamento para a biblioteca pública do bairro. 
Esse sistema deverá ser implementado como uma aplicação Java, e deverá incluir as seguintes funcionalidades:

### Cadastro de Usuários

O sistema deverá realizar o cadastro de novos usuários na biblioteca.
Todo usuário deverá ser aluno, professor, ou morador.

### Cadastro de Livro

O sistema deverá realizar o cadastro de novos livros na biblioteca.

### Empréstimo de Livro

O sistema deverá permitir que qualquer usuário realize o empréstimo de um livro.
No ato do empréstimo, o livro que estava na biblioteca deve ser enviado para o usuário que solicitou o empréstimo.
Este livro ficará com o usuário até que ele resolva devolver o livro para a biblioteca.
Além disso, há um limite com relação a quantidade de livros que um usuário poderá pegar emprestado simultâneamente:
- Morador: 2 livros
- Aluno: 5 livros
- Professor: 10 livros

O sistema deverá exibir uma mensagem de erro caso um usuário tente alugar mais livros do que ele poderia.

### Devolução de Livro

O sistema deverá permitir que o usuário realize a devolução de um livro que ele pegou emprestado na biblioteca.
No ato da devolução, o livro que estava com o usuário deverá retornar para a biblioteca.

### Exibir Livros Disponíveis

O sistema deverá exibir todos os livros disponíveis para empréstimo na biblioteca.

### Exibir Livros Emprestados de Algum Usuário

O sistema deverá exibir, para um dado usuário, os livros que ele possui alugado no momento.

## Classes

Abaixo você encontrará informações sobre a estrutura geral que as classes deverão ter no sistema.
**Considere essa descrição como um ponto de partida. Você pode adicionar atributos e métodos que julgar necessários.**

### Livro

- título: String
- autor: String
- ano de Publicação: int
- editora: String

- void imprimir(): Imprime os dados do livro

### Professor, Aluno, e Morador

- nome: String
- cpf: String
- data nascimento: Date
- id: int
- escola (exclusivo do aluno): String
- formação (exclusivo professor): String
- livrosAlugados(2 para morador, 5 para aluno, 10 para professor): Livro[]

- boolean devolverLivro(Livro): deverá fazer a devolução de um livro
- boolean pegarLivro(Livro): deverá pegar um livro para empréstimo 
- void imprimirLivros(): deverá imprimir todos os livros que estão em empréstimo pelo usuário

### Biblioteca

- livros: Livro[]
- usuarios: Usuario[]
- nome: String

- static void main(String[]): método por onde iniciará a execução do programa
- void cadastrarLivro(): deverá cadastrar um novo livro na biblioteca
- void cadastrarUsuario(): deverá cadastrar um novo usuário na biblioteca
- void realizarEmprestimo(): deverá inicializar o processo de empréstimo
- void realizarDevolucao(): deverá iniciar o processo de devolução
- void imprimirLivros(): deverá imprimir todos os livros disponíveis na biblioteca

## Avaliação

O trabalho será avaliado com base na aplicação dos conceitos:
- Funcionalidades implementadas
- Classes, objetos, atributos e métodos
- Mecanismos de herança
