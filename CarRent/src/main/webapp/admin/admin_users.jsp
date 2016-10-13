<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="Admin Users" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>

	<div class="container-fluid table-responsive">
		<div class="row-block">
			<div class="panel-block panel-success">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-user"></span> <label>Users</label>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Email</th>
							<th>Name</th>
							<th>Surname</th>
							<th>Blocked</th>
							<th>Role</th>
							<th>Block user</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${allusers}">
							<tr>
								<td>${user.id}</td>
								<td>${user.email}</td>
								<td>${user.name}</td>
								<td>${user.surname}</td>
								<td>${user.blocked}</td>
								<td>${user.role}</td>
								<c:choose>
									<c:when
										test="${user.role.name != 'admin' and user.blocked eq false}">
										<td><a class="btn btn-danger"
											href="block_user?userId=${user.id}">Block</a></td>
									</c:when>
									<c:when
										test="${user.role.name != 'admin' and user.blocked eq true}">
										<td><a class="btn btn-danger"
											href="block_user?userId=${user.id}">Unblock</a></td>
									</c:when>
									<c:otherwise>
										<td><a class="btn btn-danger disabled" href="#">Block</a></td>
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