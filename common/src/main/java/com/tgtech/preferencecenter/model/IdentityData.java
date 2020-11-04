package com.tgtech.preferencecenter.model;

import lombok.Data;

@Data
public class IdentityData {
    private String customerName;
    private String gender;
    private String phoneNumber;
    private String postalCode;
    private String email;
    private Integer age;
}
