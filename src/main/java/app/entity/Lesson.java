package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "lessons")
public class Lesson extends BaseEntity<Long> {

    private String lessonName;
    private int util;
    private int capacity;
private LocalDateTime startLessonTime;
}
