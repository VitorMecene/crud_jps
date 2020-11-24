<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

	<meta charset="ISO-8859-1">
	<title>Receitas</title>
</head>

<body>

	<form method="POST" action="ReceitasServlet">
		<input type="hidden" name="acao" value="CREATE"> <input type="hidden" name="idReceita"
			value="${receita.idReceita}">
		Id <input type="text" disabled name="idReceita" value="${receita.idReceita}" /><br>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-default">Default</span>
			</div>
			<input type="text" class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default">
		</div>

		Tipo Conta<input type="text" name="tipoConta" value="${receita.tipoConta}" /><br> Nome Tag <input type="text"
			name="nomeTag" value="${receita.nomeTag}" /><br> Nome Categoria
		<input type="text" name="nomeCategoria" value="${receita.nomeCategoria}" /><br> Data <input type="text"
			name="dataInclusao" value="${receita.dataInclusao}" /><br>
		Descricao <input type="text" name="descricao" value="${receita.descricao}" /><br> Valor <input type="text"
			name="valorReceita" value="${receita.valorReceita}" /><br> <input type="submit" value="Enviar" />
	</form>

	<font color="red">
		<h2>${mensagem}</h2>
	</font>

	<h4>Receitas Cadastradas</h4>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Codigo da Conta</th>
				<th scope="col">Tipo da Conta</th>
				<th scope="col">Tag</th>
				<th scope="col">Categoria</th>
				<th scope="col">Data</th>
				<th scope="col">Descricao</th>
				<th scope="col">Valor</th>
				<th colspan="2">Opcoes</th>
			</tr>
		</thead>
		<c:forEach var="r" items="${receitas}">
			<tr>
				<th scope="row">${r.idReceita}</th>
				<td>${r.codigoConta}</td>
				<td>${r.tipoConta}</td>
				<td>${r.nomeTag}</td>
				<td>${r.nomeCategoria}</td>
				<td>${r.dataInclusao}</td>
				<td>${r.descricao}</td>
				<td>${r.valorReceita}</td>
				<td><a href=ReceitasServlet?acao=RETRIEVE&codigo=${r.idReceita}>
						Editar</a></td>
				<td><a href=ReceitasServlet?acao=DELETE&codigo=${r.idReceita}>
						Excluir</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href=index.html>Voltar</a>

</body>

</html>