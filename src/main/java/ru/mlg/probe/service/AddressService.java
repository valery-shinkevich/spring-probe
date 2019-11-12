package ru.mlg.probe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mlg.probe.entity.Address;
import ru.mlg.probe.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public void createAddress(Address address){
        addressRepository.save(address);
    }
}

