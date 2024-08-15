package com.york.repositories;

import com.york.pojo.StudentPO;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentSpecificationRepository extends
        PagingAndSortingRepository<StudentPO, Long>,
        JpaSpecificationExecutor<StudentPO> {


}
