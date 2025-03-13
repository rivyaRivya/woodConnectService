package com.woodconnectApp.woodconnectApp.services;

import java.util.List;

import com.woodconnectApp.woodconnectApp.dto.QuotationDTO;

public interface QuotationServices {
	List<QuotationDTO> getQuotation();

	void createQuotation(String description, Integer user_id, byte[] imageBytes);

	QuotationDTO getQuotationDetailsf(Integer id);

	void updateStatus(Integer id, QuotationDTO quotation);

}
