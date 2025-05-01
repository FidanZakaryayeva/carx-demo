package com.carx.demo.service;

import com.carx.demo.dto.CategoryDto;
import com.carx.demo.dto.SpinResultDto;
import com.carx.demo.entity.Category;

import java.util.List;

public interface SpinService {
     List<Category> getAllCategories();
     SpinResultDto spin(Long selectedCategoryId);
     CategoryDto getCategoryById(Long id);


}
