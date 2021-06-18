package com.kh.home.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ItemDto {
	private int itemNo;
	private String itemName;
	private int itemPrice;
}