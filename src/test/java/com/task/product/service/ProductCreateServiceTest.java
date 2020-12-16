package com.task.product.service;

import com.task.product.repository.ProductCreateDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductCreateServiceTest {

    @InjectMocks
    private ProductCreateService productCreateService;

    @Mock
    private ProductCreateDao productCreateDao;

    @Test
    public void shouldCallDaoMethod() {
        productCreateService.createProducts(any(), any());
        verify(productCreateDao).create(any(), any());
    }
}