package com.avito.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Category> subCategorys = new HashSet<>();

    public Category() {
    }

    public Category(long id, String name, Set<Category> subCategorys) {
        this.id = id;
        this.name = name;
        this.subCategorys = subCategorys;
    }

}
