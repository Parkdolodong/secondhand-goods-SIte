package com.example.Shopping.entity;

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
@EntityListeners(value = { LibraryEntityListener.class })
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String address;
    private Long zonecode;
    private String detailedaddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
