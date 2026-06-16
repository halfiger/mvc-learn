<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<body>

<form:form action="showCar" modelAttribute="car">

brand <form:input path="brand"/>
<br>
color <form:input path="color"/>
<br>
volume <form:input path="volume"/>
<br>

privid <form:select path="privid">
<form:option value="zadniy" label="zd"/>
<form:option value="peredniy" label="pd"/>
<form:option value="full" label="4x4"/>
</form:select>






<input type="submit" value ="OK">
</form:form>

</body>

</html>