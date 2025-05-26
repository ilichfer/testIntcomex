package com.technicaltest.mappers;

import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.model.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoriesDTO EntitytoCategoryDTO(Categories entity);
    List<CategoriesDTO> listEntitytoCategoryDTO(List<Categories> entity);

    List<Categories> listDTOToListEntity(List<CategoriesDTO> dto);
    Categories DtoToEntity(CategoriesDTO dto);
}
