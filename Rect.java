package ReviewCreateBallRectStar;

import java.awt.*;

public class Rect {
    public int R, G, B, Size;
    public Vector pos, vel;
    public Rect () {
        R = (int)(Math.random()*255);
        G = (int)(Math.random()*255);
        B = (int)(Math.random()*255);
        Size = (int)(Math.random()*100);

        pos = new Vector ((int)(Math.random()*500)
                , (int)(Math.random()*500));
        vel = new Vector ((int)(Math.random()*5-5)
                , (int)(Math.random()*5-5));
    }

    // method
    public void draw (Graphics g) {
        g.setColor(new Color(R, G, B));
        g.fillRect((int)(pos.x), (int)(pos.y), Size, Size);
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
