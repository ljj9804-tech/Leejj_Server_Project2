<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
Oracle Java Technologies | Oracle
Overview Technical Details . Newest Downloads Java SE 25 (LTS) Java SE 21 (LTS) Java SE 17 (LTS) Java SE 11(LTS) Java SE 8 Java Card . All Oracle Java Downloads Download now .
www.oracle.com
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach var="dto" items="${dtoList}">
        <li>
                ${dto}
        </li>
    </c:forEach>
</ul>


</body>
</html>