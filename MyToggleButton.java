import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.*;

public class MyToggleButton extends JFrame {

    private static final long serialVersionUID = 1L;
	 ImageIcon spaceIcon = createImageIcon("blank.gif", "mine");
	 ImageIcon flagIcon = createImageIcon("flagIcon.gif", "flagged");
    private Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
    private Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");
    private Icon warnIcon = UIManager.getIcon("OptionPane.warningIcon");

    public MyToggleButton() {
        final JToggleButton toggleButton = new JToggleButton();
        toggleButton.setBorderPainted(false);
        toggleButton.setBorder(null);
        toggleButton.setFocusable(false);
        toggleButton.setMargin(new Insets(0, 0, 0, 0));
        toggleButton.setContentAreaFilled(false);
        toggleButton.setIcon((errorIcon));
        toggleButton.setSelectedIcon(infoIcon);
        //toggleButton.setRolloverIcon((infoIcon));
        //toggleButton.setPressedIcon(warnIcon);
        toggleButton.setDisabledIcon(warnIcon);
        toggleButton.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                    if (toggleButton.isEnabled()) {
                        toggleButton.setEnabled(false);
                    } else {
                        toggleButton.setEnabled(true);
                    }
                }
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        add(toggleButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyToggleButton t = new MyToggleButton();
            }
        });
    }
}