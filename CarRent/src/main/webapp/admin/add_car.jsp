<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<c:set var="title" value="Add Car" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/jspf/choose_menu.jspf"%>
	<%@ include file="/WEB-INF/jspf/banner.jspf"%>

	<form action="addcar" method="POST">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-success">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-align-justify"></span> Add Car
						</div>
						<div class="panel-body">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-3 control-label"> Mark</label>
									<div class="col-sm-9">
										<input type="text" name="mark" class="form-control"
											placeholder="mark" required>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label"> Model</label>
									<div class="col-sm-9">
										<input type="text" name="model" class="form-control"
											placeholder="model" required>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label"> Class</label>
									<div class="col-sm-9">
										<div class="form-group">
											<select class="form-control" name="class" required>
												<option value="econom">econom</option>
												<option value="middle">middle</option>
												<option value="business">business</option>
											</select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label"> Cost</label>
									<div class="col-sm-9">
										<input type="number" name="cost" class="form-control"
											placeholder="cost" min="0" max="200" required>
									</div>
								</div>
								<div class="form-group last">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-success btn-sm">
											Add Car</button>
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