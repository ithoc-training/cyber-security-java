package de.ithoc.training.cybersecurity.csrf;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenResponse {

    private String userToken;

    public TokenResponse(String userToken) {
        this.userToken = userToken;
    }

}
