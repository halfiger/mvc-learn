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
<form:option value = "99999" label = "no privid"/>
<form:options items="${privids}"/>
</form:select>

<br>
yrs<form:checkboxes path = "tos" items="${car.yearsOfTOList}"/>
<br>

country <form:radiobuttons path="country" items = "${countrys}"/>

<input type="submit" value ="OK">
</form:form>

</body>

</html>