package com.example.ss2restapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
    private Long id;
    private String title;
    private String description;
    private String priority;
    private User assignedTo;
}
