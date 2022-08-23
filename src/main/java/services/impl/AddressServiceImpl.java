package services.impl;

import services.AddressService;

public class AddressServiceImpl implements AddressService {

    @Override
    public void createAddress(String address) {           // <- Criando novo endereço
    }

    @Override
    public boolean isAddressValid(String address) {       // <- Validando Endereço

        String[] token = address.split(",");        // <- Criando um Array e Separando endereço por virgula.
        System.out.println(token.length);

            String street = token[0].trim();
            String number = token[1].trim();
            String city = token[2].trim();
            String state = token[3].trim();
            String cep = token[4].trim();

            if (token.length < 5 || token.length > 6)         // <- Validando formato do endereço
                return false;                                 // (Valido quando 5 ou 6) campos estiverem preenchidos.

            // Validando Rua (Address)
            if (street.length() < 5 || street.length() > 30)
                return false;

            // Validando numero (Number)
            if (!number.matches("\\d{1,5}"))
                return false;

            // Validando Cidade (City)
            if (city.length() < 3 || city.length() > 30)
                return false;

            // Validando Estado (State)
            if (state.length() != 2)
                return false;

            // Validando CEP (Postal Code)
            if (cep.length() != 8)
                return false;

            // Validando Complemento (Address 2)
            if (token.length == 6 && token[5].length() > 30)
                return false;

            return true;
    }

    private boolean streetValidator(String street){
        return street == null || street.length() < 5 || street.length() > 30;
    }
}
