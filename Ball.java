package ReviewCreateBallRectStar;

import java.awt.*;

public class Ball {
    // คุณสมบัติของลูกบอล
    public int R, G, B, Size;
    public Vector pos, vel;

    // Constructor
    // กำหนดค่าเริ่มต้นให้กับลูกบอลเมื่อสร้างลูกใหม่
    public Ball () {
        // random สีของลูกบอล
        R = (int)(Math.random()*255);
        G = (int)(Math.random()*255);
        B = (int)(Math.random()*255);
        // random ขนาดลูกบอล
        Size = (int)(Math.random()*100);
        // random ตำเเหน่ง
        pos = new Vector ((int)(Math.random()*500)
                , (int)(Math.random()*500));
        // random ความเร็ว
        vel = new Vector ((int)(Math.random()*5-5)
                , (int)(Math.random()*5-5));
    }
    // method
    // วาด
    public void draw (Graphics g) {
        g.setColor(new Color(R, G, B, 200));
        g.fillOval((int)(pos.x), (int)(pos.y), Size, Size);
    }
    // เคลื่อนที่
    public void move () {
        pos = pos.add(vel);
        // ขอบขวา
        if (pos.x + Size > 500) {
            pos.x = 500 - Size;
            vel.x *= -1; // เปลี่ยนทิศทางของบอล
        }
        // ขอบซ้าย
        if (pos.x < 0) {
            pos.x = 0; // กำหนดตำเเหน่งให้กลับมาอยู่ในจุดเริ่มต้นแกน x
            vel.x *= -1;
        }
        // ขอบบน
        if (pos.y + Size > 500) {
            pos.y = 500 - Size;
            vel.y *= -1; // เปลี่ยนทิศทาง
        }
        // ขอบล่าง
        if (pos.y < 0) {
            pos.y = 0;
            vel.y *= -1;
        }
    }
}
