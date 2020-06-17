package com.avito.controllers.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPage {

    @RequestMapping("/")
    String getMainPage() {
        return "index";
    }

}
