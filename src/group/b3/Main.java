package group.b3;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System system = new System();
        UIFrame uiFrame = new UIFrame();
        LoginUI loginUI = new LoginUI(system);

        uiFrame.setUI(loginUI);
    }
}
