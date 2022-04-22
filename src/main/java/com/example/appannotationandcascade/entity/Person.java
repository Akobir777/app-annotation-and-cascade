package com.example.appannotationandcascade.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value ={"brithDate","fullName"})
@Where(clause = "brith_date is not null")
public class Person {
    @Id
    @GeneratedValue
    private Integer id;

    private String fullName;

    @OrderBy(value = "city asc,city desc ")
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;

//    @JsonIgnoreProperties
    private LocalDate brithDate;
    @Transient
    private Integer age;

    public Integer getAge() {
        if (brithDate == null)
            return 0;
        return Period.between(brithDate,LocalDate.now()).getYears();
    }
    public Integer getCountFullNameLetters(){
        return fullName !=null?fullName.length():0;
    }
}
