package com.cgi.grocery.controller;

import com.cgi.grocery.model.Grocery;
import com.cgi.grocery.service.GroceryDataService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Srikanth Chintala
 * Type Grocery Data Controller exposes an end point to fetch list of groceries.
 */
@RestController
public class GroceryDataController {
    private final GroceryDataService groceryService;

    @Autowired
    public GroceryDataController(GroceryDataService groceryService) {
        super();
        this.groceryService = groceryService;
    }

    /**
     * Fetches the list of available groceries
     * @return list of groceries
     * @throws Exception
     */
    @Operation(summary="Gets the available grocery data")
    @GetMapping(value="/groceryData", produces = "application/json")
    public ResponseEntity<List<Grocery>> getAllGroceryItems() throws Exception{
        return ResponseEntity.ok(groceryService.getGroceryItems());
    }
}
