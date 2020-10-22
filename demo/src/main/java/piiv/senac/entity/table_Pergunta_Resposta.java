package piiv.senac.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class table_Pergunta_Resposta {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_perguntaResposta;
    private int produto_id;
    private String pergunta;
    private String resposta;
}
