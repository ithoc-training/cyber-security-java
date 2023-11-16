package de.ithoc.training.cybersecurity.csrf;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Controller
public class CsrfClientController {

    @GetMapping("/csrf")
    public String index(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserProfile> emailResponse = restTemplate.getForEntity(
                "http://localhost:8080/email?userId=any-uuid-1",
                UserProfile.class
        );
        model.addAttribute("userId", Objects.requireNonNull(emailResponse.getBody()).getUserId());
        model.addAttribute("email", emailResponse.getBody().getEmail());
        return "csrf/index";
    }

    @PostMapping("/change-email")
    public String changeEmail(@RequestParam String userId, @RequestParam String email, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> emailResponse = restTemplate.getForEntity(
                "http://localhost:8080/email/" + userId + "?newEmail=" + email,
                Void.class
        );

        if (emailResponse.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("message", "E-Mail wurde geändert zu: " + email);
        } else {
            model.addAttribute("message", "Nicht autorisiert");
        }
        return "redirect:/csrf";
    }

}
