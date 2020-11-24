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
  <title>Receitas</title>

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
      <h1>RECEITAS</h1>
      <p class="lead">Aqui voce pode adcionar seus ganhos diarios</p>
    </div>

    <form method="POST" action="ReceitasServlet">

      <input type="hidden" name="acao" value="CREATE"> 
      <input type="hidden" name="idReceita" value="${receita.idReceita}">

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Id</label>
        <div class="col-sm-10">
          <input type="text" disabled name="idReceita" value="${receita.idReceita}" class="form-control" id="colFormLabel" placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Codigo Conta</label>
        <div class="col-sm-10">
          <input type="text" name="codigoConta" value="${receita.codigoConta}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Tipo Conta</label>
        <div class="col-sm-10">
          <input type="text" name="tipoConta" value="${receita.tipoConta}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Nome Tag</label>
        <div class="col-sm-10">
          <input type="text" name="nomeTag" value="${receita.nomeTag}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Nome Categoria</label>
        <div class="col-sm-10">
          <input type="text" name="nomeCategoria" value="${receita.nomeCategoria}" class="form-control"
            id="colFormLabel" placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Data</label>
        <div class="col-sm-10">
          <input type="text" name="dataInclusao" value="${receita.dataInclusao}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Descricao</label>
        <div class="col-sm-10">
          <input type="text" name="descricao" value="${receita.descricao}" class="form-control" id="colFormLabel"
            placeholder="">
        </div>
      </div>

      <div class="form-group row">
        <label for="colFormLabel" class="col-sm-2 col-form-label">Valor</label>
        <div class="col-sm-10">
          <input type="text" name="valorReceita" value="${receita.valorReceita}" class="form-control" id="colFormLabel"
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

    <h4>Receitas Cadastradas</h4>
    <br>

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
          <td><a href=ReceitasServlet?acao=RETRIEVE&codigo=${r.idReceita}>Editar</a></td>
          <td><a href=ReceitasServlet?acao=DELETE&codigo=${r.idReceita}>Excluir</a></td>
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