package common;

import java.awt.Window;

public class closeWindows {
	public static void closeAll(){
		Window[] windows = Window.getWindows();
		for (Window window : windows) {
			window.dispose();
		}
	}
}
