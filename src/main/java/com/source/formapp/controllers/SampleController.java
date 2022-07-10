package com.source.formapp.controllers;

import com.source.formapp.dtos.*;
import com.source.formapp.enums.Status;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form/test")
public class SampleController {

    @GetMapping("/ping")
    public StatusResponse<String> basicController() {
        StatusResponse<String> response = new StatusResponse<>();
        response.setResponseCode(200);
        response.setData("pong");
        response.setStatus(Status.SUCCESS);

        return response;
    }
}
