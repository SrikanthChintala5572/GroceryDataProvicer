package com.cgi.grocery.service;

import com.cgi.grocery.model.Grocery;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GroceryDataServiceTest {


    @Autowired
    GroceryDataService service;

    @Mock
    XlsxFileReadService xlsxFileReadService;

    @BeforeEach
    public void setService() {
        MockitoAnnotations.openMocks(this);
        service = new GroceryDataService(xlsxFileReadService);
    }

    @Test
    @DisplayName("unit testing for get grocery items ")
    public void getGroceryItemsTest() {
        List<Grocery> list = Lists.newArrayList(new Grocery("Amla", 97, "18-07-2012"),
                new Grocery("Green Apple", 15, "24-06-2015"));
		when(xlsxFileReadService.getData()).thenReturn(list);
        List<Grocery> data = service.getGroceryItems();
        assertEquals(data.size(), 2);
    }
}
