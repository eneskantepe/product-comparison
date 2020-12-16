package com.task.product.controller;

import com.task.product.model.VendorServiceModel;
import com.task.product.service.ProductCreateService;
import com.task.product.service.VendorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductSaveControllerTest {

    @InjectMocks
    private ProductSaveController productSaveController;

    @Mock
    private WebRequest webRequest;

    @Mock
    private VendorService vendorService;

    @Mock
    private ProductCreateService productCreateService;

    @Test
    public void shouldPrepareMapWhenHasRestApiPrivilege() {
        VendorServiceModel vendorServiceModel = new VendorServiceModel("ebay", "ebayService", "XYZABC");
        List<VendorServiceModel> models = new ArrayList<>();
        models.add(vendorServiceModel);
        when(vendorService.getVendorService("rest-api")).thenReturn(models);
        productSaveController.prepareMap();
        assertThat(productSaveController.mapApiKey.size(), equalTo(1));
    }

    @Test
    public void shouldPostProductsWhenApiKeyValid() {
        when(webRequest.getHeader("api-key")).thenReturn("XYZABC");
        Map<String, String> map = new HashMap<>();
        map.put("XYZABC", "ebay");
        productSaveController.mapApiKey = map;
        ResponseEntity responseEntity = productSaveController.post(webRequest, new ArrayList<>());
        verify(productCreateService).createProducts(eq("ebay"), anyList());
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.CREATED));
    }

    @Test
    public void shouldNotPostProductsWhenApiKeyNotValid() {
        when(webRequest.getHeader("api-key")).thenReturn("ebay");
        ResponseEntity responseEntity = productSaveController.post(webRequest, new ArrayList<>());
        verifyZeroInteractions(productCreateService);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }

}