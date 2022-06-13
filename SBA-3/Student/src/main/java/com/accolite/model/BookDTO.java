package com.accolite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO {

	private Integer bookId;
	private String bookName;
	private Double bookCost;
	private Integer quantity;
	private Double totalPrice;
}
