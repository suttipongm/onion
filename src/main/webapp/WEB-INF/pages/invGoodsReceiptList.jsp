<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="invGoodsReceiptList.title" /></title>
<meta name="menu" content="InvMenu" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/datepicker/css/bootstrap-datetimepicker.min.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/datepicker/js/bootstrap-datetimepicker.min.js'/>"></script>

</head>

<c:if test="${not empty searchError}">
	<div class="alert alert-error fade in">
		<a href="#" data-dismiss="alert" class="close">&times;</a>
		<c:out value="${searchError}" />
	</div>
</c:if>

<div class="span12">
	<h2>
		<fmt:message key="invGoodsReceiptList.heading" />
	</h2>

	<form method="get" action="${ctx}/invGoodsReceiptList" id="searchForm" class="well form-horizontal">
		<div class="control-group">
			<label for="invGoodsReceipt.supplier.code" class="control-label"><fmt:message key="invGoodsReceipt.supplier.code" /></label>
			<div class="controls">
				<select id=invGoodsReceipt.supplier.code name="invGoodsReceipt.supplier.code">
					<option value=""></option>
					<c:forEach items="${supplierList}" var="supplier">
						<option value="${supplier.code}" ${(supplier.code == param['invGoodsReceipt.supplier.code']) ? 'selected' : ''}>${supplier.code} : ${supplier.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="runningNo"><fmt:message key="invGoodsReceipt.runningNo" />:</label>
			<div class="controls">
				<input type="text" class="input-xlarge" name="runningNo" id="runningNo" value="${param.runningNo}" placeholder="" />
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label" for="receiptDateFrom"><fmt:message key="invGoodsReceipt.receiptDateFrom" />:</label>
			<div class="controls">
				<div class="input-append date" id="receiptDateFromDatepicker">
					<input type="text" class="input-medium" name="receiptDateFrom" value="<c:out value='${param.receiptDateFrom}'/>"><span class="add-on"><i class="icon-th"></i></span>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="receiptDateTo"><fmt:message key="invGoodsReceipt.receiptDateTo" />:</label>
			<div class="controls">
				<div class="input-append date" id="receiptDateToDatepicker">
					<input type="text" class="input-medium" name="receiptDateTo" value="<c:out value='${param.receiptDateTo}'/>"><span class="add-on"><i class="icon-th"></i></span>
				</div>
			</div>
		</div>
		
		<div class="control-group">
			<div class="controls">

				<button id="button.search" class="btn" type="submit">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</button>

				<button id="button.reset" class="btn" type="button" onclick="clearForm($('#searchForm'))">
					<i class="icon-remove"></i>
					<fmt:message key="button.reset" />
				</button>
			</div>
		</div>
	</form>
	<c:if test="${not empty invGoodsReceiptList }">
	<div class="control-group pull-right">
		<fmt:message key="label.showPagination" />
		&nbsp;
		<%=request.getAttribute("psSelect")%>
	</div>
	</c:if>	
	<div id="actions">
		<a class="btn btn-primary" href="<c:url value='/invGoodsReceipt?method=Add&from=list'/>"> <i class="icon-plus icon-white"></i> <fmt:message key="button.add" />
		</a>

		<a class="btn" href="<c:url value='/mainMenu'/>"> <i class="icon-ok"></i> <fmt:message key="button.done" /></a>
		
	</div>
	<display:table name="invGoodsReceiptList" cellspacing="0" cellpadding="0" requestURI="" id="invGoodsReceipt"  pagesize="${ps}" class="table table-condensed table-striped table-hover table-bordered" export="true" size="resultSize" partialList="true" sort="external">
		<display:column property="runningNo" url="/invGoodsReceipt?from=list" paramId="id" paramProperty="id" escapeXml="true" sortable="true" titleKey="invGoodsReceipt.runningNo" sortName="runningNo" />
		<display:column escapeXml="true" sortable="true" titleKey="invGoodsReceipt.receiptDate" sortName="receiptDate" defaultorder="descending">
			<fmt:formatDate value="${invGoodsReceipt.receiptDate}" pattern="dd/MM/yyyy HH:mm:ss" />
		</display:column>
		<display:column property="supplier.name" escapeXml="true" sortable="true" titleKey="invGoodsReceipt.supplier.name" sortName="supplier.name" />
		<display:column property="totalCost" escapeXml="true" sortable="true" titleKey="invGoodsReceipt.totalCost" sortName="totalCost" />
		<display:setProperty name="export.csv" value="true"></display:setProperty>
		<display:setProperty name="export.excel" value="true"></display:setProperty>
		<display:setProperty name="export.xml" value="false"></display:setProperty>
		<display:setProperty name="export.pdf" value="true"></display:setProperty>
		<display:setProperty name="export.excel.filename" value="InvGoodsReceipt.xls" />
		<display:setProperty name="export.csv.filename" value="InvGoodsReceipt.csv" />
		<display:setProperty name="export.pdf.filename" value="InvGoodsReceipt.pdf" />
	</display:table>
	
</div>

<script type="text/javascript">
	$(function() {

		var st = $('#receiptDateFromDatepicker').datetimepicker({
			format : "dd/MM/yyyy hh:mm:ss"
		});
		var ed = $('#receiptDateToDatepicker').datetimepicker({
			format : "dd/MM/yyyy hh:mm:ss"
		});
		st.on('show', function(e) {
			var stObj = st.data('datetimepicker');
			var edObj = ed.data('datetimepicker');
			if ($('input[name="receiptDateTo"]').val() != '') {
				stObj.setEndDate(edObj.getDate());
			} else {
				stObj.setEndDate(null);
			}
		});
		st.on('changeDate', function(e) {
			var edObj = ed.data('datetimepicker');
			if (null != edObj.getDate()) {
				if (null != e.date
						&& e.date.valueOf() > edObj.getDate().valueOf()) {
					edObj.setDate(null);
				}
			}
		});
		ed.on('show', function(e) {
			var stObj = st.data('datetimepicker');
			var edObj = ed.data('datetimepicker');
			if ($('input[name="receiptDateFrom"]').val() != '') {
				edObj.setStartDate(stObj.getDate());
			} else {
				edObj.setStartDate(null);
			}
		});
		ed.on('changeDate', function(e) {
			var stObj = st.data('datetimepicker');
			if (null != stObj.getDate()) {
				if (null != e.date
						&& e.date.valueOf() < stObj.getDate().valueOf()) {
					stObj.setDate(null);
				}
			}
		});
	});
</script>

