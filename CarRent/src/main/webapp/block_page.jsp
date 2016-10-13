<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="Login" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>
	<div class="alert alert-danger" role="alert">You blocked</div>
	<form action="login" method="POST">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-success">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-lock"></span> Login
						</div>
						<div class="panel-body">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label">
										Email</label>
									<div class="col-sm-9">
										<input type="email" name="email" class="form-control"
											id="inputEmail3" placeholder="Email" required>
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-3 control-label">
										Password</label>
									<div class="col-sm-9">
										<input type="password" name="password" class="form-control"
											id="inputPassword3" placeholder="Password" required>
									</div>
								</div>
								<div class="form-group last">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-success btn-sm">
											Sign in</button>
										<button type="reset" class="btn btn-default btn-sm">
											Reset</button>
									</div>
								</div>
							</form>
						</div>
						<div class="panel-footer">
							Not Registred? <a href="registration">Register here</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>