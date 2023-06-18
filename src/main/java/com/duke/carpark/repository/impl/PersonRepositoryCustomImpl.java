package com.duke.carpark.repository.impl;

import com.duke.carpark.entity.Person;
import com.duke.carpark.filters.PersonFilter;
import com.duke.carpark.repository.PersonRepositoryCustom;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
    @Autowired
    EntityManagerFactory emf;

    public List<Person> findPersonsByFilter(PersonFilter filter) {
        if (filter.isEmpty()) {
            return Collections.emptyList();
        }
        String sql = " select p from Person p where 1=1 "
                + (filter.getFirstName() == null ? "" : "and p.firstName = :firstName ")
                + (filter.getSurname() == null ? "" : "and p.surname = :surname ")
                + (filter.getPatronymic() == null ? "" : "and p.patronymic = :patronymic ")
                + (filter.getBirthDate() == null ? "" : "and p.birthDate = :birthDate ")
                + (filter.getMinAgeDate() == null ? "" : "and p.birthDate <= :minAgeDate ")
                + (filter.getMaxAgeDate() == null ? "" : "and p.birthDate >= :maxAgeDate ")
                + (filter.getMinStartDrivingDate() == null ? "" : "and p.startDrivingDate <= :minExperience ")
                + (filter.getMaxStartDrivingDate() == null ? "" : "and p.startDrivingDate >= :maxExperience ");

        final var em = emf.createEntityManager();
        final var query = em.createQuery(sql, Person.class);

        if (filter.getFirstName() != null) {
            query.setParameter("firstName", filter.getFirstName());
        }
        if (filter.getSurname() != null) {
            query.setParameter("surname", filter.getSurname());
        }
        if (filter.getPatronymic() != null) {
            query.setParameter("patronymic", filter.getPatronymic());
        }
        if (filter.getBirthDate() != null) {
            query.setParameter("birthDate", filter.getBirthDate());
        }
        if (filter.getMinAgeDate() != null) {
            query.setParameter("minAgeDate", filter.getMinAgeDate());
        }
        if (filter.getMaxAgeDate() != null) {
            query.setParameter("maxAgeDate", filter.getMaxAgeDate());
        }
        if (filter.getMinStartDrivingDate() != null) {
            query.setParameter("minExperience", filter.getMinStartDrivingDate());
        }
        if (filter.getMaxStartDrivingDate() != null) {
            query.setParameter("maxExperience", filter.getMaxStartDrivingDate());
        }
        return query.getResultList();
    }
}
