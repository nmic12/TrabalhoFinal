🎥⚙️ Sistema de Locação de Equipamentos 🎥⚙️
Este repositório contém o código-fonte do sistema de locação de equipamentos, desenvolvido como parte da disciplina Fundamentos de Programação na  PUCRS(Pontifícia Universidade Católica do Rio Grande do Sul). O sistema permite cadastrar clientes e equipamentos, gerenciar aluguéis e exibir relatórios sobre os itens mais alugados.

📂 Estrutura do Projeto

Cliente.java — A classe Cliente representa os clientes cadastrados no sistema de locação. Ela mantém os dados principais de cada cliente e fornece métodos para acessar e manipular essas informações.

Equipamento.java — A classe Equipamento representa os equipamentos que podem ser cadastrados e alugados no sistema. Ela armazena as principais informações sobre cada item e fornece métodos para acessar e manipular esses dados.

CadastroCliente.java — Gerencia o cadastro de clientes (inclusão, listagem e busca).

CadastroEquipamento.java — Gerencia o cadastro de equipamentos (inclusão, listagem e busca).

Aluguel.java — Realiza os aluguéis, controlando prazos e disponibilidade.

Inovacao.java — Implementa a funcionalidade inovadora que calcula e exibe qual foi o equipamento mais alugado.

✨ Funcionalidade Inovadora (Item 10)
A classe Inovacao.java agrega valor ao sistema ao identificar automaticamente o equipamento mais alugado até o momento. Com essa funcionalidade, conseguimos:

Gerar relatórios simples que ajudam o negócio a tomar decisões (como investir em novos modelos).

Dar visibilidade ao que está em alta entre os clientes.

🧑‍💻 Autores e Divisão de Tarefas

Nícolas Michels -> Modelagem das classes base e a classe Inovacao.java.

Leonardo Dornelles -> Implementação dos cadastros e da classe Aluguel.

🎥 Pitch do Sistema
Assista ao pitch em vídeo que explica a arquitetura, a divisão das tarefas e o valor da funcionalidade inovadora aqui:
Link para o vídeo pitch (https://www.youtube.com/watch?v=Bqf4zeH1T94)