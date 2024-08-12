<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="Relatorio de exames realizados" /></title>
<link rel='stylesheet'
	href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
<body class="bg-secondary">
	<div class="container">
		<div class="row mt-5">
				<div class="col-sm-5">
					<s:url action="todosExames" var="todos" />
					<a href="${todos}" class="btn btn-primary btn-lg">Exames</a>
				</div>
				
				<div class="col-sm-5">				
					<s:url action="todosExamesFuncionario" var="todosExamesFuncionario">
					</s:url>
					<a href="${todosExamesFuncionario}" class="btn btn-primary btn-lg"><s:text name="label.detalhes" /></a>
				</div>
				
				<div class="col-sm-2">
					<s:url action="listarRelatorios" var="relatorio" />
					<a href="${relatorio}" class="btn btn-primary btn-lg">Relatorio Exames</a>
				</div>
		</div>
		<div class="row mt-5 mb-2">
			<div class="col-sm p-0">
				<s:form action="filtrarRelatorios.action">
					<div class="input-group">
						<s:textfield cssClass="form-control" label="Data Inicial"
							name="dInicial" type="date" required="true" />
						<s:textfield cssClass="form-control" label="Data Final"
							name="dFinal" type="date" required="true" />
						<button class="btn btn-primary" type="submit">
							<s:text name="label.pesquisar" />
						</button>
					</div>
				</s:form>
			</div>
		</div>

		<div class="row">
			<table class="table table-light table-striped align-middle">
				<thead>
					<tr>
						<th>ID FUNCIONARIO</th>
						<th>NOME FUNCIONARIO
						<th>ID EXAME</th>
						<th>NOME EXAME</th>
						<th>DATA EXAME</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="examesFuncionarios">
						<tr>
							<td>${funcionarioVo.rowid}</td>
							<td>${funcionarioVo.nome}</td>
							<td>${exameVo.rowid}</td>
							<td>${exameVo.nome}</td>
							<td><fmt:formatDate value="${dataDoExame}" type="date"
									pattern="dd/MM/yyyy" /></td>
						</tr>
					</s:iterator>
				</tbody>

			</table>
		</div>

		<div class="row"></div>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>