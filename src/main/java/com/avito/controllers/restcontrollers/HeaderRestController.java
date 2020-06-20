package com.avito.controllers.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HeaderRestController {

    @GetMapping("/getListCategory")
    public ResponseEntity<Map<String, List<String>>> getListOfCategory() {
        Map<String, List<String>> mapMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("товар");
        list.add("товар");
        list.add("товар");
        list.add("товар");
        list.add("товар");
        mapMap.put("avto", list);
        mapMap.put("settings", list);
        mapMap.put("settings", list);
        mapMap.put("settings", list);
        mapMap.put("property", list);
        return mapMap != null
                ? new ResponseEntity<Map<String, List<String>>>(mapMap, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/avitoNavigation")
    public ResponseEntity<List<String>> getAvitoNavigation() {
        List<String> list = new ArrayList<>();
        list.add("Объявления");
        list.add("Магазины");
        list.add("Бизнес");
        list.add("Бизнес");
        list.add("Помощь");
        return list != null && !list.isEmpty()
                ? new ResponseEntity<List<String>>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
