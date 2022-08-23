package services.impl;

import services.AddressService;

public class AddressServiceImpl implements AddressService {

    @Override
    public void createAddress(String address) {

    }

    @Override
    public boolean isAddressValid(String address) {
        String[] token = address.split(",");

        if (token.length < 5 || token.length > 6) return false;

        return false;
    }
}
