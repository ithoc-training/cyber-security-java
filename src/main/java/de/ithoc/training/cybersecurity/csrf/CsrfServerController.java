package de.ithoc.training.cybersecurity.csrf;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
public class CsrfServerController {

    private final Map<String, UserProfile> userProfiles = new HashMap<>();
    private final Map<String, String> sessionStore = new HashMap<>();

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

    @PostMapping("/token")
    public ResponseEntity<?> token(@RequestBody TokenRequest request) {

        String userId = request.getUserId();
        UserProfile userProfile = userProfiles.get(userId);
        if(userProfile == null) {
            return ResponseEntity.ok("Invalid user profile");
        }

        String userToken = UUID.randomUUID().toString();
        sessionStore.put(userProfile.getUserId(), userToken);

        return ResponseEntity.ok(new TokenResponse(userToken));
    }

    @PutMapping("/email/{userId}")
    public ResponseEntity<?> changeEmail(@PathVariable String userId,
                                         @RequestBody ChangeEmailRequestBody requestBody) {

        String userToken = sessionStore.get(requestBody.getUserId());
        if (userToken == null || !userToken.equals(requestBody.getUserToken())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        final UserProfile userProfile = userProfiles.get(userId);
        if(userProfile == null) {
            return ResponseEntity.ok("Invalid user profile");
        }
        userProfile.setEmail(requestBody.getNewEmail());

        return ResponseEntity.ok(userProfile);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfile> getProfile(@RequestParam String userId) {

        return ResponseEntity.ok(userProfiles.get(userId));
    }

}
