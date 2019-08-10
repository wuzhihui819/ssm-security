package org.lanqiu.mapper;

import org.lanqiu.entity.Product;

public interface ProductMapper {
    Product selectByPrimaryKey(Integer id);

}