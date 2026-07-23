package com.anupam.ecom_application.dto;

import com.anupam.ecom_application.model.UserRole;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private AddressDTO address;
    private UserRole role;
}
