package com.blueyonder.productandcategoryservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blueyonder.productandcategoryservice.entities.Category;
import com.blueyonder.productandcategoryservice.exceptions.CategoryNotFoundException;
import com.blueyonder.productandcategoryservice.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.save(category);
	}
	
	@Override
	public Category findCategoryById(Integer id) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		Optional<Category> category=categoryRepository.findById(id);
		if(category.isPresent()) {
			return category.get();
		}
		else {
			throw new CategoryNotFoundException();
		}
	}

	@Override
	public void updateCategory(Category category) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		categoryRepository.save(category);
		
	}

	@Override
	public void deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
