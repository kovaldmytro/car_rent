<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="List Cars" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>

	<div class="container-fluid table-responsive">
		<div class="row-block">
			<div class="panel-block panel-success">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-cog"></span> <label>Cars </label>
					<label>
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">Selection by the class</button>
							<ul class="dropdown-menu">
								<li><a href="cars_selection?carClass=econom">econom</a></li>
								<li><a href="cars_selection?carClass=middle">middle</a></li>
								<li><a href="cars_selection?carClass=business">business</a></li>
							</ul>
					</label>
				</div>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Mark</th>
						<th>Model</th>
						<th>Class</th>
						<th>Cost</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="car" items="${carsSelection}">
						<tr>
							<td>${car.id}</td>
							<td>${car.mark}</td>
							<td>${car.model}</td>
							<td>${car.carClass}</td>
							<td>${car.cost}
							<td><a class="btn btn-success btn-lg"
								href="registration_order?car_id=${car.id}&client_id=${user.id}">Rent
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>