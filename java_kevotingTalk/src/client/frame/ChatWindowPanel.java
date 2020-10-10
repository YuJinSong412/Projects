package client.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import server.Message;
import server.userDB.UserDAO;
import util.ColorSet;
import util.UseImageFile;

public class ChatWindowPanel extends JPanel {

  JTextArea textArea;

  JButton sendButton;

  static JTextArea textArea2;

  static JTextPane jtp;

  static Style style;

  static StyleContext context;

  static StyledDocument document;

  // Image img = UseImageFile.getImage("resources\\picture.png");
  Image img = UseImageFile.getImage("resources//folder.png");


  private String panelName;
  
  public ChatWindowPanel(ImageIcon imageIcon, String friendName) {

	panelName = friendName;
	  
    setBackground(ColorSet.talkBackgroundColor);
    setLayout(null);

    JLabel label = new JLabel(imageIcon);
    label.setOpaque(true);
    label.setText(friendName);
    label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
    label.setBounds(0, 0, 400, 80);


    label.setBackground(Color.WHITE);
    add(label);

    textArea = new JTextArea(20, 20);
    JScrollPane scroller = new JScrollPane(textArea);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scroller.setBounds(0, 500, 321, 65);
    add(scroller);


    JButton imgButton2 = new JButton(new ImageIcon(img));
    imgButton2.setBackground(ColorSet.talkBackgroundColor);
    Border emptyBorder2 = BorderFactory.createEmptyBorder();
    imgButton2.setBorder(emptyBorder2);
    imgButton2.setFocusPainted(false);
    imgButton2.setBounds(0, 460, 60, 40);


    add(imgButton2);
    imgButton2.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter =
            new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);

        int ret = chooser.showOpenDialog(null);
        if (ret != JFileChooser.APPROVE_OPTION) {
          JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
          return;
        }

        String filePath = chooser.getSelectedFile().getAbsolutePath();
        textArea.setText(filePath);

      }

    });


    context = new StyleContext();
    document = new DefaultStyledDocument(context);
    jtp = new JTextPane(document);
    jtp.setBackground(ColorSet.talkBackgroundColor);
    jtp.setEditable(false);
    JScrollPane scroller2 = new JScrollPane(jtp);
    scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scroller2.setBounds(0, 80, 389, 380);
    add(scroller2);


    sendButton = new JButton("전송");
    sendButton.setBackground(ColorSet.messageSendButtonColor);
    sendButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
    sendButton.setFocusPainted(false);
    sendButton.setBounds(320, 500, 68, 65);
    add(sendButton);
    sendButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        String messageType = textArea.getText().contains("/Users/") ? "file" : "text";

        Message message =
            new Message(UserDAO.username, textArea.getText(), LocalTime.now(), messageType, friendName);

        UserDAO.clientSocket.send(message);

        textArea.setText("");
      }

    });

  }



public static void displayText(Message message) { 

//	    if (UserDAO.username.equals(message.getSendUserName())) {
//	        ChatWindowPanel.rightPrint(message.getSendTime().format(DateTimeFormatter.ofPattern("aHH:mm"))
//	            + "  <" + message.getSendUserName() + ">");
//	        if (message.getMessageType().equals("file")) {
//	          ChatWindowPanel.imgRightPrint(message.getSendComment());
//	        } else {
//	          ChatWindowPanel.rightPrint(message.getSendComment());
//	        }
//	      } else {
//	        ChatWindowPanel.leftPrint(message.getSendTime().format(DateTimeFormatter.ofPattern("aHH:mm"))
//	            + "  <" + message.getSendUserName() + ">");
//
//	        if (message.getMessageType().equals("file")) {
//	          ChatWindowPanel.imgLeftPrint(message.getSendComment());
//	        } else {
//	          ChatWindowPanel.leftPrint(message.getSendComment());
//	        }
//	      }
	    
	  //송유진상단바 이름이랑 sendUserName이 같으면 또 된다.
	  
	  if (UserDAO.username.equals(message.getSendUserName())) {
	        ChatWindowPanel.rightPrint(message.getSendTime().format(DateTimeFormatter.ofPattern("aHH:mm"))
	            + "  <" + message.getSendUserName() + ">");
	        if (message.getMessageType().equals("file")) {
	          ChatWindowPanel.imgRightPrint(message.getSendComment());
	        } else {
	          ChatWindowPanel.rightPrint(message.getSendComment());
	        }
	      }
	  
	  
	  for(ChatWindowPanel chatName : FriendListPanel.chatPanelName) {
		  if(chatName.panelName.equals(message.getSendUserName())) {
			  
			        ChatWindowPanel.leftPrint(message.getSendTime().format(DateTimeFormatter.ofPattern("aHH:mm"))
			            + "  <" + message.getSendUserName() + ">");

			        if (message.getMessageType().equals("file")) {
			          ChatWindowPanel.imgLeftPrint(message.getSendComment());
			        } else {
			          ChatWindowPanel.leftPrint(message.getSendComment());
			        }
			      
		  }
	  }

  }


  public void paint(Graphics g) {

    super.paint(g);
    Graphics2D g2 = (Graphics2D) g;
    Line2D lin = new Line2D.Float(0, 81, 400, 81);
    g2.draw(lin);

    Graphics2D g3 = (Graphics2D) g;
    Line2D lin2 = new Line2D.Float(0, 458, 400, 458);
    g3.draw(lin2);
  }

  private static void imgRightPrint(String sendComment) {

    Image imgFile = UseImageFile.getImage(sendComment);
    Image imgResize = imgFile.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);

    StyledDocument doc2 = (StyledDocument) jtp.getDocument();
    Style style2 = doc2.addStyle("StyleName", null);
    StyleConstants.setIcon(style2, new ImageIcon(imgResize));
    try {
      doc2.insertString(doc2.getLength(), "invisible text" + "\n", style2);
    } catch (BadLocationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void imgLeftPrint(String sendComment) {

    Image imgFile = UseImageFile.getImage(sendComment);
    Image imgResize = imgFile.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);

    StyledDocument doc2 = (StyledDocument) jtp.getDocument();
    Style style2 = doc2.addStyle("StyleName", null);
    StyleConstants.setIcon(style2, new ImageIcon(imgResize));
    try {
      doc2.insertString(doc2.getLength(), "invisible text" + "\n", style2);
    } catch (BadLocationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void rightPrint(String string) {

    try {

      SimpleAttributeSet right = new SimpleAttributeSet();
      StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
      document.setParagraphAttributes(document.getLength(), document.getLength() + 1, right, true);
      document.insertString(document.getLength(), string + "\n", right);

    } catch (BadLocationException e) {
      e.printStackTrace();
    }
  }

  private static void leftPrint(String string) {

    try {
      SimpleAttributeSet left = new SimpleAttributeSet();
      StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
      document.setParagraphAttributes(document.getLength(), document.getLength() + 1, left, true);
      document.insertString(document.getLength(), string + " \n", left);
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
  }
}


/*
 * Java Swing 객체중에 하나인 JLable의 경우 배경색을 설정하면 효과가 적용되지 않는다. 이는 JLabel의 배경색이 기본적으로 투명이기 때문이다.
 * 
 * jlabel.setOpaque(true);//Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다. jlabel.setBackgroud(Color.pink);
 * 
 * 위와 같이 배경색 설정 이전에 Opaque값을 true로 설정해주어야 한다. [출처] JLabel의 배경색 설정하기|작성자 독행소년
 * 
 */