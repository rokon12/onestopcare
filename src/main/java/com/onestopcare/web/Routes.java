package com.onestopcare.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Bazlur Rahman Rokon
 * @date 9/30/15.
 */
@Controller
public class Routes {

    @RequestMapping({"/"})
    public String index() {
        return "forward:/index.xhtml";
    }
}
