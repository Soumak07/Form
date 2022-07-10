package com.source.formapp.service.impl;

import com.source.formapp.persistence.Form;
import com.source.formapp.repository.FormRepository;
import com.source.formapp.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FormServiceImpl implements FormService {

    private FormRepository formRepository;

    public FormServiceImpl(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @Override
    @Transactional
    public Form saveForm(Form form) {
        Form form1 = formRepository.saveAndFlush(form);
        return form1;
    }

    @Override
    public Form fetchFormById(Long formId) {
        Form form = formRepository.getReferenceById(formId);
        return form;
    }
}
