<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="List Orders" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>

	<div class="container-fluid table-responsive">
		<div class="row-block">
			<div class="panel-block panel-success">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-th-list"></span> Orders
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Surname</th>
							<th>Passport Data</th>
							<th>Mark</th>
							<th>Model</th>
							<th>With driver</th>
							<th>Cost Car</th>
							<th>Cost Rent</th>
							<th>Rent Start</th>
							<th>Rent End</th>
							<th>Status</th>
							<th>Rented</th>
							<th>Rent Car End</th>
							<th colspan="3"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${listorders}">
							<tr>
								<td>${order.id}</td>
								<td>${order.user.name}</td>
								<td>${order.user.surname}</td>
								<td>${order.userOrder.passportData}</td>
								<td>${order.car.mark}</td>
								<td>${order.car.model}</td>
								<td>${order.userOrder.withDriver}</td>
								<td>${order.car.cost}</td>
								<td>${order.rentSum}</td>
								<td>${order.userOrder.rentStart}</td>
								<td>${order.userOrder.rentEnd}</td>
								<td>${order.userOrder.status}</td>
								<td>${order.car.rented}</td>
								<td>${order.rentCarEnd}</td>
								<c:choose>
									<c:when test="${order.userOrder.status.name == 'open'}">

										<td><a class="btn btn-success btn-sm"
											href="confirm_order?orderId=${order.id}&carId=${order.car.id}">Confirm</a></td>
										<td><a class="btn btn-danger btn-sm"
											href="cancel_order?orderId=${order.id}&carId=${order.car.id}">Cancel</a></td>
									</c:when>
									<c:otherwise>
										<td></td>
										<td></td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${order.userOrder.status.name == 'paid'}">
										<td><a class="btn btn-warning btn-sm"
											href="order_end?orderId=${order.id}&carId=${order.car.id}">Order
												End</a></td>
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
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