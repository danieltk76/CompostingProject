package JaymeAlgorithms;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel
{
    private Image backgroundImage;
    public BackgroundPanel(String imagePath)
    {
        backgroundImage = new ImageIcon(imagePath).getImage();

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
