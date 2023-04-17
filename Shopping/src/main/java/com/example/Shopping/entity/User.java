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

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;


//    유저 상세 주소
    @ToString.Exclude
    @OneToOne(mappedBy = "user")
    @Builder.Default
    private List<UserAddress> address = new ArrayList<>();


    @Column(nullable = false)
    private String phoneNumber;

    @ToString.Exclude
    @OneToMany(mappedBy = "seller")
    private List<Item> itemsForSale;

    @ToString.Exclude
    @OneToMany(mappedBy = "bidder")
    private List<Bid> bids;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
