package com.yangbin.controller;

import com.yangbin.domain.Items;
import com.yangbin.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class ItemsController {
        @Autowired
        private ItemsService itemsService;
        @RequestMapping("queryItems")
        public String queryItems(Model model){
            List<Items> itemsList = itemsService.queryItems();
            System.out.println(itemsList);
            model.addAttribute("itemsList",itemsList);
            return "itemsList";
        }
        @RequestMapping("/editItems")
        public String editItems(Integer id,Model model){
            Items items = itemsService.findItemsById(id);
            model.addAttribute("items",items);
            return "editItems";
        }




    @RequestMapping("/updateItems")
        public String updateItems(Items items, HttpServletRequest request, MultipartFile upload,Model model) throws IOException {
            //数据封装不进去 别的都做了！！！

            itemsService.updateItems(items);
        System.out.println(items);
            //指定上传位置
            String path = request.getSession().getServletContext().getRealPath("/uploads/");
            //判断：该路径是否存在
            File file = new File(path);
            if (!file.exists()){
                //创建该文件夹
                file.mkdirs();
            }
            //获取上传文件的名字
            String filename = upload.getOriginalFilename();
            //把文件名称设置成唯一值 uuid
            String uuid = UUID.randomUUID().toString().replace("-", "");
            filename = uuid + "_" + filename;
            //完成文件上传
            upload.transferTo(new File(path,filename));
            return "redirect:/items/itemsList";
        }

}
