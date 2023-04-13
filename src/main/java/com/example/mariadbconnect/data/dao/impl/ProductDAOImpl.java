package com.example.mariadbconnect.data.dao.impl;

import com.example.mariadbconnect.data.dao.ProductDAO;
import com.example.mariadbconnect.data.entity.Product;
import com.example.mariadbconnect.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        System.out.println(product.getStock());
        System.out.println(product.getName());
        System.out.println(product.getPrice());

        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public Optional<Product> selectProduct(Long number) {
        Optional<Product> product= productRepository.findById(number);
        return product;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {

        Optional<Product> selectproduct = productRepository.findById(number);
        Product product=selectproduct.get();
        Product updatedProduct;
        if (product.getNumber()!=null){

            Product newproduct=new Product(
                    product.getNumber(),
                    name,
                    product.getPrice(),
                    product.getStock(),
                    LocalDateTime.now(),
                    product.getCreatedAt()
                    );
            // 변경감지에 의한 save
            updatedProduct = productRepository.save(newproduct);

        }else{
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()){
            Product product=selectedProduct.get();

            productRepository.delete(product);
        }else{
            throw new Exception();
        }
    }
}
