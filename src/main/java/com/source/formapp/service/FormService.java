package com.source.formapp.service;

import com.source.formapp.persistence.Form;

public interface FormService {
    Form saveForm(Form form);
    Form fetchFormById(Long formId);
}
