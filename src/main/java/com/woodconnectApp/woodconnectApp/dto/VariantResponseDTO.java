package com.woodconnectApp.woodconnectApp.dto;

import java.util.List;

import com.woodconnectApp.woodconnectApp.entity.VariantValue;

import lombok.Data;

@Data
public class VariantResponseDTO {

	private Integer id;
	private String type;
	private List<VariantValueDTO> values;
	
}
