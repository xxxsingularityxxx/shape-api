package com.nontawat.shapeapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "shapes") // ชื่อตารางใน Supabase
@Data // ให้ Lombok ช่วยสร้าง Getter/Setter
public class Shape {
    @Id
    private int sides; // จำนวนด้านเป็น Primary Key
    private String name; // ชื่อรูปทรง
}
