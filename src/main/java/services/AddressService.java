package services;

import models.Address;

import java.util.Optional;

public interface AddressService {

    void createAddress(Address address);

    Optional<Address> buildAddress(String address); // Adicionando Optional a construção.

}
