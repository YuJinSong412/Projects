package client.frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import server.dataCommunication.Message;
import server.userDB.UserDAO;
import util.CommonPanel;
import util.UseImageFile;
import util.UserProfileButton;
import util.enumPackage.CommonWord;

@SuppressWarnings("serial")
public class IndexPanel extends CommonPanel {

	private JLabel jLabel;

	private Image img = UseImageFile.getImage("resources//woman.png");

	public static UserProfileButton userProfileButton;

	public IndexPanel() {

		meanMyProfileTitle(CommonWord.MYPROFILE.getText());

		meanMyProfile();

		meanFriendProfileTitle(CommonWord.FRIEND.getText());

		showFriendList();

	}

	private void meanMyProfileTitle(String text) {

		jLabel = new JLabel(text);
		jLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jLabel.setBounds(30, 80, 200, 30);
		add(jLabel);

	}

	private void meanMyProfile() {

		ImageIcon imageIcon = new ImageIcon(img);
		userProfileButton = new UserProfileButton(imageIcon);
		userProfileButton.setText(UserDAO.username);
		userProfileButton.setBounds(30, 120, 325, 80);
		add(userProfileButton);

		userProfileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (userProfileButton.getText().contains("대화 중..")) {
					// 작동x
				} else {
					userProfileButton.setText(userProfileButton.getText() + "       대화 중..");

					String messageType = "text";

					Message message = new Message(UserDAO.username, UserDAO.username + "님이 입장하였습니다.", LocalTime.now(),
							messageType, UserDAO.username);

					ChatWindowPanel c = new ChatWindowPanel(imageIcon, UserDAO.username);
					new ChatWindowFrame(c, UserDAO.username);

					UserDAO.clientSocket.send(message);
				}

			}

		});
	}

	private void meanFriendProfileTitle(String text) {

		jLabel = new JLabel(text);
		jLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jLabel.setBounds(30, 220, 200, 30);
		add(jLabel);
	}

	private void showFriendList() {

		FriendListPanel jpanel = new FriendListPanel();
		JScrollPane scroller = new JScrollPane(jpanel);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setBounds(30, 250, 325, 300);
		add(scroller);
	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Line2D lin = new Line2D.Float(30, 210, 350, 210);
		g2.draw(lin);
	}
}
