package com.example.HibernateConcepts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "passport")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Passport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    // @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Person person;
}
