package com.adityarahman.usermanagementservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MasterUser {

    @Id
    @GeneratedValue
    private Long id;

    private String nik;
    private String fullName;
    private Gender gender;
    private LocalDate birthDate;
    private Religion religion;
    private Occupation occupation;
    private MaritalStatus maritalStatus;
    private String address;
    private String email;
    private Long neighbourhoodId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MasterUser that = (MasterUser) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
