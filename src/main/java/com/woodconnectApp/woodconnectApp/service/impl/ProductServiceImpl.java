package com.woodconnectApp.woodconnectApp.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.dto.VariantDTO;
import com.woodconnectApp.woodconnectApp.dto.VariantResponseDTO;
import com.woodconnectApp.woodconnectApp.dto.VariantValueDTO;
import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.OrderDetails;
import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.Variant;
import com.woodconnectApp.woodconnectApp.entity.VariantValue;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.repository.OrderDetailsRepository;
import com.woodconnectApp.woodconnectApp.repository.ProductRepository;
import com.woodconnectApp.woodconnectApp.repository.VariantRepository;
import com.woodconnectApp.woodconnectApp.repository.VariantValueRepository;
import com.woodconnectApp.woodconnectApp.repository.WoodTypeRepository;
import com.woodconnectApp.woodconnectApp.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private WoodTypeRepository woodtypeRepository;//foreign key
	
	@Autowired 
	private OrderDetailsRepository orderDetailRepository;
	
	@Autowired 
	private VariantRepository variantRepository;

	@Autowired
	private VariantValueRepository variantValueRepository;
	
	@Override
	public List getProduct() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDetails = new ArrayList<>();
		for (Product product : products) //to get multiple items
			{		    
			ProductDTO productObject = new ProductDTO(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
			if(product.getWoodType() != null) {
			Optional<WoodType> wood = woodtypeRepository.findById(product.getWoodType().getId());
		    
		    productObject.setWoodType_id(wood.get().getId());
		    productObject.setWoodtypename(wood.get().getWoodname());
			}
			else {
				    productObject.setWoodType_id(null);
				    productObject.setWoodtypename(null);
					
			}
			productObject.setId(product.getId());
		    productObject.setProductname(product.getProductname());
		    productObject.setPrice(product.getPrice());
		    productObject.setManufacture(product.getManufacturedate());
		    productObject.setStock(product.getStock());
//		    productObject.setImage(product.getImage());
		    productObject.setDescription(product.getDescription());
		   productDetails.add(productObject);
		}
		return productDetails;
		}

	public String deleteProduct(Integer id) {
		 Product product = productRepository
	                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		 List<OrderDetails> orderDetails = orderDetailRepository.findByProductId(id);
	        
	        if (!orderDetails.isEmpty()) {
	            // Handle order details (e.g., delete them or update them)
	            orderDetailRepository.deleteAll(orderDetails);
	            return "Product is aligned with an order.";
	        }
		 productRepository.delete(product);
		 return "Product deleted successfully";
		
	}
	@Override
	public void updateProduct(Integer id, ProductDTO product) {
		Product productData =productRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		productData.setStock(product.getStock());
		productData.setPrice(product.getPrice());
		productData.setDescription(product.getDescription());
		productData.setManufacturedate(product.getManufacture());
		if(product.getImage() != null) {
			byte[] imageBytes = product.getImage().getBytes();
			productData.setImage(imageBytes);
		}
		if(product.getWoodType_id() != null) {
			WoodType wood = woodtypeRepository.findById(product.getWoodType_id()).get();
		    productData.setWoodType(wood);
		}
		productRepository.save(productData);
	}
	@Override
	public ProductDTO getProductDetail(Integer id) {
		Product product = productRepository
	                .findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		
			    
		ProductDTO productObject = new ProductDTO(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		 productObject.setId(product.getId());
		 if(product.getWoodType() != null) {
			Optional<WoodType> wood = woodtypeRepository.findById(product.getWoodType().getId());
		   productObject.setWoodType_id(wood.get().getId());
		    productObject.setWoodtypename(wood.get().getWoodname());
		}
		else {
			    productObject.setWoodType_id(null);
			    productObject.setWoodtypename(null);
				
		}
	    productObject.setProductname(product.getProductname());
	    productObject.setPrice(product.getPrice());
	    productObject.setManufacture(product.getManufacturedate());
	    productObject.setStock(product.getStock());
	    productObject.setLength(product.getLength());
	    productObject.setWidth(product.getWidth());
	    productObject.setManufacturePrice(product.getManufacturePrice());
	    productObject.setLabourPrice(product.getLabourPrice());
	    if(product.getImage()!=null) {
		    String base64Image = Base64.getEncoder().encodeToString(product.getImage());
	
		    productObject.setImage(base64Image);
	    }
	    productObject.setDescription(product.getDescription());
	    return productObject;
	}

	public void createProduct(String productname, String description, String price, Integer woodType_id,
			byte[] image, String manufacture,String stock,String length,String width,String labourPrice,String manufacturePrice) {
		// TODO Auto-generated method stub
		Product productinfo = new Product();
		System.out.print(productname+"OOOOOOOOOOOOOOOOOOO");
		if(woodType_id != null) {
			WoodType woodtype = woodtypeRepository.findById(woodType_id)
					.orElseThrow(() -> new RuntimeException("WoodTypeId not found"));
			productinfo.setWoodType(woodtype);
			}
		productinfo.setDescription(description);
		productinfo.setProductname(productname);
		productinfo.setPrice(price);
		productinfo.setManufacturedate(manufacture);
		productinfo.setImage(image);
		productinfo.setStock(stock);

		productinfo.setLength(length);
		productinfo.setWidth(width);
		productinfo.setManufacturePrice(manufacturePrice);
		productinfo.setLabourPrice(labourPrice);
		productRepository.save(productinfo);
		return;
	}

	public void updateProduct(Integer id, String productname, String description, String price, Integer woodType_id,
			byte[] image, String manufacture, String stock,String length,String width,String labourPrice,String manufacturePrice) {
		Product productData =productRepository
		        .findById(id)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		productData.setStock(stock);
		productData.setPrice(price);
		productData.setDescription(description);
		productData.setManufacturedate(manufacture);
		productData.setLength(length);
		productData.setWidth(width);
		productData.setManufacturePrice(manufacturePrice);
		productData.setLabourPrice(labourPrice);
		if(image != null) {
			productData.setImage(image);
		}
		if(woodType_id != null) {
			WoodType wood = woodtypeRepository.findById(woodType_id).get();
		    productData.setWoodType(wood);
		}
		productRepository.save(productData);
	}

	public void createVariant(VariantDTO variant) {
		// TODO Auto-generated method stub
		Variant variant1 = new Variant();
		variant1.setName(variant.getName());
		variantRepository.save(variant1);
	}

	public void createVariantValue(VariantValueDTO variantValue) {
		// TODO Auto-generated method stub
		VariantValue variant1 = new VariantValue();
		variant1.setName(variantValue.getName());
		if(variantValue.getVariantId() != null) {
			Variant varaint = variantRepository.findById(variantValue.getVariantId()).get();
			variant1.setVariant(varaint);
		}
		variantValueRepository.save(variant1);
	}
	

	@Override
	public List getVariant() {
		List<Variant> variant = variantRepository.findAll();
		List<VariantResponseDTO> variantDetails = new ArrayList<>();
		for (Variant variantData : variant) //to get multiple items
			{
				VariantResponseDTO response = new VariantResponseDTO();
				response.setId(variantData.getId());
				response.setType(variantData.getName());
				List<VariantValue> value = variantValueRepository.findByVariantId(variantData.getId());
				List<VariantValueDTO> valueDTOs = new ArrayList<>();
				for (VariantValue variantValueData : value) //to get multiple items
				{

					VariantValueDTO valueDTO = new VariantValueDTO();
					valueDTO.setId(variantValueData.getId());
					valueDTO.setName(variantValueData.getName());
					valueDTOs.add(valueDTO);
				}
				response.setValues(valueDTOs);
				variantDetails.add(response);
			}
		return variantDetails;
	}

	public String deleteVaraint(Integer id) {
		 Variant variant = variantRepository
	                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		 List<VariantValue> variantValue = variantValueRepository.findByVariantId(id);
	        
	        if (!variantValue.isEmpty()) {
	            // Handle order details (e.g., delete them or update them)
	        	variantValueRepository.deleteAll(variantValue);
	            return "Varaint is aligned ";
	        }
	        variantRepository.delete(variant);
		 return "variant deleted successfully";
		
	}
	public String deleteVaraintValue(Integer id) {
		 VariantValue variant = variantValueRepository
	                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		 
	        variantValueRepository.delete(variant);
		 return "variant value deleted successfully";
		
	}

	public VariantResponseDTO getVariantDetails(Integer id) {
		Optional<Variant> variantData = variantRepository.findById(id);
		VariantResponseDTO response = new VariantResponseDTO();
		response.setId(variantData.get().getId());
		response.setType(variantData.get().getName());
		List<VariantValue> value = variantValueRepository.findByVariantId(variantData.get().getId());
		List<VariantValueDTO> valueDTOs = new ArrayList<>();
		for (VariantValue variantValueData : value) //to get multiple items
		{

			VariantValueDTO valueDTO = new VariantValueDTO();
			valueDTO.setId(variantValueData.getId());
			valueDTO.setName(variantValueData.getName());
			valueDTOs.add(valueDTO);
		}
		response.setValues(valueDTOs);
		return response;	}
}
