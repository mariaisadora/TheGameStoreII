package piiv.senac.dao;
import piiv.senac.entity.table_Pergunta_Resposta;
import piiv.senac.util.ConnectionBancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerguntaRespostaRepository {


	

	  public void salvarPerguntasRespostas(int produto_id, String[] perguntas, String[] respostas) {
	    Connection con = ConnectionBancoDados.obterConexao();
	    PreparedStatement stmt = null;

	    try {
	      for (int i=0 ; i<perguntas.length ; i++) {
	       stmt = con.prepareStatement("insert into table_Pergunta_Resposta(produto_id, pergunta, resposta) values(" + produto_id + ", '" + perguntas[i] + "', '" + respostas[i] + "');");
	       stmt.executeUpdate();
	      }

	    } catch (SQLException ex) {
	      Logger.getLogger(PerguntaRespostaRepository.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      ConnectionBancoDados.fecharConexao(con, stmt);
	    }
	  }

	  public List<table_Pergunta_Resposta> getPergunta_Resposta(int produto_id) {
	    Connection con = ConnectionBancoDados.obterConexao();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    List<table_Pergunta_Resposta> listaPerguntaResposta = new ArrayList<>();

	    try {
	      stmt = con.prepareStatement("SELECT * FROM table_Pergunta_Resposta where produto_id = " + produto_id);
	      rs = stmt.executeQuery();

	      while (rs.next()) {
	        table_Pergunta_Resposta pr = new table_Pergunta_Resposta();
	        pr.setId_perguntaResposta(rs.getInt("id_perguntaResposta"));
	        pr.setProduto_id(produto_id);
	        pr.setPergunta(rs.getString("pergunta"));
	        pr.setResposta(rs.getString("resposta"));
	        listaPerguntaResposta.add(pr);
	      }
	    } catch (SQLException ex) {
	      Logger.getLogger(PerguntaRespostaRepository.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      ConnectionBancoDados.fecharConexao(con, stmt, rs);
	    }
	    return listaPerguntaResposta;
	  }

	  public void deletarPerguntaResposta(int produto_id) {
	    Connection con = ConnectionBancoDados.obterConexao();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	      stmt = con.prepareStatement("DELETE FROM table_Pergunta_Resposta where produto_id = ?;");
	      stmt.setInt(1, produto_id);
	      stmt.executeUpdate();
	    } catch (SQLException ex) {
	      Logger.getLogger(PerguntaRespostaRepository.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      ConnectionBancoDados.fecharConexao(con, stmt, rs);
	    }
	  }

	}

