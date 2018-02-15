package org.mannayakasha.controller.web;

import org.mannayakasha.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home Controller
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@Controller
public class HomeController {

    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        return "Hello, Pavel!";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "Pavel, you are welcome!";
    }
}
