package com.blueyonder.productandcategoryservice.entities;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String prodcutName;
	private String prodyctPrice;
	private String productDescription;
	@JsonManagedReference
	@ManyToMany
	@JoinTable(
			name="product_categories",
			joinColumns = @JoinColumn(name="productId"),
			inverseJoinColumns=@JoinColumn(name="categoryId"))
	@lombok.ToString.Exclude
	private Set<Category>categoryList;
}
