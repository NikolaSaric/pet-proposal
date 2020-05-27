package com.petproposal.petproposal.dto;

public class ResultDto {
    private String animal;
    private Long result;

    public ResultDto() {
    }

    public ResultDto(String animal, Long result) {
        this.animal = animal;
        this.result = result;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}
