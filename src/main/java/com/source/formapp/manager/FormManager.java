package com.source.formapp.manager;

import com.source.formapp.dtos.FormDTO;
import com.source.formapp.dtos.StatusResponse;
import com.source.formapp.exception.FormNotFoundException;
import org.springframework.http.ResponseEntity;

public interface FormManager {
    FormDTO submitForm(FormDTO formDTO, String creatorEmail);
    FormDTO fetchForm(Long id) throws FormNotFoundException;
}
