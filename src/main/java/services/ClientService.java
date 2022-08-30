package services;

import models.Client;

import java.util.Optional;

public interface ClientService {

    Optional<Client> validateAndBuildClient(String clientAsString);

    Client createClient(Client client);
}
