package com.hooks.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    private LocalDate dob;

    private String country;

    @ElementCollection
    @CollectionTable(name = "user_fav_categories", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "category")
    private List<String> favouriteCategories;
}
