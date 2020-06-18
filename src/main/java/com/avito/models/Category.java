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
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private Set<Category> childCategory = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Category parentCategory;

    public Category() {
    }

    public Category(long id, String name, Category parentCategory, Set<Category> categoriesChild) {
        this.id = id;
        this.name = name;
        this.parentCategory = parentCategory;
        this.childCategory = categoriesChild;
    }

}
