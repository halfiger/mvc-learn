<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<body>

enter pig name

<form:form action = "show-pig" modelAttribute = "pig">

        name <form:input path = "name"/>
        <br>
        age <form:input path = "age"/>
        <br>
        weight <form:input path = "weight"/>
        <br>

        <input type = "submit" value = "OK">

</form:form>
        <br>

</body>

</html>