package com.woodconnectApp.woodconnectApp.dto;

import java.util.List;

import lombok.Data;

@Data
public class VariantValueDTO {

	private Integer id;
	private String name;
	private Integer variantId;
	private List<VariantDTO> variant;
}
