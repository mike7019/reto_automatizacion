package testing.page.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MoverMouse implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

// Coordinates of the "Allow" button. You need to replace these with the actual values.
        int x = 285;
        int y = 165;

        robot.mouseMove(x, y);

// Click the "Allow" button.
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

// Sometimes, you might also need to simulate a user pressing "Enter"
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static MoverMouse on(){
        return Instrumented.instanceOf(MoverMouse.class).withProperties();
    }
}
