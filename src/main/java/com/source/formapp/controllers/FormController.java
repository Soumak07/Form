package com.source.formapp.controllers;

import com.source.formapp.dtos.FormDTO;
import com.source.formapp.dtos.StatusResponse;
import com.source.formapp.enums.Status;
import com.source.formapp.manager.FormManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form")
public class FormController {

    private FormManager formManager;

    public FormController(FormManager formManager) {
        this.formManager = formManager;
    }

    @PostMapping("/submit")
    public StatusResponse<FormDTO> submitBasicForm(@RequestBody FormDTO formDTO, @RequestHeader String email) {
        StatusResponse<FormDTO> response = new StatusResponse<>();
        FormDTO formCreated = null;
        try {
            formCreated = formManager.submitForm(formDTO, email);
        }catch (Exception e){
            System.out.println("Exception occured while creating form " +e);
            response.setResponseCode(500);
            response.setStatus(Status.FAILED);
        }
        response.setResponseCode(200);
        response.setData(formCreated);
        response.setStatus(Status.SUCCESS);
        return response;
    }

    @GetMapping(value = "/fetch/{id}", produces = "application/json")
    public StatusResponse<FormDTO> fetchForm(@PathVariable("id") Long id){
        StatusResponse<FormDTO> response = new StatusResponse<>();
        FormDTO formDTO = null;
        try {
            formDTO = formManager.fetchForm(id);
        }catch (Exception e){
            response.setResponseCode(500);
            response.setStatus(Status.FAILED);
            return response;
        }
        response.setResponseCode(200);
        response.setData(formDTO);
        response.setStatus(Status.SUCCESS);
        return response;
    }
}
