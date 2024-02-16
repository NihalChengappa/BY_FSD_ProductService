package com.blueyonder.productandcategoryservice.service;

import com.blueyonder.productandcategoryservice.entities.Category;
import com.blueyonder.productandcategoryservice.exceptions.CategoryNotFoundException;

public interface CategoryService {
	public void addCategory(Category category);
	public void updateCategory(Category category) throws CategoryNotFoundException;
	public void deleteCategory(Integer id);
	public Category findCategoryById(Integer id) throws CategoryNotFoundException;
}
