package com.example.sampleapi.dto;

import java.util.List;
import java.util.Map;

public interface ResponseDTO<T> {
    Boolean getSuccess();

    void setSuccess(Boolean success);

    T getResults();

    void setResults(T results);

    Map<String, Object> getErrors();

    void setErrors(Map<String, Object> errors);

    Map<String, Object> getWarnings();

    void setWarnings(Map<String, Object> warnings);

    List<String> getInfoMessages();

    void setInfoMessages(List<String> infoMessages);

    List<String> getSuccessMessages();

    void setSuccessMessages(List<String> successMessages);
}