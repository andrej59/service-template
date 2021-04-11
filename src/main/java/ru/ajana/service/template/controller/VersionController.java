package ru.ajana.service.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер информации по сборке сервиса.
 */
@CrossOrigin
@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class VersionController {

    /** Информация сборки. */
    private final Map<String, Object> versionInfo = new LinkedHashMap<>();


    @Autowired
    public VersionController(BuildProperties buildProperties, GitProperties gitProperties) {
        versionInfo.put("version", buildProperties.getVersion());
        versionInfo.put("gitCommit", gitProperties.getCommitId());
        versionInfo.put("buildDate", buildProperties.getTime().toString());
        versionInfo.put("buildUnixTime", String.valueOf(buildProperties.getTime().getEpochSecond()));
        versionInfo.put("name", buildProperties.getName());
        versionInfo.put("group", buildProperties.getGroup());
    }

    /**
     * Возвращает информацию о сборке.
     *
     * @return информация о сборке.
     */
    @GetMapping(value = "/version")
    public Map<String, Object> version() {
        return versionInfo;
    }
}
