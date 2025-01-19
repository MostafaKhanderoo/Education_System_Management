package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson extends BaseEntity<Long> {

    private String lessonName;
    private int util;
    private int capacity;
private LocalDateTime startLessonTime;
@ManyToOne
private Teacher teacher;
@ManyToMany
    List<Student> students;
}
