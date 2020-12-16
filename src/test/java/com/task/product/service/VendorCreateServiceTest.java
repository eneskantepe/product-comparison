package com.task.product.service;

import com.task.product.repository.VendorCreateDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VendorCreateServiceTest {

    @InjectMocks
    private VendorCreateService vendorCreateService;

    @Mock
    private VendorCreateDao vendorCreateDao;

    @Test
    public void shouldCallDaoMethod() {
        vendorCreateService.createVendorForApi(null);
        verify(vendorCreateDao).createVendor(any());
    }
}