package ru.ajana.service.template.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@ResponseBody
@RequestMapping(path = "/v1", produces = APPLICATION_JSON_VALUE)
public class ServiceController {
}
