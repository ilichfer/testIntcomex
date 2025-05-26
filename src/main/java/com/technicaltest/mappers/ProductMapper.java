package com.technicaltest.mappers;

import com.technicaltest.dto.ProductDTO;
import com.technicaltest.model.Products;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO EntitytoProductDTO(Products entity);
    List<ProductDTO> listEntitytoProductDTO(List<Products> entity);

    List<Products> listDTOToListEntity(List<ProductDTO> dto);
    Products DTOToEntity(ProductDTO dto);

}
