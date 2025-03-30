package com.woodconnectApp.woodconnectApp.services;

import java.util.List;

import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.entity.Product;


public interface ProductServices {
	
	List<ProductDTO> getProduct();
//	void deleteProduct(Integer id);
	void updateProduct(Integer id, ProductDTO product);
	ProductDTO getProductDetail(Integer id);
	List getVariant();
	List getProductByWood(Integer id);
	List<ProductDTO> productSearch(String keyword);


}
