package com.source.formapp.helper;

import com.source.formapp.dtos.FormDTO;
import com.source.formapp.dtos.ParagraphDTO;
import com.source.formapp.enums.QueryType;
import com.source.formapp.persistence.Form;
import com.source.formapp.persistence.FormQuery;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FormTranslator {

    public Form toEntity(FormDTO formRequestDTO, String creatorEmail) {
        Form form = new Form();
        form.setFormTitle(formRequestDTO.getFormTitle());
        form.setCreatedBy(creatorEmail);
        form.setVersion(1);
        form.setCreatedOn(new Date(System.currentTimeMillis()));
        form.setIsAccepting(formRequestDTO.getIsAccepting());
        addFormQueriesListToForm(form,formRequestDTO);
        return form;
    }

    public FormDTO toFormDTO(Form form) {
        FormDTO formDTO = new FormDTO();
        formDTO.setFormTitle(form.getFormTitle());
        formDTO.setIsAccepting(form.getIsAccepting());

        List<FormQuery> paragraphFormQueries = form.getFormQueryList().stream().filter(fq -> fq.getQueryType().equals(QueryType.paragraph)).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(paragraphFormQueries)){
            List<ParagraphDTO> paragraphDTOList = new ArrayList<>();
            paragraphFormQueries.forEach(pq -> {
                ParagraphDTO paragraphDTO = new ParagraphDTO();
                paragraphDTO.setQuestion(pq.getQuestion());
                paragraphDTO.setIsRequired(pq.getIsRequired());
                paragraphDTOList.add(paragraphDTO);
            });
            formDTO.setParagraphDTOs(paragraphDTOList);
        }
        return formDTO;
    }

    private void addFormQueriesListToForm(Form form, FormDTO formRequestDTO) {
        formRequestDTO.getParagraphDTOs().forEach(paragraphDTO -> {
            FormQuery formQuery = new FormQuery();
            formQuery.setQueryType(QueryType.paragraph);
            formQuery.setQuestion(paragraphDTO.getQuestion());
            formQuery.setIsRequired(paragraphDTO.getIsRequired());
            form.addFormQuery(formQuery);
        });
    }
}
