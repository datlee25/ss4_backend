package com.example.learning_english.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserScoreId implements Serializable {
    @Column(name = "userId")
    private int userId;
    @Column(name = "exerciseId")
    private int exerciseId;
}