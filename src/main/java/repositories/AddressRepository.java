package repositories;

import models.Address;

public interface AddressRepository {

    // √ Queries a ser inserida √
    String INSERT_ADDRESS_SQL =
    "INSERT INTO address (city, state, address, house_number, cep, address_2) " +
    "VALUES (?,?,?,?,?,?)"; // toda variavel em uma Interface é public static final

    String NEXT_ADDRESS_ID_SQL = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA = 'DB_BANK_SYSTEM' AND TABLE_NAME = 'address'";


    /**
     *
     * @param address dados do endereço que serão salvos no Banco de Dados
     * @return Retorna o id que foi atribuido ao endereço criado.
     *      */

    Address createAddress(Address address);

    Address getAddressId(Long Id);

}
