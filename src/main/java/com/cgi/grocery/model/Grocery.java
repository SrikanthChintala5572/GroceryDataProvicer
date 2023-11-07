package com.cgi.grocery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Srikanth Chintala
 * Type represents grocery
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grocery {

	private String itemName;

	private float price;

	private String date;

}
