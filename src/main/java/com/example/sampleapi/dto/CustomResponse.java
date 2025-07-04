package com.example.sampleapi.dto;

import java.util.Map;

public class CustomResponse<T> {
    private int status;
    private Map<String, Object> headers;
    private T result;

    public CustomResponse() {
    }

    public CustomResponse(int status, Map<String, Object> headers, T result) {
        this.status = status;
        this.headers = headers;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}