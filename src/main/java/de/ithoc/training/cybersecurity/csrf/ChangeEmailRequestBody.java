package de.ithoc.training.cybersecurity.csrf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeEmailRequestBody {

    private String userId;
    private String userToken;
    private String newEmail;

}