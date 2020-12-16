package com.task.product.service;

import com.task.product.repository.VendorDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VendorServiceTest {

    @InjectMocks
    private VendorService vendorService;

    @Mock
    private VendorDao vendorDao;

    @Test
    public void shouldCallDaoMethod() {
        vendorService.getVendorService("pull");
        verify(vendorDao).findVendorService("pull");
    }
}
