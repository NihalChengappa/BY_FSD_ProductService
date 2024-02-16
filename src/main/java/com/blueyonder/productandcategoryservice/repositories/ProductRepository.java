package com.blueyonder.productandcategoryservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.productandcategoryservice.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
