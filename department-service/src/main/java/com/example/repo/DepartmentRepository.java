package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>  {

	Department findByDepartmentId(Long id);

}
