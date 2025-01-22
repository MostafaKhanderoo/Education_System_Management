package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Student_Lesson")
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentLesson extends BaseEntity<Long> {

    @ManyToOne
    private Student student;
    @ManyToOne
    private Lesson lesson;

    private Double score;

}
