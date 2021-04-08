package ro.fasttrackit.homeWork6.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ro.fasttrackit.homeWork6.client.model.Product;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ProductService {

    public List<Product> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/products",
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByCategory(String category) {
        RestTemplate restTemplate = new RestTemplate();
        URI targetUrl = UriComponentsBuilder.fromUriString("http://localhost:8080/products")
                .queryParam("category", category)
                .build()
                .toUri();
        return restTemplate.exchange(
                targetUrl,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByMaxPrice(Integer maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        URI targetUrl = UriComponentsBuilder.fromUriString("http://localhost:8080/products")
                .queryParam("maxPrice", maxPrice)
                .build()
                .toUri();
        return restTemplate.exchange(
                targetUrl,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public void addProduct(Product product) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject("http://localhost:8080/products", product, Product.class);
    }

    public void deleteProductById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/products/" + id, Product.class);
    }
}
