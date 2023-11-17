package de.ithoc.training.cybersecurity.csrf;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class CsrfServerController {

    private final Map<String, UserProfile> userProfiles = new HashMap<>();

    public CsrfServerController() {
        final UserProfile anyUser1 = new UserProfile();
        anyUser1.setUserId("any-uuid-1");
        anyUser1.setEmail("oho.1@example.com");
        userProfiles.put(anyUser1.getUserId(), anyUser1);

        final UserProfile anyUser2 = new UserProfile();
        anyUser2.setUserId("any-uuid-2");
        anyUser2.setEmail("oho.2@example.com");
        userProfiles.put(anyUser2.getUserId(), anyUser2);
    }

    @GetMapping("/email/{userId}")
    public ResponseEntity<?> changeEmail(@PathVariable String userId,
                                         @RequestParam("newEmail") String newEmail) {

        final UserProfile userProfile = userProfiles.get(userId);
        if(userProfile == null) {
            return ResponseEntity.ok("Invalid user profile");
        }
        userProfile.setEmail(newEmail);

        return ResponseEntity.ok(userProfile);
    }

    @GetMapping("/email")
    public ResponseEntity<?> getEmail(@RequestParam String userId) {

        return ResponseEntity.ok(userProfiles.get(userId));
    }

}
