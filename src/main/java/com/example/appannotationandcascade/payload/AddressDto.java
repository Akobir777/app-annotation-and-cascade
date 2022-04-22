package com.example.appannotationandcascade.payload;

import com.example.appannotationandcascade.entity.Person;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class AddressDto {

    @NotNull
    @Size(min=2,max = 50)
    private String street;

    @NotNull
    @Size(min=2,max = 50)
    private String city;

    @NotNull
    private Integer personId;

}
