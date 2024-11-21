package ReviewCreateBallRectStar;

import javax.swing.*;
import java.awt.*;

// JPanel class มักใช้กับการจัดการและแสดงผลกราฟฟิคบนจอ

public class Gui extends JPanel {

    Ball [] balls; // ประกาศตัวแปร array balls ของ object Ball
    Rect [] rects; // ประกาศตัวแปร array rects ของ object Rect
    Star [] stars; // ประกาศตัวแปร array stars ของ object Star
    // Constructor
    public Gui () {
        balls = new Ball [10]; // สร้าง array
        for (int i=0; i<balls.length; i++) {
            balls[i] = new Ball (); // สร้างลูกบอลลูกใหม่ในแต่ละตำเเหน่งของ array
        }
        rects = new Rect [10];
        for (int i=0; i<rects.length; i++) {
            rects[i] = new Rect ();
        }
        stars = new Star [10];
        for (int i=0; i<stars.length; i++) {
            stars[i] = new Star ();
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i=0; i<balls.length; i++) {
                        balls[i].move();
                    }
                    for (int i=0; i<rects.length; i++) {
                        rects[i].move();
                    }
                    for (int i=0; i<stars.length; i++) {
                        stars[i].move();
                    }
                    repaint();
                }
            }
        });
        t.start();

                // สร้าง Frame
                JFrame frame = new JFrame("Ball Star Rect Bounced");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    // method paint
    @Override
    public void paint (Graphics g) {
        super.paint(g);
        for (int i=0; i<balls.length; i++) {
            balls[i].draw(g);
        }
        for (int i=0; i<rects.length; i++) {
            rects[i].draw(g);
        }
        for (int i=0; i<stars.length; i++) {
            stars[i].draw(g);
        }
    }

    public static void main(String[] args) {
        new Gui ();
    }
}
