package piiv.senac.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import piiv.senac.entity.ImagemProd;
import piiv.senac.util.ConnectionBancoDados;



public class ImagemProdutoRepository {

	public void salvarImagensProduto(int id_produto, String[] imagens) {
	    Connection con = ConnectionBancoDados.obterConexao();
	    PreparedStatement stmt = null;

	    try {
	      for (int i=0 ; i<imagens.length ; i++) {
	       stmt = con.prepareStatement("update table_produtos set endereco_imagem=" + imagens[i] + ");");
	       stmt.executeUpdate();
	      }

	    } catch (SQLException ex) {
	      Logger.getLogger(ImagemProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      ConnectionBancoDados.fecharConexao(con, stmt);
	    }
	  }

	  public List<ImagemProd> getImagensProduto(int id_produto) {
	    Connection con = ConnectionBancoDados.obterConexao();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    List<ImagemProd> listaImagens = new ArrayList<>();

	    try {
	      stmt = con.prepareStatement("SELECT endereco_imagem FROM table_produtos where id_produto = " + id_produto);
	      rs = stmt.executeQuery();

	      while (rs.next()) {
	        ImagemProd img = new ImagemProd();
	        img.setId(rs.getInt("id"));
	        img.setId_produto(id_produto);
	        img.setEndereco_imagem(rs.getString("endereco_imagem"));
	        listaImagens.add(img);
	      }
	    } catch (SQLException ex) {
	      Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      ConnectionBancoDados.fecharConexao(con, stmt, rs);
	    }
	    return listaImagens;
	  }

	  public void alterarImagensProduto(int id_produto) {
	    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	  }

	  public void deletarImagensProduto(int id_produto) {
	    Connection con = ConnectionBancoDados.obterConexao();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	      stmt = con.prepareStatement("DELETE endereco_imagem FROM table_produtos where id_produto = ?;");
	      stmt.setInt(1, id_produto);
	      stmt.executeUpdate();
	    } catch (SQLException ex) {
	      Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      ConnectionBancoDados.fecharConexao(con, stmt, rs);
	    }
	  }

	}
