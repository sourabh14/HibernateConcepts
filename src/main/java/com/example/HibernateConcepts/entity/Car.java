package com.example.HibernateConcepts.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Engine engine;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // https://stackoverflow.com/questions/24994440/no-serializer-found-for-class-org-hibernate-proxy-pojo-javassist-javassist
    private Tyre tyre;

}
