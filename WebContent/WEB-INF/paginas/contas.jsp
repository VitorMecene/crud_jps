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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Cadastro de Contas</title>
</head>
<body>

	<form method="POST" action="ContaServlet">
	<input type="hidden" name="acao" value="CREATE">
		<input type="hidden" name="codigoConta" value="${conta.codigoConta}">
		Codigo <input type="text" disabled name="codigoConta" value="${conta.codigoConta}" /><br>
		Codigo Usuário <input type="text" name="codigoUsuario" value="${conta.codigoUsuario}" /><br>
		Nome <input type="text" name="nomeConta" value="${conta.nomeConta}" /><br>
		Tipo <input type="text" name="tipoConta" value="${conta.tipoConta}" /><br>
		Valor <input type="text" name="valor" value="${conta.valorConta}" /><br>
		<input type="submit" value="Enviar" />
	</form>

	<font color="red"><h2>${mensagem}</h2></font>

	<h4>Contas cadastradas</h4>
		<table border="1">
			<tr>
				<th>Codigo</th>
				<th>Codigo Usuário</th>
				<th>Nome</th>
				<th>Tipo</th>
				<th>Valor</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
			<c:forEach var="c" items="${contas}">
				<tr>
					<td>${c.codigoConta}</td>
					<td>${c.codigoUsuario}</td>
					<td>${c.nomeConta}</td>
					<td>${c.tipoConta}</td>
					<td>${c.valorConta}</td>
					<td><a href=ContaServlet?acao=RETRIEVE&codigo=${c.codigoConta}> Editar</a></td>
					<td><a href=ContaServlet?acao=DELETE&codigo=${c.codigoConta}> Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

<a href=index.html >Voltar</a>
</body>
</html>