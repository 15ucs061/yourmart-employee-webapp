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
		placeholder="Search for products..">

	<table class="table table-bordered table-dark">
		<thead>
			<tr>
				<th scope="col">SrNo.</th>
				<th scope="col"><button type="button" onclick="sortTable(1)">Product
						Code</button></th>
				<th scope="col"><button type="button" onclick="sortTable(2)">Image</button></th>
				<th scope="col"><button type="button" onclick="sortTable(3)">Name</button></th>
				<th scope="col"><button type="button" onclick="sortTable(4)">Description</button></th>
				<th scope="col"><button type="button" onclick="sortTable(5)">Category</button></th>
				<th scope="col"><button type="button" onclick="sortTable(6)">MRP</button></th>
				<th scope="col"><button type="button" onclick="sortTable(7)">SSP</button></th>
				<th scope="col"><button type="button" onclick="sortTable(8)">YMP</button></th>
				<th scope="col"><button type="button" onclick="sortTable(9)">status</button>
					<select id='filterText' style='display: inline-block'
					onchange='filterText()'>
						<option disabled selected>Select</option>
						<option value='APPROVED'>APPROVED</option>
						<option value='NEW'>NEW</option>
						<option value='REVIEW'>REVIEW</option>
						<option value='REJECTED'>REJECTED</option>
						<option value='all'>All</option>
				</select></th>
				<th scope="col"><button type="button" onclick="sortTable(10)">Seller
						Id</button></th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody id="myTable">
			<c:forEach var="product" items="${productList}" varStatus="counter">
				<tr class="content">
					<td><c:out value="${counter.count}"></c:out></td>
					<td><c:out value="${product.code}"></c:out></td>
					<td><iframe width="100px" height="100px" scrolling="no"
							src="<c:out value='${product.primaryImagePath}'></c:out>"></iframe></td>
					<td><c:out value="${product.name}"></c:out></td>
					<td><c:out value="${product.description}"></c:out></td>
					<td><c:out value="${product.categories}"></c:out></td>
					<td><c:out value="${product.mrp}"></c:out></td>
					<td><c:out value="${product.ssp}"></c:out></td>
					<td><c:out value="${product.ymp}"></c:out></td>
					<td><c:out value="${product.status}"></c:out></td>
					<td><c:out value="${product.sellerId}"></c:out></td>
					<td>
						<form action="/viewProduct">
							<input type="hidden" name="productCode"
								value="<c:out value="${product.code}"/>" /> <input
								type="submit" value="View" />
						</form>
						<form action="/productStatus" method="POST">
							Status: <select name="changedStatus">
								<option value="APPROVED">APPROVED</option>
								<option value="REJECTED">REJECTED</option>
							</select> <input type="hidden" name="productCode"
								value="<c:out value="${product.code}"/>" /> <br> <input
								type="submit" value="Change"> <input type="reset"
								value="Reset">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>