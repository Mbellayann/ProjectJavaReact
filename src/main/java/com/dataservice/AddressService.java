package com.dataservice;

import com.datamodel.Address;
import com.repository.IAdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService{
    @Autowired
    IAdressRepository iAdressRepository;

    @Override
    public Address saveAddress(Address address) {
        return iAdressRepository.save(address);
    }
}
