package com.cgi.grocery.service;

import com.cgi.grocery.model.Grocery;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Srikanth Chintala
 * type GroceryDataService to get the grocery data
 */
@Slf4j
@Service
public class GroceryDataService {

	private static final Logger logger = LoggerFactory.getLogger(GroceryDataService.class);

	XlsxFileReadService xlsxFileReadService;

	public GroceryDataService(XlsxFileReadService xlsxFileReadService) {
		super();
		this.xlsxFileReadService = xlsxFileReadService;
	}

	public List<Grocery> getGroceryItems() {
		return xlsxFileReadService.getData();
	}
	

}
