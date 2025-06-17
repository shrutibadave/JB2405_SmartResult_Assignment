package com.LCWD.smart_result.Repository;

import com.LCWD.smart_result.DAO.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepo extends JpaRepository<Marks, Integer> {
}
