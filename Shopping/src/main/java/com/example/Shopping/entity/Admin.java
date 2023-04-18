package com.example.Shopping.entity;

import com.example.Shopping.entity.listener.DateListener;
import com.example.Shopping.entity.listener.LibraryEntityListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@EntityListeners(value = {LibraryEntityListener.class})
public class Admin implements DateListener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String id;
    private String password;
    private String name;
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
