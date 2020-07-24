package com.example.state_machine_demo.dto;

import java.util.List;

public class ActionState {

    private String state;

    private List<OperationDto> operationList;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<OperationDto> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<OperationDto> operationList) {
        this.operationList = operationList;
    }
}
