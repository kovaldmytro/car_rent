<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="List Users Count" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>

	<div class="container-fluid table-responsive">
		<div class="row-block">
			<div class="panel-block panel-success">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-th-list"></span> Car Profit
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Surname</th>
							<th>Orders</th>
							<th>Profit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${listUsersCount}">
							<tr>
								<td>${order.user.id}</td>
								<td>${order.user.name}</td>
								<td>${order.user.surname}</td>
								<td>${order.count}</td>
								<td>${order.userProfit}</td>
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