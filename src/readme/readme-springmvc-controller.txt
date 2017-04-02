SPRING MVC 3

Pra usar o @Controller, é necessário fazer a configuração abaixo:

1º Passo:

--No pom Pai.

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>org.oxi</groupId>
	<artifactId>spring-request-mapping-3.2.13.RELEASE-all</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>pom</packaging>
	<modules>
		<module>oxi-spring-request-mapping</module>
	</modules>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<spring.version>3.2.13.RELEASE</spring.version>
		<jdk.version>1.8</jdk.version>
		<slf4j.version>1.7.1</slf4j.version>
	</properties>

	<repositories>

		<!-- MAVEN REPOSITORY -->
		<repository>
			<id>mvn-repository</id>
			<url>http://mvnrepository.com/</url>
		</repository>

		<!-- MAVEN SEARCH REPOSITORY -->
		<repository>
			<id>mavensearch</id>
			<url>http://www.mvnsearch.org/maven2</url>
		</repository>


		<!-- REPO2 REPOSITORY -->
		<repository>
			<id>repo2</id>
			<url>http://repo2.maven.org/maven2</url>
		</repository>
	</repositories>

	<pluginRepositories>
		<!-- MAVEN PLUGIN REPOSITORY -->
		<pluginRepository>
			<id>repo1.maven</id>
			<name>Maven Repository</name>
			<url>http://repo1.maven.org/maven2</url>
		</pluginRepository>
	</pluginRepositories>

	<dependencies>
		<!-- JUNIT -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
		</dependency>
	</dependencies>



	<dependencyManagement>
		<dependencies>


			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-webmvc</artifactId>
				<version>${spring.version}</version>
			</dependency>


			<dependency>
				<groupId>javax.servlet.jsp.jstl</groupId>
				<artifactId>jstl-api</artifactId>
				<version>1.2</version>
			</dependency>
		</dependencies>
	</dependencyManagement>



	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.3</version>
				<configuration>
					<source>${jdk.version}</source>
					<target>${jdk.version}</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
	
	
	
	
	
2º - Passo 

-- NO modulo WAR


<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.oxi</groupId>
		<artifactId>spring-request-mapping-3.2.13.RELEASE-all</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</parent>
	<artifactId>oxi-spring-request-mapping</artifactId>
	<packaging>war</packaging>
	
	<properties>
	<jdk.version>1.8</jdk.version>
	</properties>

	<dependencies>		
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
		</dependency>
		
		<dependency>
			<groupId>javax.servlet.jsp.jstl</groupId>
			<artifactId>jstl-api</artifactId>
		</dependency>

	</dependencies>

	<build>
	    
		<finalName>${project.name}-${project.version}</finalName>
		<plugins>
		
		<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.3</version>
				<configuration>
					<source>${jdk.version}</source>
					<target>${jdk.version}</target>
				</configuration>
			</plugin>						

			<plugin>
				<groupId>org.eclipse.jetty</groupId>
				<artifactId>jetty-maven-plugin</artifactId>
				<version>9.2.11.v20150529</version>
				<configuration>
					<scanIntervalSeconds>10</scanIntervalSeconds>
					<!-- Para mudar a porta do servidor -->
					<httpConnector>
						<port>8085</port>
					</httpConnector>
					<webApp>
						<contextPath>/spring3</contextPath>
					</webApp>
				</configuration>
			</plugin>
			
			<!-- configure Eclipse workspace --> 
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-eclipse-plugin</artifactId>
			<version>2.9</version>
			<configuration>
				<downloadSources>true</downloadSources>
				<downloadJavadocs>true</downloadJavadocs>
				<wtpversion>2.0</wtpversion>
				<wtpContextName>spring3</wtpContextName>
			</configuration>
		</plugin>
		</plugins>
	</build>
</project>

4º Passo 


--No web.xml


<web-app xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
	version="2.5">
	
	<display-name>Spring3 MVC Application</display-name>

	<servlet>
		<servlet-name>spring-web</servlet-name>
		<servlet-class>
                    org.springframework.web.servlet.DispatcherServlet
                </servlet-class>
		<load-on-startup>1</load-on-startup>		
	</servlet>

	<servlet-mapping>
		<servlet-name>spring-web</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>

</web-app>

5º Passo

--Na Servlet


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans     
        http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
        http://www.springframework.org/schema/mvc 
        http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context-3.2.xsd">

	<context:component-scan base-package="org.oxi" />

	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix">
			<value>/WEB-INF/views/jsp/</value>
		</property>
		<property name="suffix">
			<value>.jsp</value>
		</property>
	</bean>

	<mvc:resources mapping="/resources/**" location="/resources/" />
 
	<mvc:annotation-driven />
	
</beans>

6º Passo

--JSP


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>
 
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
 
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Spring 3 MVC Project</a>
	</div>
  </div>
</nav>
 
<div class="jumbotron">
  <div class="container">
	<h1>${title}</h1>
	<p>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>
		
		<c:if test="${not empty showRest}">
			Hello ${showRest}
		</c:if>
 
		<c:if test="${empty name}">
			Welcome  ${message}
		</c:if>
    </p>
    <p>
	<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
    </p>
  </div>
</div>
 
<div class="container">
 
  <div class="row">
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
		<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
		<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
		<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
  </div>
 
  <hr>
  <footer>
	<p>© Mkyong.com 2015</p>
  </footer>
</div>
 
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>


7º Passo

-- Controller


package org.oxi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}
	
	@RequestMapping(value = "/rest/{showRest}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showRest(@PathVariable("showRest") String showRest){		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("showRest", showRest);
		
		return modelAndView;
	}
}











	