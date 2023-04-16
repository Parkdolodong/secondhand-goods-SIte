//package com.example.Shopping.entity.listner;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import java.time.LocalDateTime;
//
//public class LibraryEntityListener {
//    @PrePersist
//    public void prePersist(Object o) {
//        if(o instanceof DateListener) {
//            ((DateListener)o).setCreatedAt(LocalDateTime.now());
//            ((DateListener)o).setUpdatedAt(LocalDateTime.now());
//        }
//    }
//
//    @PreUpdate
//    public void preUpdate(Object o) {
//        if(o instanceof DateListener) {
//            ((DateListener)o).setUpdatedAt(LocalDateTime.now());
//        }
//    }
//}
