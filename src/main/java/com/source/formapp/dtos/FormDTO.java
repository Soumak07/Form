package com.source.formapp.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FormDTO {
    String formTitle;
    Boolean isAccepting;
    List<ParagraphDTO> paragraphDTOs;
    List<MultiChoiceDTO> multiChoiceDTOs;
}
