package com.example.sampleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.Map;

@Schema(description = "Generic API Response")
public class ApiResponse<T> implements ResponseDTO<T> {
    @Schema(description = "Indicates if the operation was successful", example = "true")
    private Boolean success;

    @Schema(description = "The actual results/data")
    private T results;

    @Schema(description = "Error messages if any")
    private Map<String, Object> errors;

    @Schema(description = "Warning messages if any")
    private Map<String, Object> warnings;

    @Schema(description = "Information messages")
    private List<String> infoMessages;

    @Schema(description = "Success messages")
    private List<String> successMessages;

    public ApiResponse() {
    }

    public ApiResponse(Boolean success, T results) {
        this.success = success;
        this.results = results;
    }

    public ApiResponse(Boolean success, T results, Map<String, Object> errors,
            Map<String, Object> warnings, List<String> infoMessages,
            List<String> successMessages) {
        this.success = success;
        this.results = results;
        this.errors = errors;
        this.warnings = warnings;
        this.infoMessages = infoMessages;
        this.successMessages = successMessages;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public T getResults() {
        return results;
    }

    @Override
    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public Map<String, Object> getErrors() {
        return errors;
    }

    @Override
    public void setErrors(Map<String, Object> errors) {
        this.errors = errors;
    }

    @Override
    public Map<String, Object> getWarnings() {
        return warnings;
    }

    @Override
    public void setWarnings(Map<String, Object> warnings) {
        this.warnings = warnings;
    }

    @Override
    public List<String> getInfoMessages() {
        return infoMessages;
    }

    @Override
    public void setInfoMessages(List<String> infoMessages) {
        this.infoMessages = infoMessages;
    }

    @Override
    public List<String> getSuccessMessages() {
        return successMessages;
    }

    @Override
    public void setSuccessMessages(List<String> successMessages) {
        this.successMessages = successMessages;
    }
}