<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<title>Student Registration form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student"> 
	
		First name: <form:input path="firstName"/>
	
		<br><br>
	
		Last name: <form:input path="lastName"/>
	
		<br><br>
		
		Country:
		
		<form:select path="country">
		
			<form:options items="${student.countryOptions}" />
		
		</form:select>
		
		<br><br>
		
		Favourite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		
		CRUBY <form:radiobutton path="favoriteLanguage" value="RUBY" />
		
		<br><br>
		
		Operating Systems:
		
		Windows <form:checkbox path="operatingSystems" value="Wind"/>
		
		Linux <form:checkbox path="operatingSystems" value="Lin"/>
		
		MacOS <form:checkbox path="operatingSystems" value="Mac"/>
		
		
		
		
		
		<br><br>
	
		<input type="submit" value="Submit" /> 
	
	</form:form>

</body>

</html>
