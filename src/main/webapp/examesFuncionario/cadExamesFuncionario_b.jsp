<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="label.titulo.pagina.consulta" /></title>
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
					<s:url action="todosFuncionarios" var="todos" />
					<a href="${todos}" class="btn btn-primary btn-lg">Funcionarios</a>
				</div>
				
				<div class="col-sm-2">
					<s:url action="listarRelatorios" var="relatorio" />
					<a href="${relatorio}" class="btn btn-primary btn-lg">Relatorio Exames</a>
				</div>
		</div>
		
		<div class="row mt-3 mb-2">
			<div class="col-sm p-0">
				<s:form action="filtrarExamesFuncionario.action">
					<div class="input-group">
						<span class="input-group-text"> <strong><s:text
									name="label.buscar.por" /></strong>
						</span>
						<s:select cssClass="form-select" name="tipoFiltro" label="Tipo"
							list="#{'FuncionarioID':'ID do Funcionario', 'ExameID':'ID do Exame'}"
							headerKey="" headerValue="Escolha..." />
						<s:textfield cssClass="form-control" label="Valor"
							name="valorFiltro" />
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
						<th><s:text name="label.idexame" /></th>
						<th><s:text name="label.idfuncionario" /></th>
						<th><s:text name="label.data" /></th>
						<th class="text-end mt-4"><s:text name="label.acao" /></th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="exameFuncionarioList">
						<tr>
							<td>${exameVo.rowid}</td>
							<td>${funcionarioVo.rowid}</td>
							<td><fmt:formatDate value="${dataDoExame}" type="date"
									pattern="dd/MM/yyyy" /></td>
							<td class="text-end">

								<s:url action="editarExamesFuncionario" var="editar">
									<s:param name="exameFuncionarioVo.exameVo.rowid" value="exameVo.rowid"></s:param>
									<s:param name="exameFuncionarioVo.funcionarioVo.rowid" value="funcionarioVo.rowid"></s:param>
									<s:param name="exameFuncionarioVo.dataDoExame" value="dataDoExame"></s:param>
								</s:url> 
								<a href="${editar}" class="btn btn-warning text-white">
									<s:text name="label.editar" />
								</a> 
						
								<a href="#" class="btn btn-danger" data-bs-toggle="modal"
								data-bs-target="#confirmarExclusao" onclick="setDeleteUrl('${exameVo.rowid}', '${funcionarioVo.rowid}', '${dataDoExame}')">
									<s:text name="label.excluir" />
								</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>

				<tfoot class="table-secondary">
					<tr>
						<td colspan="4">
							<s:url action="novoExamesFuncionario" var="novoExame" /> 
							<a href="${novoExame}" class="btn btn-success">
								<s:text name="label.novoexamefuncionario" />
							</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>

		<div class="row"></div>
	</div>

	<div class="modal fade" id="confirmarExclusao"
		data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<s:text name="label.modal.titulo" />
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<span><s:text name="label.modal.corpo" /></span>
				</div>
				<div class="modal-footer">
					<a class="btn btn-secondary" data-bs-dismiss="modal"
						aria-label="Close"> 
						<s:text name="label.nao" />
					</a> 
					<a id="deleteLink" href="#" class="btn btn-primary" style="width: 75px;">
						<s:text name="label.sim" />
					</a>
				</div>
			</div>
		</div>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	<script>
	function setDeleteUrl(exameId, funcionarioId, dataDoExame) {
	    var deleteLink = document.getElementById("deleteLink");
	    deleteLink.href = "excluirExamesFuncionario.action?exameFuncionarioVo.exameVo.rowid=" + exameId +
	        "&exameFuncionarioVo.funcionarioVo.rowid=" + funcionarioId + "&exameFuncionarioVo.dataDoExame=" + encodeURIComponent(dataDoExame);
	}

	</script>
</body>
</html>
