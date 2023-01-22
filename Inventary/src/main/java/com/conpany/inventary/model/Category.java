package com.conpany.inventary.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4268753630827549113L;

	@Id
	private long id;
	
	private String name;
	
	private String description;
}
