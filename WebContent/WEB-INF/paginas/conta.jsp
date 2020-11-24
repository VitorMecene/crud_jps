<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Jekyll v4.1.1">
  <title>Contas</title>

  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }

    }
  </style>
  <!-- Custom styles for this template -->
  <link href="starter-template.css" rel="stylesheet">
</head>

<body>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">MF</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
      aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">

      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href=index.html>Home <span class="sr-only">(current)</span></a>
        </li>
          <a class="nav-link" href="ContaServlet">Contas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ReceitasServlet">Receitas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Despesas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Transferencias</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Cartao</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Tags</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Categorias</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Configuracao</a>
        </li>
      </ul>

      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>

  <main role="main" class="container">

    <div class="starter-template">
      <h1>CONTAS</h1>
      <p class="lead">Aqui voce pode cadastrar suas contas, simulando as contas de banco de voce possui</p>
    </div>

    <form method="POST" action="ContaServlet">

      <input type="hidden" name="acao" value="CREATE">
      <input type="hidden" name="codigoConta" value="${conta.codigoConta}">


      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Codigo</label>
        <div class="col-sm-10">
          <input type="text" disabled name="codigoConta" value="${conta.codigoConta}" class="form-control" id="colFormLabel" placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Codigo Usuario</label>
        <div class="col-sm-10">
          <input type="text" name="codigoUsuario" value="${conta.codigoUsuario}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Nome</label>
        <div class="col-sm-10">
          <input type="text" name="nomeConta" value="${conta.nomeConta}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Tipo</label>
        <div class="col-sm-10">
          <input type="text" name="tipoConta" value="${conta.tipoConta}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Valor</label>
        <div class="col-sm-10">
          <input type="text" name="valor" value="${conta.valorConta}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <br>
      <input type="submit" value="Enviar" />

    </form>

    <br>

    <font color="red">
      <h2>${mensagem}</h2>
    </font>

    <br>

    <h4>Contas cadastradas</h4>
    <br>

    <table class="table">
      <thead>
        <tr>
          <th scope="col">Codigo</th>
          <th scope="col">Codigo Usuario</th>
          <th scope="col">Nome</th>
          <th scope="col">Tipo</th>
          <th scope="col">Valor</th>
          <th colspan="2">Opcoes</th>
        </tr>
      </thead>
      <c:forEach var="c" items="${contas}">
        <tr>
          <th scope="row">${c.codigoConta}</td>
          <td>${c.codigoUsuario}</td>
          <td>${c.nomeConta}</td>
          <td>${c.tipoConta}</td>
          <td>${c.valorConta}</td>
          <td><a href=ContaServlet?acao=RETRIEVE&codigo=${c.codigoConta}> Editar</a></td>
          <td><a href=ContaServlet?acao=DELETE&codigo=${c.codigoConta}> Excluir</a></td>
        </tr>
      </c:forEach>
    </table>

    <br>
    <a href=index.html>Voltar</a>

  </main><!-- /.container -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
  <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
  <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

</html>