package com.conpany.inventary.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conpany.inventary.dao.ICategoryDao;
import com.conpany.inventary.model.Category;
import com.conpany.inventary.response.CategoryResponseRest;


@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> search() {
		CategoryResponseRest response = new CategoryResponseRest();
		try {
			List<Category> category = (List<Category>) categoryDao.findAll();
			response.getCategoryResponse().setCategory(category);
			response.setMetadata("Respuesta OK","00", "Respuesta exitosa");
			
			
		}catch (Exception e) {
			
			response.setMetadata("Respuesta noK", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> searchById(Long id) {
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category>lista = new ArrayList<>();
		try {
			Optional<Category> category = categoryDao.findById(id);
			if(category.isPresent()) {
				lista.add(category.get());
				response.getCategoryResponse().setCategory(lista);
				response.setMetadata("Respuesta OK", "00", "Categoria encontrada");
			}else {
				response.setMetadata("Respuesta nOK", "-1", "Categoria no encontrada");
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			response.setMetadata("Respuesta nOK", "-1", "Error al consultar categoria por id");
			e.getStackTrace();
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> save(Category obj) {
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category>lista = new ArrayList<>();
		try {
			Category category = categoryDao.save(obj);
			if(category != null) {
				lista.add(category);
				response.getCategoryResponse().setCategory(lista);
				response.setMetadata("Respuesta OK", "00", "Categoría guardada");
			}else {
				response.setMetadata("Respuesta NOK", "-1", "Categoria no guardada");
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			response.setMetadata("Respuesta NOK", "-1", "Error al guardar");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> update(Category category,Long id) {
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category>lista = new ArrayList<>();
		
		try {
			Optional<Category> searchCategory = categoryDao.findById(id);
			if(searchCategory.isPresent()) {
				searchCategory.get().setName(category.getName());
				searchCategory.get().setDescription(category.getDescription());
				
				Category update = categoryDao.save(searchCategory.get());
				
				if(update != null) {
					lista.add(update);
					response.getCategoryResponse().setCategory(lista);
					response.setMetadata("Respuesta OK", "00", "Categoria Guardada");
				}else {
					response.setMetadata("Respuesta NOK", "-1", "Categoria no actualizada");
					return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
				}
			}
			else {
				response.setMetadata("Respuesta NOK", "-1", "Categoria no encotrada");
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			response.setMetadata("Respuesta NOK", "-1", "Error al actualizar la categoria");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> delete(Long id) {
		CategoryResponseRest response = new CategoryResponseRest();
		try {
			categoryDao.deleteById(id);
			response.setMetadata("Respuesta OK", "00", "Registro eliminado");
			
			
		}catch (Exception e) {
			response.setMetadata("Respuesta NOK", "-1", "Error al eliminar la categoria");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
