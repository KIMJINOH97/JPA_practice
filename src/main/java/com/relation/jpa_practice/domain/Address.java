package com.relation.jpa_practice.domain;

import com.relation.jpa_practice.controller.dto.AddressResponseDto;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Address {
    @Column(name = "city")
    private String city;

    @Column(name = "gu")
    private String gu;

    @Column(name = "dong")
    private String dong;

    public Address(String city, String gu, String dong){
        this.city = city;
        this.gu = gu;
        this.dong = dong;
    }

    public Address(){
    }

    public Address(AddressResponseDto responseDto){
        this.city = responseDto.getCity();
        this.gu = responseDto.getGu();
        this.dong = responseDto.getDong();
    }
}
