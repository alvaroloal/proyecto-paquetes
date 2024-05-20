package com.salesianostriana.dam.proyectoalvarolorentealman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoalvarolorentealman.exception.ResourceNotFoundException;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Address;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.AddressRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
	
    // Inyecta una instancia de AddressRepository para acceder a las operaciones CRUD
	@Autowired
	private AddressRepository addressRepository;

	public Boolean existsById(Long id) {
		return this.addressRepository.existsById(id);
	}

	public List<Address> getAllAddresses() {
		return this.addressRepository.findAll();
	}
	
	// obtener por id
	public Address getAddressById(Long id) {
		Optional<Address> address = this.addressRepository.findById(id);
		return address.get();
	}

	@Transactional
    public Address createAddress(Address address) {
        if (address.getId() != null && this.addressRepository.existsById(address.getId())) {
            throw new ResourceNotFoundException("Ya existe direccion con este id: " + address.getId());
        }
        return this.addressRepository.save(address);
    }
	
	
	// Actualiza una dirección existente
	@Transactional
	public Address updateAddress(Long id, Address addressDetails) {
		Address addressUpdated = this.getAddressById(id);
		addressUpdated.setFirstName(addressDetails.getFirstName());
		addressUpdated.setLastName(addressDetails.getLastName());
		addressUpdated.setStreet(addressDetails.getStreet());
		addressUpdated.setCity(addressDetails.getCity());
		addressUpdated.setZipCode(addressDetails.getZipCode());
		addressUpdated.setCountry(addressDetails.getCountry());
		addressUpdated.setEmail(addressDetails.getEmail());
		this.addressRepository.save(addressUpdated);
		return addressUpdated;
	}
	
	@Transactional
	public void deleteAddress(Long id) {
		this.addressRepository.deleteById(id);
	}

}
