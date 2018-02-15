package org.mannayakasha.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home Controller
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String index(Model model) {
        return "Hello, Pavel!";
    }
}
