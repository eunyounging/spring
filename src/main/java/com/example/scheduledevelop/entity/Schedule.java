package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Schedule extends BaseEntity {

    // 할일 제목, 할일 내용, 작성 유저명
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    // 한 명의 사용자가 여러 개의 일정을 만들 수 있다.
    // 사용자가 1, 일정이 N
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }

    public Schedule() {}

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
