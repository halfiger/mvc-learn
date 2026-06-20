mvn clean package
Copy-Item "D:\Mvc\mvc\target\mvc.war" "C:\java\apache-tomcat\apache-tomcat-9.0.118\webapps\mvc.war" -Force
cd C:\java\apache-tomcat\apache-tomcat-9.0.118\bin
.\catalina.bat run


Треба сформувати завдання для практики цих питань у переліку,
    створюємо покроках і я питаю якщо не виходить
    
    55. Introduction to Spring MVC
    56. Spring MVC Application Configuration (IntelliJ IDEA + NetBeans)
    57. First Spring MVC application
    58. Using data in View
    59. Model Component
    60. @RequestParam Annotation
    61. @RequestMapping annotation for Controller class
    62. Spring MVC input form
    63. Spring MVC select form
    64. Spring MVC radiobutton form
    65. Spring MVC checkbox form
    66. Data validation: @Size, @NotEmpty, @NotBlank
    67. Data Validation: @Min, @Max, @Pattern
    68. Data Validation: Creating Your Own Annotation
    
    ----------------------------Employee.java------------------------
    package com.tommy.mvc;
    
    public class Employee {
    private String name;
    private String surname;
    private int salary;
    private String department;
    
        public Employee() {}
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getSurname() {
            return surname;
        }
    
        public void setSurname(String surname) {
            this.surname = surname;
        }
    
        public int getSalary() {
            return salary;
        }
    
        public void setSalary(int salary) {
            this.salary = salary;
        }
    
        public String getDepartment() {
            return department;
        }
    
        public void setDepartment(String department) {
            this.department = department;
        }
    
        @Override
        public String toString() {
            return "Employees{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }
    
    
    -----------------------MyController.java-----------------------
    
    package com.tommy.mvc;
    
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    
    import javax.servlet.http.HttpServletRequest;
    
    @Controller
    @RequestMapping ("/data")
    public class MyController {
    
        @RequestMapping("/")
        public String showFirstView () {
            return "first-view";
        }
    
        @RequestMapping("/askDetails")
        public String askDetails (Model model) {
            model.addAttribute("employee", new Employee());
            return "ask-details";
        }
    
        @RequestMapping("/showDetails")
        public String showDetails (@ModelAttribute("employee") Employee emp) {
            return "show-details";
        }
    
        //localhost:8080/mvc/
        //localhost:8080/mvc/askDetails
    }
    
    --------------------ask-detail.jsp---------------------------
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
    <html>
    
    <body>
    
    <h2> enter your name </h2>
    
    <br>
    <br>
    
    <form:form action="showDetails" modelAttribute="employee">
    Name <form:input path="name"/>
    <br>
    <br>
    Surname <form:input path="surname"/>
    <br>
    <br>
    Salary <form:input path="salary"/>
    <br>
    <br>
    
           <input type="submit" value ="OK">
    
    </form:form>
    
    </body>
    </html>
    
    
    --------------------------first-view.jsp-------------------------------
    
    
    <!DOCTYPE html>
    <html>
    
    <body>
    
    <h2> hello </h2>
    
    <br>
    <br>
    Your name: ${employee.name}
    <br>
    Your surname: ${employee.surname}
    <br>
    Your salary: ${employee.salary}
    <br>
    
    </body>
    
    </html>
    
    
    -----------------------show-details.jsp---------------------------------
    
    <!DOCTYPE html>
    <html>
    
    <body>
    
    <h2> hello </h2>
    
    <br>
    <br>
    Your name: ${employee.name}
    <br>
    Your surname: ${employee.surname}
    <br>
    Your salary: ${employee.salary}
    <br>
    
    </body>
    
    </html>
    
    --------------------------applicationContext.xml------------------------
    
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    
        <context:component-scan base-package="com.tommy.mvc" />
    
        <mvc:annotation-driven/>
    
        <bean
                class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/view/" />
            <property name="suffix" value=".jsp" />
        </bean>
    
    </beans>
    
    
    ------------------------web.xml----------------------------
    
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://xmlns.jcp.org/xml/ns/javaee"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
    http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
    id="WebApp_ID" version="3.1">
    
        <display-name>mvc</display-name>
    
        <absolute-ordering />
    
        <servlet>
            <servlet-name>dispatcher</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>/WEB-INF/applicationContext.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>
    
        <servlet-mapping>
            <servlet-name>dispatcher</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>
    
    </web-app>
    
    ---------------------------pom.xml----------------------------
    
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.spring</groupId>
    <artifactId>mvc</artifactId>
    <packaging>war</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>mvc Maven Webapp</name>
    <url>http://maven.apache.org</url>
    
      <dependencies>
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>3.8.1</version>
          <scope>test</scope>
        </dependency>
    
        <!-- Source: https://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>5.2.25.RELEASE</version>
          <scope>compile</scope>
        </dependency>
    
        <!-- Source: https://mvnrepository.com/artifact/org.springframework/spring-core -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-core</artifactId>
          <version>5.2.25.RELEASE</version>
          <scope>compile</scope>
        </dependency>
    
        <!-- Source: https://mvnrepository.com/artifact/org.springframework/spring-beans -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-beans</artifactId>
          <version>5.2.25.RELEASE</version>
          <scope>compile</scope>
        </dependency>
    
        <!-- Source: https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-webmvc</artifactId>
          <version>5.2.25.RELEASE</version>
          <scope>compile</scope>
        </dependency>
    
    
        <!-- Source: https://mvnrepository.com/artifact/javax.servlet/jstl -->
        <dependency>
          <groupId>javax.servlet</groupId>
          <artifactId>jstl</artifactId>
          <version>1.2</version>
          <scope>compile</scope>
        </dependency>
    
        <!-- Source: https://mvnrepository.com/artifact/javax.servlet/servlet-api -->
        <dependency>
          <groupId>javax.servlet</groupId>
          <artifactId>servlet-api</artifactId>
          <version>2.5</version>
          <scope>provided</scope>
        </dependency>
    
    
      </dependencies>
    
      <build>
        <finalName>mvc</finalName>
      </build>
    </project>
    
