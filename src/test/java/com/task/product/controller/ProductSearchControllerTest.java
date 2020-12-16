package com.task.product.controller;

import com.task.product.model.ProductDto;
import com.task.product.service.ProductSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ProductSearchControllerTest {

    @InjectMocks
    private ProductSearchController productSearchController;

    @Mock
    private ProductSearchService productSearchService;

    @Test
    public void shouldReturnNoContentWhenResultIsEmpty() {
        Mockito.when(productSearchService.getProducts("iphone", "phone")).thenReturn(new ArrayList<>());
        ResponseEntity<List<ProductDto>> search = productSearchController.search("iphone", "phone");
        assertThat(search.getStatusCode(), equalTo(HttpStatus.NO_CONTENT));
    }

    @Test
    public void shouldReturnBadRequestWhenParametersAreNull() {
        ResponseEntity<List<ProductDto>> search = productSearchController.search("", "");
        assertThat(search.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void shouldReturnOkAndProductsWhenParametersAreValid() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto());
        Mockito.when(productSearchService.getProducts("iphone", "phone")).thenReturn(productDtoList);
        ResponseEntity<List<ProductDto>> search = productSearchController.search("iphone", "phone");
        assertThat(search.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(search.getBody().size(), equalTo(1));
    }
}