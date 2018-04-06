package State;

import java.awt.event.KeyEvent;
import Function.Monkey;

public class changeState {
	public changeState KeyReleased(Monkey monkey, KeyEvent event) {
		return this;
	}
	//from idle to movement state
	public changeState keyPressed(Monkey monkey, KeyEvent event) {
		return this;
	}
}
