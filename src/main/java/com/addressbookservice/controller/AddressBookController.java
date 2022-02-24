package com.addressbookservice.controller;


import com.addressbookservice.dto.AddressBookDTO;
import com.addressbookservice.dto.ResponseDTO;
import com.addressbookservice.model.AddressBookData;
import com.addressbookservice.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {


    @Autowired
    private AddressBookService addressBookService;

    /**
     * Get all data
     * @return list of address book information from DB in JSON format
     */

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> listOfContact = null;
        listOfContact = addressBookService.getAddressBookData();
        ResponseDTO respDTO = new ResponseDTO("Get List of Address Book Data", listOfContact);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     * Get  specific through id passed as variable address from address book
     *
     * @return information with same Id in JSON format
     */

    @GetMapping("/getBy/{Id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable int Id) {
        AddressBookData adressBookData = null;
        adressBookData = addressBookService.getAddressBookDataById(Id);
        ResponseDTO respDTO = new ResponseDTO("Get Address Book data For Specific Id", adressBookData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     * create record
     * @apiNote accepts the  data in JSON format and stores it in DB
     * @param addressBookDTO - represents object of AddressBookDTO class
     * @return accepted address information in JSON format
     */

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData newContact = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("New Contact Added in AddressBook ", newContact);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     * update  record data by id
     * @apiNote accepts the address book data in JSON format and updates the address having same Id from database
     * @param Id - represents addressBook id
     * @param addressBookDTO - represents object of AddressBookDto class
     * @return	updated address information in JSON format
     */

    @PutMapping(path = "/update/{Id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@Valid @PathVariable("Id") int Id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData updateContact = addressBookService.updateAddressBookData(Id, addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Address Book Data for: ", updateContact);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     * delete records from database
     * @apiNote accepts the Id and deletes the data of that specific from DB
     * @return Id and Acknowledgment message
     */

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("Id") int Id) {
        addressBookService.deleteAddressBookData(Id);
        ResponseDTO respDTO = new ResponseDTO("Deleted Address Book Data ", Id);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }
}

