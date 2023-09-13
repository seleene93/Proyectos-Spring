package com.bolsadeideas.springboot.app.models.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public Resource load(String filename) throws MalformedURLException; // para poder cargar la imagen

	public String copy(MultipartFile file) throws IOException; // el nombre renombrado de la imagen

	public boolean delete(String filename); // para saber si lo eliminó o no

	public void deleteAll();

	public void init() throws IOException;
}