package com.product.service;

import com.product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Table",5000,"Make by woods","Japan"));
        products.put(2,new Product(2,"Chair",2000,"Make by bamboos","Vietnamese"));
        products.put(3,new Product(3,"Fan",1500,"Storm is coming","Thailand"));
        products.put(4,new Product(4,"Lamp",4000,"Keeper of the light","China"));
        products.put(5,new Product(5,"Bed",10000,"Nightmare every night","China"));
    }


    @Override
    public List<Product> showAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        for (int i = 1; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)){
                return products.get(i);
            }
        } return null;
    }
}
