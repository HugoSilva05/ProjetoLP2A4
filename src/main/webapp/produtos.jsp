<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ProdutoBean"%>
<%@ page import="java.util.ArrayList"%>
<%ArrayList<ProdutoBean> lista = (ArrayList<ProdutoBean>) request.getAttribute("produtos");%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <title>Produtos</title>
</head>
<body>
    <div class="container mt-3 d-flex flex-column">
        <h1 class="h1 text-center">Tabela de Produtos</h1>
        <a href="novoProduto.html" class="btn btn-primary">Adicionar Produto</a>

        <table class="table table-bordered bg-white text-black mt-3">
            <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th>Categoria</th>
                    <th style="width: 100px;">Opções</th>
                </tr>
            </thead>
            
            <tbody class="table-group-divider">
            
            	<%for(int i = 0; i < lista.size(); i++) {%>
	            	<tr>
	                    <td><%= lista.get(i).getIdprod() %></td>
	                    <td><%= lista.get(i).getNome() %></td>
	                    <td>R$<%= lista.get(i).getPreco() %></td>
	                    <td><%= lista.get(i).getQuantidade() %></td>
	                    <td><%= lista.get(i).getCategoria()%></td>
	                    <td class="d-flex justify-content-between">
	                        <a href="select?idProd=<%= lista.get(i).getIdprod() %>" class=""><img class="img" src="img/editar.png" alt="editar"></a>
	                        <a href="javascript: confirmar(<%= lista.get(i).getIdprod() %>)" class=""><img src="img/excluir.png" alt="excluir"></a>
	                    </td>
	                </tr>
            	<%} %>
            	
            </tbody>
        </table>
    </div>

	<script src="scripts/confirmador.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>