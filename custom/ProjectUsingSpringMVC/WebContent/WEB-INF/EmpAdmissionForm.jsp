<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
<a href="/ProjectUsingSpringMVC/greet/empAdmissionForm?siteLanguage=en">English</a>
<a href="/ProjectUsingSpringMVC/greet/empAdmissionForm?siteLanguage=fr">French</a>
	<h2>${headerMessage}</h2>
	<form action="/ProjectUsingSpringMVC/greet/empSubmitAdmissionForm" method="post">
	<p>
	<spring:message code="label.empName" /><input type="text" name="empName"/>
	</p>
	<p>
	<spring:message code="label.empHobby" /><input type="text" name="empHobby"/>
	</p>
	<p>
	<spring:message code="label.dateOfBirth" /><input type="text" name="dateOfBirth"/>
	</p>
	<p>
	<spring:message code="label.mobileNo" /><input type="text" name="mobileNo"/>
	</p>
	<p>
	<spring:message code="label.empSkills" /> <select name="empSkills" multiple>
						<option value="java core">java core</option>
						<option value="spring core">spring core</option>
						<option value="java mvc">spring mvc</option>
						</select>
	</p>
	<spring:message code="label.empAddress" />
	<p>
	<spring:message code="label.country" /> <input type="text" name="empAddress.country"/>
	</p>
	<p>
	<spring:message code="label.city" /> <input type="text" name="empAddress.city"/>
	</p>
	<p>
	<spring:message code="label.pincode" /> <input type="text" name="empAddress.pincode"/>
	</p>
	<spring:message code="label.submitAdmissionForm" var="labelSubmitAdmissionForm"/>
	<input type="submit" value=${labelSubmitAdmissionForm}/>
	</form>
	<form:errors path="employee1.*" />
 
</body>
</html>