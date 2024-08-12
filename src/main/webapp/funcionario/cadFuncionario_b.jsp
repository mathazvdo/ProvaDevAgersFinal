<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
					<s:url action="todosExamesFuncionario" var="todosExamesFuncionario">
					</s:url>
					<a href="${todosExamesFuncionario}" class="btn btn-primary btn-lg"><s:text name="label.detalhes" /></a>
				</div>
				
				<div class="col-sm-2">
					<s:url action="listarRelatorios" var="relatorio" />
					<a href="${relatorio}" class="btn btn-primary btn-lg">Relatorio Exames</a>
				</div>
				
		</div>
		<div class="row mt-3 mb-2">
			<div class="col-sm p-0">
				<s:form action="/filtrarFuncionarios.action">
					<div class="input-group">
						<span class="input-group-text"> <strong><s:text
									name="label.buscar.por" /></strong>
						</span>
						<s:select cssClass="form-select" name="filtrar.opcoesCombo"
							list="listaOpcoesCombo" headerKey="" headerValue="Escolha..."
							listKey="%{codigo}" listValueKey="%{descricao}"
							value="filtrar.opcoesCombo.codigo" />

						<s:textfield cssClass="form-control" id="nome"
							name="filtrar.valorBusca" />
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
						<th><s:text name="label.id" /></th>
						<th><s:text name="label.nome" /></th>
						<th class="text-end mt-5"><s:text name="label.acao" /></th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="funcionarios">
						<tr>
							<td>${rowid}</td>
							<td>${nome}</td>
							<td class="text-end">
										
								
								<s:url action="editarFuncionarios" var="editar">
									<s:param name="funcionarioVo.rowid" value="rowid"></s:param>
								</s:url> 
								<a href="${editar}" class="btn btn-warning text-white">
									<s:text name="label.editar" />
								</a> 
								<a href="#" class="btn btn-danger" data-bs-toggle="modal"
								data-bs-target="#confirmarExclusao" onclick="setDeleteUrl('${rowid}')">
									<s:text name="label.excluir" />
								</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>

				<tfoot class="table-secondary">
					<tr>
						<td colspan="3">
							<s:url action="novoFuncionarios" var="novo" /> 
							<a href="${novo}" class="btn btn-success">
								<s:text name="label.novofuncionario" />
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
		function setDeleteUrl(rowid) {
			var deleteLink = document.getElementById("deleteLink");
			deleteLink.href = "deletarFuncionarios.action?funcionarioVo.rowid=" + rowid;
		}
	</script>
</body>
</html>
