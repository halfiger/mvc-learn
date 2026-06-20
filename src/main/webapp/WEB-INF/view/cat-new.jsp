<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<HTML>

<BODY>

<form:form action= "catShow" modelAttribute = "cat">

Name <form:input path="name"/>
<br>

Color <form:input path="color"/>
<br>

Weight <form:input path="weight"/>
<br>

<input type="submit" value = "Ok">

</form:form>

</BODY>

</HTML>