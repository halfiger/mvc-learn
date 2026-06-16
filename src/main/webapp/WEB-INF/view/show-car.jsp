<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>

<br>
Brand ${car.brand}
<br>
Color ${car.color}
<br>
Volume ${car.volume}
<br>
Privid ${car.privid}
<br>

Years of to <br>
<ul>
<c:forEach var="yr" items="${car.tos}">
<li>${yr}</li>
</c:forEach>
</ul>

<br>
Country ${car.country}
</body>

</html>