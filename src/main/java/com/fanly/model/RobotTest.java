package com.fanly.model;

import java.awt.AWTException;
import java.awt.Robot;

import com.sun.glass.events.KeyEvent;

public class RobotTest {
	public static void main(String[] args) {
		try {
			Robot robot = new Robot();
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_1);
			robot.keyPress(KeyEvent.VK_2);
			robot.keyPress(KeyEvent.VK_3);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}