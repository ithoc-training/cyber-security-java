package de.ithoc.training.cybersecurity.ssrf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class UrlCheckController {

    @GetMapping("/ssrf")
    public String home() {

        return "ssrf/home";
    }


    @PostMapping("/check")
    public String check(@RequestParam("url") String url, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String content;
        try {
            content = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            content = "Error: " + e.getMessage();
        }

        model.addAttribute("content", content);

        return "ssrf/url-check";
    }

}