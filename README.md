Resumo completo do nosso projeto:

Objetivo:
Sistema de Informações da Pandemia.

Views básicas funcionando.

Futuro: Implementar Controllers/DAOs reais + banco MySQL + JPA/Hibernate.

Status atual:

Views Swing: CadastroBairroView, CadastroMoradorView, CadastroCasoView.

Models: Bairro, Morador, Caso (POJOs simples).

Controllers: BairroController, MoradorController, CasoController (vazios por enquanto) só retornam true.

DAOs: BairroDAO, MoradorDAO, CasoDAO - Singleton pattern (vazios por enquanto).

Estrutura MVC: Completa (Views → Controllers → DAOs).

Git: Repositório "sistema-pandemia" no GitHub.

Como executar:

javac -d target -cp src src/main/java/com/pandemia/.java src/main/java/com/pandemia/model/.java src/main/java/com/pandemia/controller/.java src/main/java/com/pandemia/dao/.java src/main/java/com/pandemia/view/*.java

java -cp target com.pandemia.Main

Próximos passos:
Implementar DAOs reais com JPA/Hibernate;
Conectar banco MySQL;
Adicionar validações;
Testes;