package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AddressResponseDto {
    private String city;
    private String dong;
    private String gu;

    public AddressResponseDto(Address address){
        this.city = address.getCity();
        this.dong = address.getDong();
        this.gu = address.getGu();
    }
}
