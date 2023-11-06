package de.ithoc.training.cybersecurity.rxss;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RxssController {


    @GetMapping("/")
    public String home() {

        return "home";
    }


    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {

        model.addAttribute("query", query);

        return "search";
    }

}
