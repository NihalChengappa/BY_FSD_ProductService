package com.blueyonder.productandcategoryservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.productandcategoryservice.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
