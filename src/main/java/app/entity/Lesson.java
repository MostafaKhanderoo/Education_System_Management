package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;
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
    @Size(min = 1,max = 3,message = "util lesson must be have 1 to 3 ")
    private int util;
    @Size(min = 10,max = 40)
    private int capacity;
private LocalDateTime startLessonTime;

private Long lessonNumber;
@ManyToOne
private Teacher teacher;
@OneToMany(mappedBy = "lesson")
@ToString.Exclude
List<StudentLesson> studentLessons;
}
