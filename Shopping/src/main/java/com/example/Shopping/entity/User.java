package com.example.Shopping.entity;

import com.example.Shopping.entity.listener.DateListener;
import com.example.Shopping.entity.listener.LibraryEntityListener;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@EntityListeners(value = {LibraryEntityListener.class})
public class User implements DateListener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String id;
    @Column(nullable = true)
    private String password;
    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private String email;


//    유저 상세 주소
    @ToString.Exclude
    @OneToOne
    private Address address;

    @Column(nullable = true)
    private String phoneNumber;

//    @ToString.Exclude
//    @OneToMany(mappedBy = "seller")
//    private List<Item> itemsForSale;
//
//    @ToString.Exclude
//    @OneToMany(mappedBy = "bidder")
//    private List<Bid> bids;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
