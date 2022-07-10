package com.source.formapp.dtos;

import com.source.formapp.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusResponse <T>{

    Integer responseCode;
    Status status;
    T data;
}
