package ReviewCreateBallRectStar;

import java.awt.*;

public class Star {
    // Attributes ของ ดาว
    public int R, G, B, Size;
    public Vector pos, vel;

    // Constructor
    // เมื่อ new object constructor จะทำงานอัตโนมัติ
    public Star () {
        R = (int)(Math.random()*255);
        G = (int)(Math.random()*255);
        B = (int)(Math.random()*255);
        Size = (int)(Math.random()*100);

        pos = new Vector ((int)(Math.random()*500)
                , (int)(Math.random()*500));
        vel = new Vector ((int)(Math.random()*5-5)
                , (int)(Math.random()*5-5));
    }
    // Method
    // ดาวที่วาดได้
    public void draw (Graphics g) {
        g.setColor(new Color(R, G, B));
        int n = 5;
        int [] x = new int [n * 2];
        int [] y = new int [n * 2];

        double outerRadius = Size; // รัศมีใหญ่ (ปลายแหลม)
        double innerRadius = Size / 2.5; // รัศมีเล็ก (ปลายมน)

        for (int i = 0; i < n * 2; i++) {
            double angle = Math.PI / n * i; // คำนวณมุม
            double radius = (i % 2 == 0) ? outerRadius : innerRadius; // สลับระหว่างรัศมีใหญ่และเล็ก

            x[i] = (int) (pos.x + radius * Math.cos(angle)); // คำนวณพิกัด x
            y[i] = (int) (pos.y + radius * Math.sin(angle)); // คำนวณพิกัด y
        }
        g.fillPolygon(x, y, n*2);
    }
    public void move () {
        pos = pos.add(vel);
        // ขอบขวา
        if (pos.x + Size > 500) {
            pos.x = 500 - Size;
            vel.x = vel.x * -1;
        }
        // ขอบซ้าย
        if (pos.x < 0) {
            pos.x = 0;
            vel.x *= -1;
        }
        // ขอบบน
        if (pos.y + Size > 500) {
            pos.y = 500 - Size;
            vel.y *= -1;
        }
        // ขอบล่าง
        if (pos.y < 0) {
            pos.y = 0;
            vel.y *= -1;
        }
    }
}
