# Sistema de gerencimanento de emprestimos utilizando Java e Spring Boot

Este projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos e implementa um sistema de gerenciamento de empréstimos de equipamentos para funcionários. A aplicação segue o modelo MVC (Model-View-Controller), proporcionando uma interface intuitiva e funcionalidades robustas para o controle de empréstimos, listagens, busca de funcionários e histórico de devoluções.
## Tecnologias utilizadas

- Java: Linguagem principal do projeto.
- Spring Boot: Framework para criação da aplicação, incluindo:
    - Spring Data JPA para persistência de dados.
    - Spring MVC para controle das rotas e organização em camadas.
- MySQL: Sistema de Gerenciamento de Banco de Dados para armazenamento de dados de funcionários e empréstimos.
- Thymeleaf: Motor de templates para renderizar as páginas HTML.
- HTML e CSS: Para estilização e estruturação das páginas.

## Funcionalidades

- Cadastro e edição de funcionários e equipamentos.
- Gerenciamento de empréstimos com controle de disponibilidade de equipamentos.
- Listagem de empréstimos por status e busca de funcionários por ID.
- Histórico de empréstimos devolvidos e contagem de empréstimos ativos.
- Filtragem de empréstimos com prazos "Regular" ou "Atrasado".

## Como Executar o Projeto

- Clone o repositório e abra o projeto em sua IDE preferida.
- Certifique-se de que o MySQL está configurado e acessível, com as credenciais ajustadas no application.properties.
- Execute a classe principal TrackbugApplication.java.
- Abra seu navegador e acesse o sistema em http://localhost:8082.
