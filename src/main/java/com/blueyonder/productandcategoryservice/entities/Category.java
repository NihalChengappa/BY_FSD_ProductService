package com.blueyonder.productandcategoryservice.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="category_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	private String name;
	private String categoryDescription;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "categoryList")
	private Set<Product>productList;
}
