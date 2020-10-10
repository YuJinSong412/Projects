package client.frame;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import util.ColorSet;
import util.CommonWord;
import util.MainPanelButton;
import util.UseImageFile;


public class MainPanel extends JPanel {

  private Image img = UseImageFile.getImage("resources//logoicon.png");

  private JLabel logoImgLabel;

  private MainPanelButton signUpButton;

  private MainPanelButton loginButton;

  public static MainFrame frame;


  public MainPanel(MainFrame frame) {

    MainPanel.frame = frame;

    setBackground(ColorSet.talkBackgroundColor);
    setLayout(null);

    showLogo();

    moveSignUpPanel();

    moveLogoPanel();
  }

  private void showLogo() {

    logoImgLabel = new JLabel(new ImageIcon(img));
    logoImgLabel.setBounds(95, 90, 200, 200);
    add(logoImgLabel);
  }

  private void moveSignUpPanel() {

    signUpButton = new MainPanelButton(CommonWord.SIGN_UP_MEMBERSHIP.getText());
    signUpButton.setBounds(30, 370, 330, 35);
    signUpButton.setOpaque(true);
    add(signUpButton);
    signUpButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        JoinMembershipPanel c = new JoinMembershipPanel();
        MainPanel.frame.change(c);

      }

    });
  }

  private void moveLogoPanel() {

    loginButton = new MainPanelButton(CommonWord.LOGIN.getText());
    loginButton.setBounds(30, 420, 330, 35);
    loginButton.setOpaque(true);
    add(loginButton);
    loginButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        LoginPanel loginPanel = new LoginPanel();
        MainPanel.frame.change(loginPanel);
      }

    });
  }

}
