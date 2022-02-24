package com.addressbookservice.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {

    @NotEmpty(message="First name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee firstName is Invalid")
    private String firstName;

    @NotEmpty(message="Last name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee lastName is Invalid")
    private String lastName;

    @NotNull(message="Email cant be empty")
//    @Pattern(regexp = "^[\\w+-]+(\\.[\\w-]+)*@[^_\\W]+(\\.[^_\\W]+)?(?=(\\.[^_\\W]{3,}$|\\.[a-zA-Z]{2}$)).*$", message = "Please enter a valid email id")
    private String email;

    @NotNull(message="Phone number cant be empty")
    private long phoneNumber;

    @NotNull(message="city cant be empty")
    private String city;

    @NotNull(message="State cant be empty")
    private String state;

//    @NotEmpty(message="Zip code cant be empty")
    private Integer zip;

}
