<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="My Orders" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>
	<div class="container-fluid table-responsive">
		<div class="row-block">
			<div class="panel-block panel-success">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-th-list"></span> <label>My
						Orders</label>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Surname</th>
							<th>Mark</th>
							<th>Model</th>
							<th>Rent Start</th>
							<th>Rent End</th>
							<th>Cost Rent</th>
							<th>Status</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${listorder}">
							<tr>
								<td>${order.id}</td>
								<td>${order.user.name}</td>
								<td>${order.user.surname}</td>
								<td>${order.car.mark}</td>
								<td>${order.car.model}</td>
								<td>${order.userOrder.rentStart}</td>
								<td>${order.userOrder.rentEnd}</td>
								<td>${order.rentSum}</td>
								<td>${order.userOrder.status}</td>
								<c:choose>
									<c:when test="${order.userOrder.status.name == 'confirm'}">
										<td><a class="btn btn-info btn-sm active"
											href="pay?orderId=${order.id}">Pay</a></td>
									</c:when>
									<c:when test="${order.userOrder.status.name == 'close'}">
										<td></td>
									</c:when>
									<c:when test="${order.userOrder.status.name == 'cancel'}">
										<td></td>
									</c:when>
									<c:otherwise>
										<td><a class="btn btn-info btn-sm disabled"
											href="pay?orderId=${order.id}">Pay</a></td>
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