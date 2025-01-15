package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
}
