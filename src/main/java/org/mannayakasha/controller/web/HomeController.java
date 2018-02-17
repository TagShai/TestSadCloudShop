package org.mannayakasha.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home Controller
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@RestController
@CrossOrigin
public class HomeController {

    @GetMapping("/hello")
    public String index(Model model) {
        return "Hello, Pavel!";
    }

    @GetMapping("/secret")
    public String secretService() {
        return "A secret message";
    }
}
