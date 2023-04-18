package com.example.Shopping.entity;

import com.example.Shopping.entity.listener.DateListener;
import com.example.Shopping.entity.listener.LibraryEntityListener;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    private String id;
    private String password;
    private String name;
    private String email;

//    유저 상세 주소
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address", referencedColumnName = "idx")
    private UserAddress userAddress;

    private String phoneNumber;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Item> itemsForSale;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Bid> bids;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
