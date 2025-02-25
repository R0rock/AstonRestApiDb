package com.example.service;

import com.example.dto.AddressDTO;
import com.example.entity.Address;
import com.example.mapper.AddressMapper;
import com.example.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public /*class*/interface AddressService {
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private AddressMapper addressMapper;
//
//    public AddressDTO save(AddressDTO addressDTO) {
//        Address address = addressMapper.toEntity(addressDTO);
//        return addressMapper.toDto(addressRepository.save(address));
//    }
//}
AddressDTO save(AddressDTO addressDTO);
}