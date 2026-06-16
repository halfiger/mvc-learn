<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<body>

<form:form action = "showCar" modelAttribute="car">
brand <form:input path="brand"/>
<br>
color <form:input path="color"/>
<br>
volume <form:input path="volume"/>
<br>

<input type="submit" value ="OK">

</form:form>

</body>

</html>