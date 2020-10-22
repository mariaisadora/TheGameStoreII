package piiv.senac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImagemProd {
	    
	    private int id_imagem_produto;
	    private int id_produto;
	    private String endereco_imagem;

	
	    @Override
	    public String toString() {
	    	return "ImagemProd{" + "id_imagem_produto=" + id_imagem_produto + ", id_produto=" + id_produto + ", endereco_imagem=" + endereco_imagem + '}';
	    }

	}
