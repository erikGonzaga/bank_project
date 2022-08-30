package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    private long id;
    private Integer cep;
    private String city;
    private String state;
    private String address;
    private String houseNumber;
    private String secondAddress;

}
