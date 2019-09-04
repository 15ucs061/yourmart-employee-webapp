<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script>
<script type="text/javascript" src="/js/index.js"></script>
</head>


<body>


	<input type="text" id="myInput" onkeyup="search()"
		placeholder="Search for sellers..">

	<table class="table table-bordered table-dark" >
		<thead>
			<tr>
				<th scope="col"><button type="button" onclick="sortTable(0)">Sr
						No.</button></th>
				<th scope="col"><button type="button" onclick="sortTable(1)">Seller
						Id</button></th>
				<th scope="col"><button type="button" onclick="sortTable(2)">Company
						Name</button></th>
				<th scope="col"><button type="button" onclick="sortTable(3)">Owner
						Name</button></th>
				<th scope="col"><button type="button" onclick="sortTable(4)">Address</button></th>
				<th scope="col"><button type="button" onclick="sortTable(5)">Email</button></th>
				<th scope="col"><button type="button" onclick="sortTable(6)">Phone
						No.</button></th>
				<th scope="col"><button type="button" onclick="sortTable(7)">GST
						No.</button></th>
				<th scope="col"><button type="button" onclick="sortTable(8)">role</button></th>
				<th scope="col"><button type="button" onclick="sortTable(9)">status</button>
					<select id='filterText' style='display: inline-block'
					onchange='filterText()'>
						<option disabled selected>Select</option>
						<option value='APPROVED'>APPROVED</option>
						<option value='NEED_APPROVAL'>NEED_APPROVAL</option>
						<option value='all'>All</option>
				</select></th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody id="myTable">
			<c:forEach var="seller" items="${sellerList}" varStatus="counter">
				<tr class="content">
					<td><c:out value="${counter.count}"></c:out></td>
					<td><c:out value="${seller.userId}"></c:out></td>
					<td><c:out value="${seller.companyName}"></c:out></td>
					<td><c:out value="${seller.ownerName}"></c:out></td>
					<td><c:out value="${seller.address}"></c:out></td>
					<td><c:out value="${seller.email}"></c:out></td>
					<td><c:out value="${seller.phoneNo}"></c:out></td>
					<td><c:out value="${seller.GSTNo}"></c:out></td>
					<td><c:out value="${seller.roleName}"></c:out></td>
					<td><c:out value="${seller.status}"></c:out></td>
					<td>
						<form action="/viewSeller">
							<input type="hidden" name="seller"
								value="<c:out value="${seller}"/>" /> <input type="submit"
								value="View" />
						</form> <br>
						<form action="/status" method="POST">
							Status: <select name="changedStatus">
								<option value="APPROVED">APPROVED</option>
								<option value="REJECTED">REJECTED</option>
							</select> <input type="hidden" name="sellerId"
								value="<c:out value="${seller.userId}"/>" />a <br> <input
								type="submit" value="Change"> <input type="reset"
								value="Reset">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="/product" method="get">
		<input type="submit" value="Product">
	</form>



</body>
</html>