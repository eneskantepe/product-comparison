package com.task.product.service;

import com.task.product.repository.ProductSearchDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductSearchServiceTest {

    @InjectMocks
    private ProductSearchService productSearchService;

    @Mock
    private ProductSearchDao productSearchDao;

    @Test
    public void shouldCallDaoMethod() {
        productSearchService.getProducts("", "");
        verify(productSearchDao).findProducts(any(), any());
    }
}