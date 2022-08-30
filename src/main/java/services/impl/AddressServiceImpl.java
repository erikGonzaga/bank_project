package services.impl;

import models.Address;
import repositories.AddressRepository;
import services.AddressService;

import java.util.Optional;

public class AddressServiceImpl implements AddressService {
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createAddress(Address address) {           // <- Criando novo endereço
    return addressRepository.createAddress(address);
    }

    private final AddressRepository addressRepository;

    @Override
    public Optional<Address> buildAddress(String address) {           // <- Validando Endereço

        String[] token = address.split(",");            // <- Criando um Array e Separando endereço por virgula.
        System.out.println(token.length);

            String street = token[0].trim();                  // Removendo espaços, no inicio e no fim.
            String number = token[1].trim();
            String city = token[2].trim();
            String state = token[3].trim();
            String cep = token[4].trim();
            String compl = "";

            if (token.length < 5 || token.length > 6)            // <- Validando formato do endereço
                return Optional.empty();                         // (Valido quando 5 ou 6) campos estiverem preenchidos.

            // Validando Rua (Street)
            if (street.length() < 5 || street.length() > 30)
                return Optional.empty();

            // Validando numero (Number)                         // Regex: Caso seja menor que 0 e maior que 5 (false)
            if (!number.matches("\\d{1,5}"))
                return Optional.empty();

            // Validando Cidade (City)
            if (city.length() < 3 || city.length() > 30)
                return Optional.empty();

            // Validando Estado (State)
            if (state.length() != 2)                             // Estados possuem somente duas siglas
                return Optional.empty();

            // Validando CEP (Postal Code)                      // Ceps nunca serão diferentes de 8 digitos
            if (cep.length() != 8)
                return Optional.empty();

            // Validando Complemento (Address 2)
            if (token.length == 6 && token[5].length() > 30)
                return Optional.empty();                        /* podem haver ou não complementos, se houver será igual a
                                                                6 e a qtd de char não poderá ser maior que 30, */

            Address addressObj = new Address();
            addressObj.setAddress(street);
            addressObj.setHouseNumber(number);
            addressObj.setSecondAddress(compl);
            addressObj.setCity(city);
            addressObj.setState(state);
            addressObj.setCep(Integer.parseInt(cep));

            return Optional.of(addressObj);                     // <- Quando válido é adicionado a addressObj
    }

    private boolean streetValidator(String street){
        return street == null || street.length() < 5 || street.length() > 30;
    }
}
