package io.github.rodrigoqueiroz01.service;

import io.github.rodrigoqueiroz01.model.ProductModel;
import io.github.rodrigoqueiroz01.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductModel create(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public ProductModel readById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Produto inválido."));
    }

    public List<ProductModel> readAll() {
        return productRepository.findAll();
    }

    public ProductModel update(ProductModel productModel, UUID id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Produto inválido."));
        productModel.setId(id);
        return productModel;
    }

    public UUID delete(UUID id) {
        var productModel = productRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Produto inválido."));
        productRepository.delete(productModel);
        return id;
    }

}
