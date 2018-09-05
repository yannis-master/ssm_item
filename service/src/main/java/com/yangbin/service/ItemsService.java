package com.yangbin.service;

import com.yangbin.domain.Items;

import java.util.List;

public interface ItemsService {
    List<Items> queryItems();

    Items findItemsById(Integer id);

    void updateItems(Items items);
}
