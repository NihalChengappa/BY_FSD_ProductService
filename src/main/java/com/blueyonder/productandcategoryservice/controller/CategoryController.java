package com.blueyonder.productandcategoryservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blueyonder.productandcategoryservice.entities.Category;
import com.blueyonder.productandcategoryservice.exceptions.CategoryNotFoundException;
import com.blueyonder.productandcategoryservice.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/ecommerceapp/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/addcategory")
	public ResponseEntity<Category> addNewCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		return new ResponseEntity<Category>(category,HttpStatus.CREATED);
	}
	@PostMapping("/updatecategory")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category,@RequestParam Integer id) throws CategoryNotFoundException {
		Category cat=categoryService.findCategoryById(id);
		if(cat!=null) {
			if(category.getCategoryDescription()!=null) {
				cat.setCategoryDescription(category.getCategoryDescription());
			}
			if(category.getName()!=null) {
				cat.setName(category.getName());
			}
			categoryService.updateCategory(cat);
		}
		else {
			throw new CategoryNotFoundException();
		}
		return new ResponseEntity<Category>(category,HttpStatus.CREATED);
	}
}
