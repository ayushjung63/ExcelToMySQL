package com.ayush.repo;

import com.ayush.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
