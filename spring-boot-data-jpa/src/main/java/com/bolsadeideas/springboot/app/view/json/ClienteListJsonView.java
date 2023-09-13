package com.bolsadeideas.springboot.app.view.json;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

@SuppressWarnings("unchecked") // suprime el warning
@Component("listar.json")
public class ClienteListJsonView extends MappingJackson2JsonView{

	@Override
	protected Object filterModel(Map<String, Object> model) {
		
		model.remove("titulo"); //  atributo "titulo" que no se quiere incluir en la respuesta JSON.
		model.remove("page"); // atributo "page" que no se quiere incluir en la respuesta JSON.
		
		Page<Cliente> clientes = (Page<Cliente>) model.get("clientes"); // clientes es una página (lista paginada) de objetos Cliente, indica que el valor obtenido del modelo (que inicialmente es de tipo Object) se debe convertir a un tipo Page<Cliente>.
									// casting
		
		model.remove("clientes"); //  atributo "clientes" que no se quiere incluir en la respuesta JSON.
		model.put("clientes", clientes.getContent()); // lista de clientes
		return super.filterModel(model);
	}

}
