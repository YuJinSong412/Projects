package client.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import server.userDB.UserDAO;
import util.JFrameWindowClosingEventHandler;

@SuppressWarnings("serial")
public class ChatWindowFrame extends JFrame {

	private String frameName;

	public ChatWindowFrame(JPanel panel, String frameName) {

		this.frameName = frameName;

		setTitle(UserDAO.username + "의 Chatting");
		setBounds(1200, 250, 400, 600);

		getContentPane().add(panel);

		setVisible(true);

		addWindowListener(new JFrameWindowClosingEventHandler(getFrameName()));
	}

	public String getFrameName() {
		return frameName;
	}

	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}

}
