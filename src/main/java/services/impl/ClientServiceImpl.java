package services.impl;

import enums.DocumentType;
import enums.PersonType;
import models.Client;
import org.apache.commons.lang3.StringUtils;
import services.ClientService;
import utils.DateUtil;

import java.time.LocalDate;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    @Override
    public Optional<Client> validateAndBuildClient(String clientAsString) {
        String[] token = clientAsString.split(",");                     // <- Criando um Array e Separando endereço por virgula.

        if (token.length != 5)
            return Optional.empty();

        System.out.println(token.length);

        String name = token[0].trim();                                      // Removendo espaços, no inicio e no fim.
        String email = token[1].trim();
        String phone = token[2].trim();
        String document = token[3].trim();
        String dtNascimento = token[4].trim();

        if (StringUtils.isBlank(name))
            return Optional.empty();

        if (StringUtils.isBlank(email) || !email.matches("^(.+)@(.+)$"))
            return Optional.empty();

        if (StringUtils.isBlank(phone) || !phone.matches("\\d{11}"))
            return Optional.empty();

        if (StringUtils.isBlank(document) || document.matches("\\d{11}|\\d{14}"))
            return Optional.empty();

        LocalDate dataNascimento;
        if (StringUtils.isBlank(dtNascimento)) {
            return Optional.empty();
        } else {
            try {
                dataNascimento = DateUtil.stringToLocalDate(dtNascimento, "dd/mm/aaaa");
            } catch (Exception e) {
                return Optional.empty();
            }
        }

        Client client = Client

                .builder()
                .name(name)
                .email(email)
                .document(document)
                .birthdate(dataNascimento)
                .personType(PersonType.PF)
                .documentType(DocumentType.CPF)
                .phone(Integer.parseInt(phone))
                .build();

        return Optional.of(client);
    }

    @Override
    public Client createClient(Client client) {
        return null;
    }
}
