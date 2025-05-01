package com.carx.demo.controller;

import com.carx.demo.dto.CategoryDto;
import com.carx.demo.dto.SpinResultDto;
import com.carx.demo.entity.Category;
import com.carx.demo.service.SpinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SpinController {
    private final SpinService spinService;

@GetMapping("/categories")
    public List<Category> getCategories() {
    return spinService.getAllCategories();
}

    @PostMapping("/spin/{selectedCategoryId}")
    public SpinResultDto spin(@PathVariable Long selectedCategoryId) {
     return spinService.spin(selectedCategoryId);
    }
    @GetMapping("/categories/{id}")
    public CategoryDto getCategory(@PathVariable Long id) {
    return spinService.getCategoryById(id);
    }


    }

