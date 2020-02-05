<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

<title>Customer Registration Form</title>
<style>
   .error {
   	color:red;
   }
</style>
</head>
<body>

<form:form action="processForm" modelAttribute="customer" >

First Name : <form:input path="firstName" />

Last Name : <form:input path="lastName" />
			<form:errors path="lastName"  cssClass="error" />
freePasses : <form:input path="freePasses" />
			<form:errors path="freePasses"  cssClass="error" />
PostCode : <form:input path="postalcode" />
			<form:errors path="postalcode"  cssClass="error" />
course code : <form:input path="courseCode" />
			<form:errors path="courseCode"  cssClass="error" />
			
			<br/>
			<input type="submit" value="submit" />

</form:form>

</body>
</html>