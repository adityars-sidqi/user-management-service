package com.adityarahman.usermanagementservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nik")
    private int nik;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birt_date")
    private Date birthDate;

    @Column(name = "religion")
    @Enumerated(EnumType.STRING)
    private Religion religion;

    @Column(name = "occupation")
    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "neighbourhood_id")
    private Long neighbourhoodId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
