package com.bolsadeideas.springboot.app.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException { // se invoca cuando un usuario ha iniciado sesión correctamente.parámetros: la solicitud, la respuesta y la info de eutenticación
		
		SessionFlashMapManager flashMapManager = new SessionFlashMapManager(); // para administrar los mensajes flash.
		
		FlashMap flashMap = new FlashMap(); // se crea un obj para almacenar un mnsj flash
		
		flashMap.put("success", "Hola " + authentication.getName()  + " has iniciado sesión con éxito!");
		
		if(authentication != null) {
			logger.info("El usuario '" + authentication.getName() +"' Ha iniciado sesión con éxito"); // sacamos la info por consola
		}
		
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
