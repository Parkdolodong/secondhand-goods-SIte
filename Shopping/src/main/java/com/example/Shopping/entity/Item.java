//package com.example.Shopping.entity;
//
//import com.example.Shopping.entity.listner.LibraryEntityListener;
//import com.example.Shopping.constant.ItemSellStatus;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import java.time.LocalDateTime;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
//@Entity
//@EntityListeners(value = { LibraryEntityListener.class })
//public class Item {
//    private Long idx; // 물품 인덱스
//    private String name; // 물품 이름
//    private String explanation; // 물품 상세설명
//    private String kategorie_tag; // 물품 카테고리 태크
//    // private String item_image; // 물품 이미지
//    private int starting_price; // 물품 경매 시작 가격
//    private int bid_price; // 물품 입찰 가격
//    private int successful_bid_price; // 물품 낙찰 가격
//
//    private int immediate_purchase_price; // 물품 즉시 구매 가격
//    private ItemSellStatus itemSellStatus; // 물품 판매 상태
//
//    private LocalDateTime createdAt; // 등록 시간
//    private LocalDateTime updatedAt; // 수정 시간
//
//}
