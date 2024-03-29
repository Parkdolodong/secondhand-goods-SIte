package com.example.Shopping.entity.listener;

import java.time.LocalDateTime;

public interface DateListener {
    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);

    void setUpdatedAt(LocalDateTime updatedAt);
}