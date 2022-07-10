package com.source.formapp.dtos;

import lombok.Data;

import java.util.List;

@Data
public class MultiChoiceDTO extends QueryDTO{
    String question;
    List<String> choices;
}
