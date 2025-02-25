package com.example.repository;

import com.example.entity.Address;
import com.example.repository.AddressRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressRepositoryImpl implements AddressRepositoryCustom {
    @Autowired
    private AddressRepository addressRepository;

    public void customMethod() {
        // Логика метода
    }
}