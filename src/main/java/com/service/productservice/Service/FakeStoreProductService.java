package com.service.productservice.Service;

import com.service.productservice.Model.Product;
import com.service.productservice.dto.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService {

    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }


    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct) {
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());

        return product;
    }

    public Product getProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> list = new ArrayList<>();
        for(FakeStoreProductDto productDtos:fakeStoreProductDto)
        {
            list.add(convertFakeStoreProductToProduct(productDtos));
        }

        return  list;
    }
}
