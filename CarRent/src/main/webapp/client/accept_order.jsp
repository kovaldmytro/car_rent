<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="Client Accept Order" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>

	<form action="accept_order" method="POST">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-md-offset-4">
					<div class="panel panel-success">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-th-list"></span> Accept Order
						</div>
						<div class="panel-body">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="car" class="col-sm-14 control-label">Car:
										${car.mark} ${car.model}</label>
								</div>
								<div class="form-group">
									<label class="col-sm-14 control-label">Passport Data:
										${userOrder.passportData}</label>
								</div>
								<div class="form-group">
									<label class="col-sm-16 control-label">With Driver:
										${userOrder.withDriver}</label>
								</div>
								<div class="form-group">
									<label class="col-sm-14 control-label">Rent Start:
										${userOrder.rentStart}</label>
								</div>
								<div class="form-group">
									<label class="col-sm-14 control-label">Rent End:
										${userOrder.rentEnd}</label>
								</div>
								<div class="panel-footer">
									<h3>Rent Price: ${sumRent}</h3>
								</div>
								<div class="form-group last">
									<div class="col-sm-offset-3 col-sm-9">
										<input type="submit" class="btn btn-success" value="Accept" />
										<a href="cars" class="btn btn-danger">Cancel</a>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>