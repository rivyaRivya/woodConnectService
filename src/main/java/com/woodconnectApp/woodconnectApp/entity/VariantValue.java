package com.woodconnectApp.woodconnectApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class VariantValue {
	@Id
	@GeneratedValue
    private Integer id;
	private String name;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "variantId", nullable = true)
	private Variant variant;
	
	public Variant getVariant() {
		return variant;
	}
}
