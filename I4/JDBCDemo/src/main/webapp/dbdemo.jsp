
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglibprefix ="form" uri="http://www.springframework.org/tags/form"%>
<%@ tagliburi ="http://www.springframework.org/tags" prefix="spring"%>

<html>
<body>

	<!--////////////////////////////////////////// -->
	<!- // Data Source

	<!--////////////////////////////////////////// -->

	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/customerdb" user="root"
		password="root" />

	<!--////////////////////////////////////////// -->
	<!- // Query

	<!--////////////////////////////////////////// -->

	<sql:query var="customers" dataSource="${db}">
	select *  from customers
</sql:query>


	<p>Row Count: ${customers.rowCount}</p>

	<p>Column Names:
	<ul>
		<c:forEach var="cn" items="${customers.columnNames}">
			<li>${cn}</li>
		</c:forEach>
	</ul>
	</p>

	<p>Names:
	<ul>
		<c:forEach var="c" items="${customers.rows}">
			<li>${c.forename}, ${c.surname}</li>
		</c:forEach>
	</ul>
	</p>

	<!--////////////////////////////////////////// -->
	<!- // Parameterized Query

	<!--////////////////////////////////////////// -->

	<sql:query var="customersParameterized" dataSource="${db}"
		sql="select *  from customers where id = ?">
		<sql:param>104</sql:param>
	</sql:query>

	<p>Parameterized Query:
	<ul>
		<c:forEach var="c" items="${customersParameterized.rows}">
			<li>${c.forename}, ${c.surname}</li>
		</c:forEach>
	</ul>
	</p>

	<!--////////////////////////////////////////// -->
	<!- // Update Statement

	<!--////////////////////////////////////////// -->

	<sql:update
		sql="insert into customers (forename, surname) values (?,?)" var="up"
		dataSource="${db}">
		<sql:param>hello</sql:param>
		<sql:param>world</sql:param>
	</sql:update>

	<!--////////////////////////////////////////// -->
	<!- // Transactions

	<!--////////////////////////////////////////// -->

	<sql:transaction dataSource="${db}" isolation="read_uncommitted">

		<sql:update
			sql="insert into customers (forename, surname) values (?,?)" var="up">
			<sql:param>transaction</sql:param>
			<sql:param>test</sql:param>
		</sql:update>

	</sql:transaction>

</body>
</html>
