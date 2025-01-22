package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lessons")
@ToString
@EqualsAndHashCode(callSuper = true)
public class Lesson extends BaseEntity<Long> {

    private String lessonName;
    private int util;
    private int capacity;
private LocalDateTime startLessonTime;
private Long lessonNumber;
@ManyToOne
private Teacher teacher;
@OneToMany(mappedBy = "lesson")
@ToString.Exclude
List<StudentLesson> studentLessons;
}
