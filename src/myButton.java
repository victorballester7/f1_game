import java.awt.*;
import javax.swing.*;

class myButton extends JButton {
  private Color b = new Color(255, 74, 74);
  private Color bPressed = new Color(161, 39, 39);
  private Color f = new Color(240, 240, 240);
  private Color fPressed = f;
  private static int radius = 20;
  private ImageIcon img, img2;
  private String text, text2;
  private static final int fontSize = 20;
  private static final int imageSize = 30; // assuming they are square
  private int x; // x-coordinate of the center of the button
  private int y; // y-coordinate of the center of the button
  public boolean isPressed = false;

  public myButton(String text, Image img, int x, int y) {
    super(text);
    this.text = text;
    this.img = new ImageIcon(img.getScaledInstance(imageSize, imageSize, Image.SCALE_DEFAULT));
    this.x = x;
    this.y = y;
    setConfig();
  }

  void setConfig() {
    setIcon(img);
    setFont(new Font("Arial", Font.BOLD, fontSize));
    setFocusable(false); // in order to use the keys (not for the button but for the rest of the game). Otherwise the keylistener loses focus to the JButton.
    setBorderPainted(false); // remove painted border when hovering mouse above it
    setContentAreaFilled(false);
    setSize(getPreferredSize().width, getPreferredSize().height);
    System.out.println("width: " + getWidth());
    System.out.println("height: " + getHeight());
    setBounds(x - getWidth() / 2, y - getHeight() / 2, getWidth(), getHeight());
    // setVerticalAlignment(SwingConstants.CENTER);
    // setHorizontalAlignment(SwingConstants.CENTER);
  }

  void addSecondTextImage(String text2, Image img2) {
    this.text2 = text2;
    this.img2 = new ImageIcon(img2.getScaledInstance(imageSize, imageSize, Image.SCALE_DEFAULT));
    ;
  }

  void modify() {
    if (getText() == text)
      setText(text2);
    else
      setText(text);
    if (getIcon() == img)
      setIcon(img2);
    else
      setIcon(img);
  }

  @Override
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
      g.setColor(bPressed); // Background color when button is pressed
      // g.setColor(bPressed); // Background color when button is pressed
      setForeground(fPressed); // Foreground color when button is pressed
    } else {
      g.setColor(b); // Background color when button is NOT pressed
      setForeground(f); // Foreground color when button is NOT pressed
    }
    g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 2 * radius, 2 * radius);

    super.paintComponent(g);
  }

  @Override
  protected void paintBorder(Graphics g) {
    // g.setColor(getForeground());
    // g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13, 13);
  }
}