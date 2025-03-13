package com.woodconnectApp.woodconnectApp.dto;


import java.sql.Blob;
import java.util.Date;
import java.util.List;

public class OrderRequest {

    private Integer userId;
    private Double advanced_amount;
    private String paymentStatus;
    private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getAdvanced_amount() {
		return advanced_amount;
	}

	public void setAdvanced_amount(Double advanced_amount) {
		this.advanced_amount = advanced_amount;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	private String orderDate;
    private double total_amount;
    private String orderStatus;
    public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	private List<ProductRequest> products;  // A list of product details (ID and quantity)

    // Getters and Setters
 

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return total_amount;
    }

    public void setTotalAmount(double totalAmount) {
        this.total_amount = totalAmount;
    }

    public List<ProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }

    public static class ProductRequest {
        private Integer productId;
        private int quantity;
        private String productname;
    	private String price;
    	private String manufacture;
    	private String stock;
    	private Blob image;
    	private Integer WoodType_id;
    	public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getManufacture() {
			return manufacture;
		}

		public void setManufacture(String manufacture) {
			this.manufacture = manufacture;
		}

		public String getStock() {
			return stock;
		}

		public void setStock(String stock) {
			this.stock = stock;
		}

		public Blob getImage() {
			return image;
		}

		public void setImage(Blob image) {
			this.image = image;
		}

		public Integer getWoodType_id() {
			return WoodType_id;
		}

		public void setWoodType_id(Integer woodType_id) {
			WoodType_id = woodType_id;
		}

		public String getWoodtypename() {
			return woodtypename;
		}

		public void setWoodtypename(String woodtypename) {
			this.woodtypename = woodtypename;
		}

		private String woodtypename;
    	
        // Getters and Setters
        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
