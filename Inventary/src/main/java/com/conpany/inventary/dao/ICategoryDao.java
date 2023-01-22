package com.conpany.inventary.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conpany.inventary.model.Category;

@Repository
public interface ICategoryDao extends CrudRepository<Category, Long>{

}
