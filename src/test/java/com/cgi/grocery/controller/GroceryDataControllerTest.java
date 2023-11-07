package com.cgi.grocery.controller;

import com.cgi.grocery.model.Grocery;
import com.cgi.grocery.service.GroceryDataService;
import com.cgi.grocery.service.XlsxFileReadService;
import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(GroceryDataController.class)
public class GroceryDataControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    GroceryDataService grocerydataservice;
    @MockBean
    XlsxFileReadService xlsxFileReadService;

    @Test
    @DisplayName("Unit test for getting all groceries items")
    public void getAllGroceryItemsTest() throws Exception {
        List<Grocery> list = Lists.newArrayList(new Grocery("Amla", 97, "18-07-2012"),
                new Grocery("Green Apple", 15, "24-06-2015"));
        when(grocerydataservice.getGroceryItems()).thenReturn(list);
        mockMvc.perform(get("/groceryData")).andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)));
    }

}
