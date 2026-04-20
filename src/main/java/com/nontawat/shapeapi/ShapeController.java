package com.nontawat.shapeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Collections;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ShapeController {

    @Autowired
    private ShapeRepository shapeRepository;

    @GetMapping("/predict")
    public Map<String, String> predict(@RequestParam int sides) {
        String name = shapeRepository.findById(sides)
                .map(Shape::getName)
                .orElse("ไม่รู้จักรูปทรงนี้");
        return Collections.singletonMap("name", name);
    }

    @PostMapping("/learn")
    public Map<String, String> learn(@RequestBody Shape newShape) {
        shapeRepository.save(newShape); // บันทึกลง Supabase ทันที!
        return Collections.singletonMap("status", "success");
    }
    
    @GetMapping("/all")
    public List<Shape> getAll() {
        return shapeRepository.findAll(); // ดึงข้อมูลทั้งหมดมาดู
    }
}