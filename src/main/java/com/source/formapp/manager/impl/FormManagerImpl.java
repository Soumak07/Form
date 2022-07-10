package com.source.formapp.manager.impl;

import com.source.formapp.dtos.FormDTO;
import com.source.formapp.exception.FormNotFoundException;
import com.source.formapp.helper.FormTranslator;
import com.source.formapp.helper.FormValidator;
import com.source.formapp.manager.FormManager;
import com.source.formapp.persistence.Form;
import com.source.formapp.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormManagerImpl implements FormManager {

    private FormValidator formValidator;
    private FormService formService;
    private FormTranslator formTranslator;

    @Autowired
    public FormManagerImpl(FormValidator formValidator, FormService formService, FormTranslator formTranslator) {
        this.formValidator = formValidator;
        this.formService = formService;
        this.formTranslator = formTranslator;
    }

    @Override
    public FormDTO submitForm(FormDTO formRequestDTO, String creatorEmail) {
        Form form = formTranslator.toEntity(formRequestDTO, creatorEmail);
        Form createdForm = formService.saveForm(form);
        return formTranslator.toFormDTO(createdForm);
    }

    @Override
    public FormDTO fetchForm(Long id) throws FormNotFoundException {
        FormDTO formDTO = formTranslator.toFormDTO(formService.fetchFormById(id));
        if (formDTO == null) throw new FormNotFoundException("Form with id " + id + " does not exist!");
        return formDTO;
    }
}
