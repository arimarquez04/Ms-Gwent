package com.gwent.bff.dto.response;

import org.springframework.http.HttpStatus;

public class GenericResponseDTO<T> {

    private String serviceProcedencia;
    private Integer status;
    private T data;

    public GenericResponseDTO(String serviceProcedencia, Integer status, T data) {
        this.serviceProcedencia = serviceProcedencia;
        this.status = status;
        this.data = data;
    }

    public String getServiceProcedencia() {
        return serviceProcedencia;
    }

    public void setServiceProcedencia(String serviceProcedencia) {
        this.serviceProcedencia = serviceProcedencia;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
