package de.ithoc.training.cybersecurity.csrf;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CsrfServerController {

    private final UserProfile userProfile = new UserProfile();

    @GetMapping("/email/{newEmail}")
    public ResponseEntity<?> changeEmail(@PathVariable("newEmail") String newEmail) {

        userProfile.setEmail(newEmail);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/email")
    public ResponseEntity<?> getEmail() {

        return ResponseEntity.ok(userProfile.getEmail());
    }

}
