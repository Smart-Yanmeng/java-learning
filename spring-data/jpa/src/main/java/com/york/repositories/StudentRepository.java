package com.york.repositories;

import com.york.pojo.StudentPO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<StudentPO, Long> {

    @Query("FROM StudentPO WHERE studentName = ?1")
    StudentPO findByStudentName(String studentName);

    List<StudentPO> findByStudentName(String studentName, Pageable pageable);
}
