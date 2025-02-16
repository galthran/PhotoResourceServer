package com.jarosinski.ws.api.photoresourceserver.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRest {

    private String userId;
    private String userFirstName;
    private String userLastName;
}
