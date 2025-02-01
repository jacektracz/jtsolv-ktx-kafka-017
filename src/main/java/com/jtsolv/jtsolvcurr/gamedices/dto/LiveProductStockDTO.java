package com.jtsolv.jtsolvcurr.gamedices.dto;

public class LiveProductStockDTO {
    

	private LiveProductDTO product;
	private Long stock;
	
	public LiveProductDTO getProduct() {
		return product;
	}

	public void setProduct(LiveProductDTO product) {
		this.product = product;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	
}
