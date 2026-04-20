package com.nontawat.shapeapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Integer> {
    // ถูกต้องครับ ไม่ต้องเขียนอะไรเพิ่ม Spring จัดการให้เอง
}