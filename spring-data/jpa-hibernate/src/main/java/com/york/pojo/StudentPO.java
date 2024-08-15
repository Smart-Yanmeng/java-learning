package com.york.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_number")
    private Long studentNumber;
}
