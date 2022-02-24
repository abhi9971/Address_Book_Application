package com.addressbookservice.service;

import com.addressbookservice.dto.AddressBookDTO;
import com.addressbookservice.exception.AddressBookException;
import com.addressbookservice.model.AddressBookData;
import com.addressbookservice.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * @return list of contact information from DB
     */

    public List<AddressBookData> getAddressBookData() {
        return (List<AddressBookData>) addressBookRepository.findAll();
    }

    /**
     * @param Id - represents contact id
     * @return contact information with same Id
     */

    public AddressBookData getAddressBookDataById(int Id) {
        return addressBookRepository.findById(Id).orElseThrow(() -> new AddressBookException("Employee with employee Id"+Id
                +"  does not exist!!"));
    }

    /**
     * accepts the contact data in the form of AddressBookDTO and stores it in DB
     * @param addressBookDTO - represents object of AddressBookDto class
     * @return accepted contact details information in JSON format
     */


    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBook = null;
        addressBook = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBook);
    }

    /**
     * accepts the contact data in the form of AddressBookDTO and
     * updates the contact details having same Id from database
     * @param Id - represents contact details for same id
     * @param addressBookDTO- represents object of AddressBookDTO class
     * @return	updated Address Book information in JSON format
     */

    public AddressBookData updateAddressBookData(int Id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(Id);
        addressBookData.updateAddressBook(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    /**accepts the contact Id and deletes the data of that contact from DB
     * @param Id - represents contact id
     * @return Id and Acknowledgment message
     */


    public void deleteAddressBookData(int Id) {
        AddressBookData addressBookData = this.getAddressBookDataById(Id);
        addressBookRepository.delete(addressBookData);
    }
}
