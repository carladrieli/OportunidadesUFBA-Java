# Oportunidades UFBA

#### Documentação para ambiente de desenvolvimento

* 1 - Criar projeto dinâmico no eclipse para configuração com JSF

* 2 - Botão direito do projeto -> Team -> Share Project -> Git -> Marque a opção “Use or create repository in parent folder of project” -> Selecione o seu projeto -> E clique ”Create Repository” -> Finish


* 3 - Feito isso, precisamos editar o arquivo “.gitignore” ficando dessa forma:

 ```
/build/
.gitignore
*.class
*.DS_Store
*.classpath
*.project
.metadata*
.settings*
```
* 4 - Agora, botão direito do projeto -> Team -> Commit -> Marque todos os arquivos e escreva uma mensagem pro commit por exemplo “first commit by MyName"

* 5 - E clique em commit and push -> Em URI: cole a url do repositório https://github.com/carlafagundes/oportunidades-ufba.git -> Next -> Finish -> Ok 

* > 5.1 - (Obs) -> O commit será rejeitado mesmo, é a penas para configurar o remote.

* 6 - Botão direito do projeto -> Team -> Pull -> OK

* 7 - Agora, botão direito do projeto -> Team -> Reset -> Clique em Remote Tracking -> E clique em origin/master -> E clique em Hard (HEAD, índex, and working directory updated) -> Reset -> Yes

* 8 - Pronto, repositório atualizado com a versão do remote.