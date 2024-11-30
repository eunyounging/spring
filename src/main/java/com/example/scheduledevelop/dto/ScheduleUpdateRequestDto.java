package com.example.scheduledevelop.dto;

public class ScheduleUpdateRequestDto {
    private final String title;
    private final String description;

    public ScheduleUpdateRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
