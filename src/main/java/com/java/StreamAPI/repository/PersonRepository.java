package com.java.StreamAPI.repository;

import com.java.StreamAPI.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    private ArrayList<Person> persons = new ArrayList<>(List.of(
            new Person("Vinh", "Vietnam", 28),
            new Person("Lan", "Vietnam", 24),
            new Person("John", "USA", 27),
            new Person("Lee", "China", 67),
            new Person("Kim", "Korea", 22),
            new Person("Long", "Vietnam", 18),
            new Person("Jungho", "Korea", 19),
            new Person("Tian", "China", 80),
            new Person("Clara", "USA", 40),
            new Person("Mikura", "Japan", 27),
            new Person("Sony", "Japan", 29),
            new Person("Xiang", "China", 78),
            new Person("Peter", "France", 18),
            new Person("Haloy", "Malaysia", 20),
            new Person("Magie", "Malaysia", 32)
    ));


    public List<Person> getAll() {
        return persons;
    }

    // Tìm những người có quốc tịch Việt Nam sử dụng forEach
    public List<Person> findPeopleFromVietnam() {
        List<Person> personVietnam = new ArrayList<>();
        persons.stream().forEach(person -> {
            if(person.getCountry().equals("Vietnam")) {
                personVietnam.add(person);
            }
        });
        return  personVietnam;
    }
    // Tìm những người có cùng quóc tịch sử dụng collect GroupingBy()
    public Map<String, List<Person>> findPeopleFromContry() {
        return
        persons.stream().collect(Collectors.groupingBy(person -> person.getCountry()));
    }

    // Chuyển name of Person thành Uppercase sử dụng map()
    public  List<String> convertNameToUppercase() {
        return persons.stream().map(person -> person.getName())
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
    }
    // Lấy người có số tuổi  > 30 sử dụng Filter và tên có lớn hơn 4 kí tự sử dụng filter()
    public List<Person> personOld30AndName4() {
        return persons.stream()
                .filter(person -> person.getAge() >= 30)
                .filter(person -> person.getName().length()>=4)
                .collect(Collectors.toList());
    }

    // Lấy ra 4 người có số tuổi lớn hơn 30 sử dụng limit
    public List<Person> getFourPersonOle30() {
        return persons.stream()
                .filter(person -> person.getAge() >= 30)
                .limit(4)
                .collect(Collectors.toList());
    }

}
