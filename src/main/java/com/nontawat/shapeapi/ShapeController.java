package com.nontawat.shapeapi;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // สำคัญ: เพื่อให้หน้าเว็บ Flutter คุยกับ Java ได้
public class ShapeController {

    // จำลองฐานข้อมูลไว้ในหน่วยความจำ
    private Map<Integer, String> shapeDb = new HashMap<>() {{
        put(0, "วงกลม");
        put(3, "สามเหลี่ยม");
        put(4, "สี่เหลี่ยม");
    }};

    // สำหรับให้ Flutter ส่งจำนวนด้านมาถาม (GET)
    @GetMapping("/predict")
    public Map<String, String> predict(@RequestParam int sides) {
        String result = shapeDb.getOrDefault(sides, "ไม่รู้จักตัวตน");
        return Map.of("name", result);
    }

    // สำหรับให้ Flutter ส่งข้อมูลใหม่มาสอน (POST)
    @PostMapping("/learn")
    public Map<String, String> learn(@RequestBody Map<String, Object> payload) {
        // แปลงค่าให้ปลอดภัย ป้องกัน Error ถ้าส่งค่ามาผิดประเภท
        int sides = Integer.parseInt(payload.get("sides").toString());
        String name = payload.get("name").toString();
        
        shapeDb.put(sides, name);
        return Map.of("status", "เรียนรู้แล้ว: " + name);
    }
}