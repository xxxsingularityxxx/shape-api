package com.nontawat.shapeapi;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // ต้องมีบรรทัดนี้เพื่อให้ Chrome คุยกับ Java ได้ครับ
public class ShapeController {

    private Map<Integer, String> shapeDb = new HashMap<>() {{
        put(0, "วงกลม");
        put(3, "สามเหลี่ยม");
        put(4, "สี่เหลี่ยม");
    }};

    @GetMapping("/predict")
    public Map<String, String> predict(@RequestParam int sides) {
        String result = shapeDb.getOrDefault(sides, "ไม่รู้จักตัวตน");
        return Map.of("name", result);
    }

    @PostMapping("/learn")
    public Map<String, String> learn(@RequestBody Map<String, Object> payload) {
        // เช็กบรรทัดล่างนี้ครับ ห้ามมีคำว่า key: หรือวงเล็บแปลกๆ
        int sides = Integer.parseInt(payload.get("sides").toString());
        String name = payload.get("name").toString(); 
        
        shapeDb.put(sides, name);
        return Map.of("status", "เรียนรู้แล้ว: " + name);
    }
}