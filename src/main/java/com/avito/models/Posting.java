package com.avito.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "posting")
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posting_id")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    @Column(name = "short_description")
    private String shortDescription;

    @Getter
    @Setter
    @Column(name = "full_description")
    private String fullDescription;

    @Getter
    @Setter
    @Column(name = "user_id")
    private Long userId;

    @Getter
    @Setter
    @Column(name = "category_id")
    private Long categoryId;

    @Getter
    @Setter
    @Column(name = "image_path")
    private String imagePath;

    public Posting() {
    }

    public Posting(String title, String shortDescription, String fullDescription, Long userId, Long categoryId, String imagePath) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.userId = userId;
        this.categoryId = categoryId;
        this.imagePath = imagePath;
    }

}
