package piiv.senac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImagemProd {
	    
	    private int id;
	    private int id_produto;
	    private String endereco_imagem;

	
	    @Override
	    public String toString() {
		return "ImagemProduto{" + "id=" + id + ", id_produto=" + id_produto + ", endereco_imagem=" + endereco_imagem + '}';
	    }

	}
