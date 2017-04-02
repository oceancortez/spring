<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>This is the default page.</h2>
	<p>
		<a href="hello">Click here</a> PAGE NOT FOUND.
	</p>
	
	<div>
					<sf:label path="error">${error}</sf:label>
				</div>
</body>
</html>
