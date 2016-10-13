<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="Registration order" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>

	<form action="registration_order" method="POST">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-success">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-th-list"></span> Registration
							order
						</div>
						<div class="panel-body">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="car" class="col-sm-3 control-label">Car:</label> <label>${car.mark}
										${car.model}</label>
								</div>
								<div class="form-group">
									<label for="cost" class="col-sm-4 control-label">Cost(day):</label>
									<label>${car.cost}</label> <input type="hidden" name="car_id"
										value="${car.id}"> <input type="hidden"
										name="client_id" value="${user.id}">
								</div>
								<div class="form-group">
									<label class="col-sm-5 control-label"> Passport Data:</label>
									<div class="col-sm-6">
										<input type="text" maxlength="8" name="passport_data"
											class="form-control" placeholder="MT123456" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-9 control-label"> <input
										type="checkbox" name="with_driver" value="true"> With
										Driver
									</label>
								</div>
								<div class="form-group">
									<label class="col-sm-7 control-label"> Date:</label>
									<div class="col-sm-7">
										<input type="date" name="rent_start" class="form-control"
											placeholder="" required>
									</div>
									<div class="col-sm-7 col-offset-4">
										<input type="date" name="rent_end" class="form-control"
											placeholder="" required>
									</div>
								</div>
								<div class="form-group last">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-success btn-sm">
											Next</button>
										<button type="reset" class="btn btn-default btn-sm">
											Reset</button>
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