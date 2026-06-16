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
        Department <form:select path="department">
        <form:option value="12345" label="IT"/>
        <form:options items="${departments}"/>
        </form:select>
        <br>


        <br>
        Email <form:input path="email"/>
        <br>
        Phone Number <form:input path="phoneNumber"/>
        <br>

       <input type="submit" value ="OK">

</form:form>

</body>
</html>