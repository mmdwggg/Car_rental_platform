package RentCar;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Clear {

    public static void clear() throws AWTException{
        Robot r = new Robot();
        r.mousePress(InputEvent.BUTTON3_MASK); // 按下鼠标右键
        r.mouseRelease(InputEvent.BUTTON3_MASK); // 释放鼠标右键
        r.keyPress(KeyEvent.VK_CONTROL); // 按下Ctrl键
        r.keyPress(KeyEvent.VK_R); // 按下R键
        r.keyRelease(KeyEvent.VK_R); // 释放R键
        r.keyRelease(KeyEvent.VK_CONTROL); // 释放Ctrl键
        r.delay(500);
    }
}
