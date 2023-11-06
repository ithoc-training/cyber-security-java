package de.ithoc.training.cybersecurity.ssrf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UrlCheckController {

    @GetMapping("/ssrf")
    public String home() {

        return "ssrf/home";
    }


    @PostMapping("/check")
    public String check(@RequestParam("url") String url, Model model) {

        // TODO Implement me

        return "ssrf/url-check";
    }

}