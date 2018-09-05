package com.yangbin.serviceImpl;

import com.yangbin.dao.ItemsDao;
import com.yangbin.domain.Items;
import com.yangbin.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;
    @Override
    public List<Items> queryItems() {
        List<Items> itemsList =  itemsDao.queryItems();
        return itemsList;
    }

    @Override
    public Items findItemsById(Integer id) {
        Items items = itemsDao.findItemsById(id);
        return items;
    }

    @Override
    public void updateItems(Items items) {
        itemsDao.updateItems(items);
    }
}
