package client.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enumpackage.CommonWord;
import server.userdb.User;
import server.userdb.UserDAO;
import util.UserInfoPanel;

@SuppressWarnings("serial")

public class JoinMembershipPanel extends UserInfoPanel {

	private final String SIGN_UP = "가입하기";

	private ArrayList<JTextField> userInfos = new ArrayList<JTextField>();

	private User user;

	public JoinMembershipPanel() {

		showFormTitle(CommonWord.SIGN_UP_MEMBERSHIP.getText());

		writeUserInfo();

		showSignUpButton();

	}

	public void writeUserInfo() {

		int y_value = 155;
		for (CommonWord commonWord : CommonWord.values()) {
			if (commonWord.getNum() >= 2 && commonWord.getNum() <= 4) {
				formTitleLabel = new JLabel(commonWord.getText());
				formTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
				formTitleLabel.setBounds(30, y_value, 200, 50);
				add(formTitleLabel);

				userInfoTextField = new JTextField(10);
				userInfoTextField.setBounds(30, y_value + 45, 325, 30);
				add(userInfoTextField);
				y_value += 100;

				if (commonWord.getNum() == 4) {
					userInfoTextField.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							user = new User(userInfos.get(0).getText(), userInfos.get(1).getText(), userInfos.get(2).getText());
							
							UserDAO userDAO = new UserDAO();
							userDAO.insertDB(user);

						}

					});
				}

				userInfos.add(userInfoTextField);
			} else {
				continue;
			}
		}
	}

	private void showSignUpButton() {

		JButton signupButton = showFormButton(SIGN_UP);

		signupButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				user = new User(userInfos.get(0).getText(), userInfos.get(1).getText(), userInfos.get(2).getText());

				UserDAO userDAO = new UserDAO();
				userDAO.insertDB(user);

			}

		});
	}

}