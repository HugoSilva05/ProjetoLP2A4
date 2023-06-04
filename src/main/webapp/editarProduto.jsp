<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
  <title>Editar Produto</title>
</head>
<body class="d-flex justify-content-center">
  <form action="update" class="bg-primary border border-secondary rounded mt-5 d-flex flex-column" style="width: 600px; padding: 50px;">
    <h1 class="h1 text-light text-center">Editar Produto</h1>
    
    <label class="form-label text-light mt-2" for="idProd">ID do Produto:</label>
    <input class="form-control" type="text" name="idProd" id="idProd" value="<%=request.getAttribute("idProd")%>" autocomplete="off" readonly>

    <label class="form-label text-light mt-2" for="nome">Nome:</label>
    <input class="form-control" type="text" name="nome" id="nome" value="<%=request.getAttribute("nome")%>" autocomplete="off" required>

    <label class="form-label text-light mt-3" for="preco">Preço:</label>
    <input class="form-control" type="text" name="preco" id="preco" value="<%=request.getAttribute("preco")%>" autocomplete="off" required>

    <label class="form-label text-light mt-3" for="quantidade">Quantidade:</label>
    <input class="form-control" type="number" name="quantidade" id="quantidade" value="<%=request.getAttribute("quantidade")%>" autocomplete="off" required>

    <label class="form-label text-light mt-3" for="categoria">Categoria:</label>
    <input class="form-control" type="text" name="categoria" id="categoria" value="<%=request.getAttribute("categoria")%>" autocomplete="off" required>

    <button class="btn btn-light mt-4" type="submit">Editar Produto</button>
  </form>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>