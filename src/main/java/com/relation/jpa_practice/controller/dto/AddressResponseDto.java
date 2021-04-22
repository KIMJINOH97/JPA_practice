package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddressResponseDto {
    private String city;
    private String gu;
    private String dong;

    public AddressResponseDto(Address address){
        this.city = address.getCity();
        this.gu = address.getGu();
        this.dong = address.getDong();
    }
}
