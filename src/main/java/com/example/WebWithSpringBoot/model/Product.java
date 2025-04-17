package com.example.WebWithSpringBoot.model;

import com.example.WebWithSpringBoot.service.ProductService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.security.Provider;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String Category;
    private Date releaseDate;
    private boolean available;
    private int quantitiy;
    private String imageName;
    private String imageType;
    @Lob //Larg Object
    private byte[] imageData;
}
