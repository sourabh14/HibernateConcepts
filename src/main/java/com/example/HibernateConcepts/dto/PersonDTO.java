package com.example.HibernateConcepts.dto;

import java.util.List;

import com.example.HibernateConcepts.entity.person.Address;
import com.example.HibernateConcepts.entity.person.DebitCard;
import com.example.HibernateConcepts.entity.person.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private Long id;
    private String name;
    private Address address;
    private String passportName;
    private List<DebitCard> debitCardList;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.address = person.getAddress();
        this.passportName = person.getPassport().getName();
        this.debitCardList = person.getDebitCard();
    }
}
