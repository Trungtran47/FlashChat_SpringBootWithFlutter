package com.example.lab6_flutter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Đảm bảo rằng user_id sẽ tự động tăng
    @Column(name = "user_id") // Đảm bảo rằng tên cột trong cơ sở dữ liệu khớp với tên biến
    private Long id;

    @Column(name = "email", nullable = false) // Trường email không cho phép giá trị NULL
    private String email;

    @Column(name = "password", nullable = false) // Trường password không cho phép giá trị NULL
    private String password;

    // Constructors, Getters và Setters
    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
