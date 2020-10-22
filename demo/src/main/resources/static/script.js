$(document).ready(function() {
        $('#cadProdutos').submit(function(){                    
            $.post('../produtos',
            		$('#cadProdutos input'),
            		function(retorno){                        
                alert("Produto cadastrado com sucesso");
                location.reload(true);
            }, 'html'); 
            
            return false;
            
        });
	
	//futuras implementações
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        }
        })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") 
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});

function getProdutos(){
	$.ajax({
		  url: "../produtos",
		  cache: false
		  
	})
		  .done(function( resultado ) {
		  console.log(">>>>>>>>>>>>>>>>>" + JSON.stringify(resultado));
		  
		   $('#myTable tbody').empty();	  
		   	
			  for(var i = 0 ; i< resultado.length ; i++){			  
				  $( '#myTable > tbody:last-child' ).append( 
				  "<tr>" +
				  "	<td><div id=\"id_produto\">"+resultado[i].codigo_produto+"</div></td>" +
				  " <td><div id=\"descricao\">" +resultado[i].descricao+"</div></td> " +
				  " <td><div id=\"custo\">" +resultado[i].preco_venda+"</div></td> " +
				  " <td><div id=\"preco\">" +resultado[i].preco_custo+"</div></td> " +
				  " <td><div id=\"quantidade\">" +resultado[i].quantidade+"</div></td> " +
				  
				  " <td onclick=\"deleteProduto("+resultado[i].id_produto+")\"><div id=\"delete\"> Inativar </div></td> " +
				  
				  " <td onclick=\"ajaxGet("+resultado[i].id_produto+")\"><div id=\"editar\"> Editar </div></td> " +
				  				  
				  
				  "</tr>" );
			  }
			 
			  
		  });
	
}



function deleteProduto(idd){

	console.log("!!!!!!!!!" + idd);
	
	$.ajax({
    type : "DELETE",
    url : "../produtos/" + idd,
    success: function (result) {       
           getProdutos();                
    alert("Item inativado");  
    },
    error: function (e) {
        console.log(e);
    
    }
	});
}


function ajaxGet(idd){
    $.ajax({
      type : "GET",
      url : "../produtos/" + idd,
      success: function(result){
        if(result){
          
              $("#id_produto").val(result.id_produto);
              $("#descricao").val(result.descricao);
              $("#codigo_produto").val(result.codigo_produto);
              $("#preco_custo").val(result.preco_custo);
              $("#preco_venda").val(result.preco_venda);
              $("#quantidade").val(result.quantidade);
              $("#endereco_imagem").val(result.endereco_imagem);
          
        }else{
                   console.log("else Success: ", result);
                            
        }
      },
      error : function(e) {
        console.log("ERROR: ", e);
      }
    });  
  }








