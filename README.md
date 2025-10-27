# PI2-Etapa_6-ThiagoMilk
Este relatório apresenta a refatoração do sistema desktop desenvolvido anteriormente, com o objetivo de preparar o código para reutilização em uma futura versão web. O foco principal foi separar a lógica de negócio da parte visual, aplicando princípios de projeto e boas práticas de programação orientada a objetos.

O principal princípio SOLID aplicado foi o da Responsabilidade Única (Single Responsibility Principle). Cada classe passou a ter apenas uma função específica, facilitando a manutenção e a compreensão do código. Exemplos: a classe UsuarioService ficou responsável pela lógica de usuários, a TransacaoService pelas transações, e as classes UsuarioDAO e TransacaoDAO pelo acesso ao banco de dados.

Durante a refatoração, as partes gráficas e eventos do Java Swing foram removidos, mantendo apenas a lógica central do sistema. O código foi reorganizado de forma que cada classe tivesse um método principal, eliminando code smells e acoplamentos desnecessários. Isso deixou o sistema mais limpo, modular e preparado para evoluções futuras.

O projeto segue o padrão MVC (Model-View-Controller) de forma simplificada:

Model: classes de entidade (Usuario, Transacao);

DAO: classes responsáveis pelo acesso aos dados;

Service: classes que contêm as regras de negócio;

View: removida nesta etapa, pois o foco agora é apenas o back-end.

Os testes foram realizados diretamente no método main(), validando as operações básicas como cadastro de usuários e gerenciamento de transações. O sistema se mostrou funcional após as refatorações.

O novo projeto foi criado e publicado em um repositório no GitHub, contendo todas as classes refatoradas e organizadas.
Link do repositório: (colocar aqui o link)

Com essa etapa concluída, o sistema está totalmente preparado para ser utilizado como base no desenvolvimento da versão web, atendendo aos princípios SOLID e garantindo uma estrutura de código mais organizada e reutilizável.
