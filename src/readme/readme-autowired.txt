SPRING 3

Pra usar o @Autowired, é necessário fazer a configuração abaixo:

1º Passo:

Criar um arquivo de Context, no diretório resources do módulo responsável pelo retorno do serviço.

Inserir as configs abaixo:

Exemplo de nome: ctx-oxi-spring-resteasy-consumes-service.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.1.xsd">   
       
<!-- Abaixo deve inserir o pacote que será scaneado pelo spring-->
    <context:component-scan base-package="org.oxi" />

</beans>

2º - Passo:


Inserir @Service na classe que está provendo o serviço. MVN

	               <dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-web</artifactId>
				<version>${spring.version}</version>
			</dependency>

3º  - Passo

No arquivo web.xml do módulo do tipo WAR, inserir a config abaixo.

<!-- LOADER OF SPRING CONTEXT -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>
			classpath:ctx-oxi-spring-resteasy-consumes-service.xml
		</param-value>
	</context-param>
