package com.addressbookservice.model;


import com.addressbookservice.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Address_Book_Service_Application")
public @Data class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String city;
    private String state;
    private long zip;

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBook(addressBookDTO);
    }

    public AddressBookData() {
    }

    public void updateAddressBook(AddressBookDTO addressBookDTO){
        this.firstName=addressBookDTO.getFirstName();
        this.lastName=addressBookDTO.getLastName();
        this.email=addressBookDTO.getEmail();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zip=addressBookDTO.getZip();
    }
}
