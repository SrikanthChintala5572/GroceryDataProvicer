package com.cgi.grocery;

import com.cgi.grocery.service.XlsxFileReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

@SpringBootApplication
public class GrocerydataproviderApplication implements CommandLineRunner {

	@Autowired
	XlsxFileReadService xlsxFileReadService;
	public static void main(String[] args) {
		SpringApplication.run(GrocerydataproviderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		InputStream is=getResourceFileAsInputStream("vegetables.xlsx");
		xlsxFileReadService.readXlsxFile(is);
	}

	public InputStream getResourceFileAsInputStream(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream(fileName);
	}

}
