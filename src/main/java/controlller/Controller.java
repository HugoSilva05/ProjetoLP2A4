package controlller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.ProdutoBean;

@WebServlet(urlPatterns = {"/Controller", "/main", "/create", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAO dao = new DAO();
    ProdutoBean produto = new ProdutoBean();
 
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/create")) {
			novoProduto(request, response);
		} else if (action.equals("/select")) {
			selecionarProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			deletarProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void produtos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProdutoBean> lista = dao.listarProdutos();
		
		request.setAttribute("produtos", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		
		rd.forward(request, response);
	}

	protected void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		produto.setNome(request.getParameter("nome"));
		produto.setPreco(request.getParameter("preco"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setCategoria(request.getParameter("categoria"));
		
		dao.criarProduto(produto);
		response.sendRedirect("main");
	}
	
	protected void selecionarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProd = request.getParameter("idProd");
		
		produto.setIdprod(idProd);
		
		dao.selecionarProduto(produto);
		
		request.setAttribute("idProd", produto.getIdprod());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("preco", produto.getPreco());
		request.setAttribute("quantidade", produto.getQuantidade());
		request.setAttribute("categoria", produto.getCategoria());
		
		RequestDispatcher rd = request.getRequestDispatcher("editarProduto.jsp");
		rd.forward(request, response);
	}
	
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		produto.setIdprod(request.getParameter("idProd"));
		produto.setNome(request.getParameter("nome"));
		produto.setPreco(request.getParameter("preco"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setCategoria(request.getParameter("categoria"));
		
		dao.editarProduto(produto);
		
		response.sendRedirect("main");
	}
	
	protected void deletarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProd = request.getParameter("idProd");
		
		produto.setIdprod(idProd);
		
		dao.deletarProduto(produto);
		
		response.sendRedirect("main");
	}
}
