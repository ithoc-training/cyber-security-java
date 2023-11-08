package de.ithoc.training.cybersecurity.csrf;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CsrfClientController {

    @GetMapping("/csrf")
    public String index() {

        return "csrf/index";
    }

    @PostMapping("/change-email")
    public String changeEmail(@RequestBody String email, Model model) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Void> emailResponse = restTemplate.getForEntity(
                "http://localhost:8080/email/" + email,
                Void.class
        );

        if (emailResponse.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("message", "E-Mail wurde geändert zu: " + email);
        } else {
            model.addAttribute("message", "Nicht autorisiert");
        }
        return "csrf/result";
    }

}
