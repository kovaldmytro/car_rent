<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="Admin Cars" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>
	
	<div class="container-fluid table-responsive">
		<div class="row-block">
			<div class="panel-block panel-success">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-road"></span> <label>Cars</label>

				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Mark</th>
							<th>Model</th>
							<th>Class</th>
							<th>Cost</th>
							<th>Rented</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="car" items="${allcars}">
							<tr>
								<td>${car.id}</td>
								<td>${car.mark}</td>
								<td>${car.model}</td>
								<td>${car.carClass}</td>
								<td>${car.cost}</td>
								<td>${car.rented}</td>
								<td><a class="btn btn-warning"
									href="edit_car?carId=${car.id}">Edit</a> <a
									class="btn btn-danger" href="delete_car?carId=${car.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>