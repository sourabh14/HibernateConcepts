package com.example.HibernateConcepts.entity.person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)    // One to one unidirectional relationship | Person - Address
    @JoinColumn
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)    // One to one bidirectional relationship | Person - Passport
    @JoinColumn
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL)   // One to many relationship | Person - DebitCard
    @JoinColumn(name="person_id")
    // This will create fk person_id in DebitCard
    // One to many mapping is lazy fetch by default
    private List<DebitCard> debitCard;

    // https://howtodoinjava.com/hibernate/hibernate-many-to-many-mapping/
    // when defining a many-to-many relationship, we should consider using a Set instead of a List
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "person_courses",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "person_email_group_subscriptions",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "email_group_id")
    )
    private Set<EmailGroup> emailGroups = new HashSet<>();

    public void addCourse(Course course) {
        this.getCourses().add(course);
    }



}
