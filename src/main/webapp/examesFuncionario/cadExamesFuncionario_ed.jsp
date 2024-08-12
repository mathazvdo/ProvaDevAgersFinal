<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="label.titulo.pagina.cadastro" /></title>
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
				<s:url action="todosExamesFuncionarios" var="todos" />
				<a href="${todos}" class="btn btn-primary btn-lg">Funcionarios</a>
			</div>
			<div class="col-sm-2">
				<s:url action="todosFuncionarios" var="todos" />
				<a href="${todos}" class="btn btn-primary btn-lg">Lista Geral</a>
			</div>
			
		</div>

		<s:form action="/salvarEdicaoExamesFuncionario.action">

			<div class="card mt-3">
				<div class="card-header">
					<div class="row">
							<div class="col-sm-5">				
								<s:url action="todosExamesFuncionario" var="todosExamesFuncionario">
								</s:url>
								<a href="${todosExamesFuncionario}" class="btn btn-success">Voltar</a>
							</div>

						<div class="col-sm">
							<h5 class="card-title">Alterar Exames Funcionario</h5>
						</div>
					</div>
				</div>
				
				
						<div class="card-body">
							    <div class="row">
							        
							        <div class="col-sm-4">
							            <div class="row mb-3">
							                <label for="idExame" class="col-sm-4 col-form-label text-center">
							                    ID Exame:
							                </label>
							                <div class="col-sm-4">
							                    <s:textfield cssClass="form-control" id="idExame" name="exameFuncionarioVo.exameVo.rowid" readonly="true" />
							                </div>
							            </div>
							
							            <div class="row mb-3">
							                <label for="idFuncionario" class="col-sm-4 col-form-label text-center">
							                    ID Funcionário:
							                </label>
							                <div class="col-sm-4">
							                    <s:textfield cssClass="form-control" id="idFuncionario" name="exameFuncionarioVo.funcionarioVo.rowid" readonly="true" />
							                </div>
							            </div>
							
							            <div class="row mb-3">
							                <label for="dataDoExame" class="col-sm-4 col-form-label text-center">
							                    Data Exame:
							                </label>
							                <div class="col-sm-5">
							                    <s:textfield cssClass="form-control" id="dataDoExame" name="exameFuncionarioVo.dataDoExame" readonly="true" />
							                </div>
							            </div>
							        </div>
							
							        
							        <div class="col-sm-8">
							            <div class="row mb-3">
							                <label for="idExameNovo" class="col-sm-8 col-form-label text-center">
							                       ID Exame:
							                </label>
							                <div class="col-sm-2">
							                    <s:textfield cssClass="form-control" id="idExameNovo" name="novoExameFuncionarioVo.exameVo.rowid" readonly="false" />
							                </div>
							            </div>
							
							            <div class="row mb-3">
							                <label for="idFuncionarioNovo" class="col-sm-8 col-form-label text-center">
							                    ID Funcionário:
							                </label>
							                <div class="col-sm-2">
							                    <s:textfield cssClass="form-control" id="idFuncionarioNovo" name="novoExameFuncionarioVo.funcionarioVo.rowid" readonly="false" />
							                </div>
							            </div>
							
							            <div class="row mb-3">
							                <label for="dataDoExameNovo" class="col-sm-8 col-form-label text-center">
							                    Data Exame:
							                </label>
							                <div class="col-sm-3">
							                    <s:textfield type="date" cssClass="form-control" id="dataDoExameNovo" name="novoExameFuncionarioVo.dataDoExame" readonly="false" />
							                </div>
							            </div>
							        </div>
							    </div>
							</div>

						
						

				<div class="card-footer">
					<div class="form-row">
						<button class="btn btn-primary col-sm-4 offset-sm-1">Salvar</button>
						<button type="reset"
							class="btn btn-secondary col-sm-4 offset-sm-2">Limpar
							Formulario</button>
					</div>
				</div>
			</div>
		</s:form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>