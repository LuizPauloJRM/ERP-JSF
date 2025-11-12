# ERP-JSF
Cadastro de empresas Exclusão de empresas Pesquisa de empresas Edição de informações de empresas Exportação dos dados da tabela para um arquivo .xls
ERP-JSF

ERP-JSF é um sistema corporativo de gestão empresarial desenvolvido com JavaServer Faces (JSF), PrimeFaces, Hibernate e MySQL.
O objetivo do projeto é oferecer uma base sólida para aplicações empresariais modulares, permitindo o gerenciamento de empresas, ramos de atividade e demais entidades administrativas.

Visão Geral

O sistema ERP-JSF foi desenvolvido com foco em arquitetura limpa, persistência com JPA/Hibernate e interface moderna baseada em PrimeFaces.
A aplicação permite o cadastro, edição, exclusão e listagem de empresas, bem como o gerenciamento dos ramos de atividade, com integração direta ao banco de dados relacional MySQL.

Funcionalidades Principais

Cadastro de empresas com informações completas.

Associação de empresas aos ramos de atividade.

Edição e exclusão de registros existentes.

Pesquisa dinâmica de empresas.

Exportação dos dados em formato .xls.

População inicial de dados automatizada via script SQL.

Tecnologias Utilizadas
Camada	Tecnologia
Frontend	JSF 2.2 e PrimeFaces 6.0
Backend	Java 8, Hibernate ORM 5.6
Banco de Dados	MySQL 8
Servidor	Apache Tomcat 8.5
Build e Dependências	Maven 3.6
Validação	Hibernate Validator
Estrutura do Projeto
ERP-JSF/
│
├── src/main/java/com/luiz/erp/
│   ├── controller/       # ManagedBeans (camada de controle)
│   ├── model/            # Entidades JPA (classes @Entity)
│   ├── repository/       # DAO e consultas com EntityManager
│   └── util/             # Configurações e utilitários (JPA, CDI)
│
├── src/main/resources/META-INF/
│   ├── persistence.xml   # Configuração da unidade de persistência (luiz)
│   └── sql/
│       └── dados-iniciais.sql  # Script de carga inicial de dados
│
├── src/main/webapp/
│   ├── WEB-INF/          # Configurações do JSF (faces-config, beans.xml)
│   ├── resources/        # CSS, JS e templates
│   └── pages/            # Arquivos .xhtml (cadastro, listagem, etc.)
│
└── pom.xml               # Configuração Maven do projeto

 Configuração e Execução
1. Pré-requisitos

JDK 8+

Apache Maven 3.6+

Apache Tomcat 8.5

MySQL 8 ou superior

2. Configurar o Banco de Dados

Crie o banco de dados:

CREATE DATABASE erp_jsf CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


Atualize, se necessário, as credenciais no arquivo:

src/main/resources/META-INF/persistence.xml


Exemplo:

<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/erp_jsf?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC" />
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="sua_senha" />


O Hibernate criará as tabelas automaticamente e executará o script dados-iniciais.sql na inicialização.

3. Compilar e Executar

No terminal, dentro da pasta do projeto:

mvn clean install


Após a compilação, implante o arquivo .war gerado na pasta:

target/erp-jsf.war


no Apache Tomcat 8.5, e acesse:

[http://localhost:8080/curso-jsf-e-primefaces-essencial/](http://localhost:8080/curso-jsf-e-primefaces-essencial/GestaoEmpresas.xhtml)

Estrutura de Persistência

O arquivo persistence.xml define a unidade de persistência luiz, que utiliza o provedor Hibernate para manipular entidades JPA.

Exemplo de configuração:

<persistence-unit name="luiz">
    <properties>
        <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/erp_jsf?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"/>
        <property name="javax.persistence.jdbc.user" value="root"/>
        <property name="javax.persistence.jdbc.password" value=""/>

        <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
        <property name="hibernate.hbm2ddl.auto" value="update"/>
        <property name="hibernate.show_sql" value="true"/>
        <property name="hibernate.format_sql" value="true"/>
    </properties>
</persistence-unit>

Luiz Paulo Medeiros da Cunha Júnior
Desenvolvedor Full-Stack Java | Especialista em JSF, PrimeFaces e Hibernate

 Licença

Este projeto é de uso livre para fins educacionais e corporativos.
Você pode clonar, modificar e distribuir sob sua própria responsabilidade, mantendo os créditos originais do autor.

Tela de Cadastro de Empresas

Tela de Listagem de Ramos de Atividade

Página Inicial

Interface Responsiva com PrimeFaces

(Aqui você colocará as imagens no seu repositório GitHub, dentro de uma pasta /screenshots/, e o README as exibirá assim:)

## 📸 Demonstração do Sistema

### Tela de Cadastro de Empresas
![Cadastro de Empresa]
<img width="1323" height="610" alt="Captura de tela 2025-11-12 010732" src="https://github.com/user-attachments/assets/d6cfb9e4-d416-4e13-a264-24b3c787053f" />



### Página Inicial
![Página Inicial]
<img width="1322" height="608" alt="Captura de tela 2025-11-12 010708" src="https://github.com/user-attachments/assets/87280d54-0f3d-4e2e-9e01-a39c5faa7f87" />
