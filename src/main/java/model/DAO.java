package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/projetoLP2A4?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "R3deL0c@l";
	
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public void criarProduto(ProdutoBean produto) {
		String create = "insert into produtos (nome, preco, quantidade, categoria) values (?, ?, ?, ?)";
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getPreco());
			pst.setString(3, produto.getQuantidade());
			pst.setString(4, produto.getCategoria());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<ProdutoBean> listarProdutos(){
		String read = "select * from produtos order by quantidade";
		ArrayList<ProdutoBean> produtos = new ArrayList<>();
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String idprod = rs.getString(1);
				String nome = rs.getString(2);
				String preco = rs.getString(3);
				String quantidade = rs.getString(4);
				String categoria = rs.getString(5);
				
				produtos.add(new ProdutoBean(idprod, nome, preco, quantidade, categoria));
			}
			
			con.close();
			
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionarProduto(ProdutoBean produto) {
		String read = "select * from produtos where idprod = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, produto.getIdprod());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				produto.setIdprod(rs.getString(1));
				produto.setNome(rs.getString(2));
				produto.setPreco(rs.getString(3));
				produto.setQuantidade(rs.getString(4));
				produto.setCategoria(rs.getString(5));
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void editarProduto(ProdutoBean produto) {
		String update = "update produtos set nome=?, preco=?, quantidade=?, categoria=? where idprod=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getPreco());
			pst.setString(3, produto.getQuantidade());
			pst.setString(4, produto.getCategoria());
			pst.setString(5, produto.getIdprod());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarProduto(ProdutoBean produto) {
		String delete = "delete from produtos where idprod=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			
			pst.setString(1, produto.getIdprod());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
