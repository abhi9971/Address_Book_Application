package com.addressbookservice.service;

import com.addressbookservice.dto.AddressBookDTO;
import com.addressbookservice.model.AddressBookData;

import java.util.List;

/**
 * Here we create an interface having some methods which we implement in AddressBookService .

 * getAddressBookData:- in this we retrieve all records from database.

 * getAddressBookDataById:-in this we retrieve records from database for particular id.

 * createAddressBookData:-in this we create data and store that data into our database.

 * updateAddressBookData:-in this method we take id of a particular contact and then passes the info which we have to update and then store in db

 * deleteAddressBookData:-take id of an contact and delete that record from the database.
 */
public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int Id);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(int empId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int empId);


}
