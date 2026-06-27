<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<body>

<h4>
Enter dog name
</h4>

<br>
<br>
<form:form action = "dog-show-page" modelAttribute="dog">
        name <form:input path = "name"/>
        <br>
        color <form:input path = "color"/>
        <br>
        age <form:input path = "age"/>
        <br>
        <input type = "submit" value = "OK">
        </form:form>
        <br>

        </body>

        </html>