package org.lanqiu.service;

import org.lanqiu.entity.Product;
import org.lanqiu.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product queryProductByNo(Integer id){
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

}
