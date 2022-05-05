package com.alkemy.ong.controller;

import com.alkemy.ong.dto.CategoryDto;
import com.alkemy.ong.dto.CategoryNameDto;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryNameDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.returnList());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CategoryDto> updateCategory (@RequestBody CategoryDto categoryDto, @PathVariable Long id) {

        CategoryDto categoryUpdateDto = categoryService.updateCategory(categoryDto, id);
        return ResponseEntity.ok().body(categoryUpdateDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto dto){

        CategoryDto category = categoryService.addCategory(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        categoryService.deleteCategory(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
