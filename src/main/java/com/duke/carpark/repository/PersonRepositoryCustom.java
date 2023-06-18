package com.duke.carpark.repository;

import com.duke.carpark.entity.Person;
import com.duke.carpark.filters.PersonFilter;

import java.util.List;

public interface PersonRepositoryCustom {
    List<Person> findPersonsByFilter(PersonFilter filter);
}
