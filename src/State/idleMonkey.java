package State;

import Function.Wonderland;
import Function.Monkey;
import java.awt.event.KeyEvent;

public class idleMonkey extends changeState {

	private idleMonkey idleMonkey;
	public idleMonkey() {
	}

	public idleMonkey getInstance() {
		return idleMonkey;
	}
	@Override
	public changeState KeyReleased(Monkey monkey, KeyEvent event) {
		int key = event.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            monkey.setmonkeypropogate_y(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            monkey.setmonkeypropogate_y(0);
        }
        if (key == KeyEvent.VK_LEFT) {
            monkey.setmonkeypropogate_x(0);
        }
        if (key == KeyEvent.VK_RIGHT) {
            monkey.setmonkeypropogate_x(0);
        }
		return new idleMonkey();
	}

	@Override
	public changeState keyPressed(Monkey monkey,KeyEvent event) {
		 int key = event.getKeyCode();
	        if (key == KeyEvent.VK_UP) {
	        	
	            monkey.setmonkeypropogate_y(-Wonderland.STEP_SIZE); monkey.setmonkeypropogate_x(0);
	        }

	        if (key == KeyEvent.VK_DOWN) {
	        	monkey.setmonkeypropogate_y(Wonderland.STEP_SIZE); monkey.setmonkeypropogate_x(0);
	        }		
	        if (key == KeyEvent.VK_LEFT) {
	            monkey.setmonkeypropogate_x(-Wonderland.STEP_SIZE); monkey.setmonkeypropogate_y(0);
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	        	monkey.setmonkeypropogate_x(Wonderland.STEP_SIZE); monkey.setmonkeypropogate_y(0);
	            
	        }
	        monkey.move_Monkey();		
	        return new moveMonkey();
	}


}
