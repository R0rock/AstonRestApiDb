//package com.example.service;
//
//public class AddressServiceImpl {
//}
package [com.example.service](com.example.service);

import [com.example.dto.AddressDTO](com.example.dto.AddressDTO);
import [com.example.entity.Address](com.example.entity.Address);
import [com.example.mapper.AddressMapper](com.example.mapper.AddressMapper);
import [com.example.repository.AddressRepository](com.example.repository.AddressRepository);
import [org.springframework.beans.factory.annotation.Autowired](org.springframework.beans.factory.annotation.Autowired);
import [org.springframework.stereotype.Service](org.springframework.stereotype.Service);

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        Address address = [addressMapper.toEntity(addressDTO)](addressMapper.toEntity(addressDTO));
        return [addressMapper.toDto(addressRepository.save(address))](addressMapper.toDto(addressRepository.save(address)));
    }
}