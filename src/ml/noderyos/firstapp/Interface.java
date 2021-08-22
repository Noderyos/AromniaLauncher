package ml.noderyos.firstapp;

import fr.theshark34.openlauncherlib.external.ExternalLaunchProfile;
import fr.theshark34.openlauncherlib.external.ExternalLauncher;
import fr.theshark34.openlauncherlib.minecraft.*;
import net.chris54721.openmcauthenticator.OpenMCAuthenticator;
import net.chris54721.openmcauthenticator.Profile;
import net.chris54721.openmcauthenticator.responses.AuthenticationResponse;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;

public class Interface extends JPanel {

    private BufferedImage back;
    private Image img;

    URI discord = new URI("https://discord.gg/K4YMHWpp");
    URI site = new URI("http://www.aromnia.fr");
    URI youtube = new URI("https://www.youtube.com/channel/UC_ByA1nQObxDYXlsjHXASOQ");

    public Interface() throws Exception{
        setBorder(new CompoundBorder(
                new LineBorder(new Color(0,0,0,0)),
                new EmptyBorder(0, 0, 250, 0)));
        try {
            back = ImageIO.read(getClass().getResource("/ml/noderyos/firstapp/ressources/l.png"));
            img = back.getScaledInstance(720, 720, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setOpaque(false);
        setLayout(null);
        JButton closeButton = new JButton();
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        closeButton.setBounds(630,140,50,50);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        add(closeButton);

        JButton websiteButton = new JButton();
        websiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    java.awt.Desktop.getDesktop().browse(site);
                }catch (IOException ex){ }
            }
        });
        websiteButton.setBounds(522,118,50,50);
        websiteButton.setOpaque(false);
        websiteButton.setContentAreaFilled(false);
        websiteButton.setBorderPainted(false);
        add(websiteButton);

        JButton discordButton = new JButton();
        discordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    java.awt.Desktop.getDesktop().browse(discord);
                }catch (IOException ex){ }
            }
        });
        discordButton.setBounds(90,220,50,50);
        discordButton.setOpaque(false);
        discordButton.setContentAreaFilled(false);
        discordButton.setBorderPainted(false);
        add(discordButton);

        JButton youtubeButton = new JButton();
        youtubeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    java.awt.Desktop.getDesktop().browse(youtube);
                }catch (IOException ex){ }
            }
        });
        youtubeButton.setBounds(158,120,50,50);
        youtubeButton.setOpaque(false);
        youtubeButton.setContentAreaFilled(false);
        youtubeButton.setBorderPainted(false);
        add(youtubeButton);

        JTextField usernameField;
        usernameField = new JTextField() {
            @Override public void setBorder(Border border) {
            }
        };
        usernameField.setBounds(265,265, 190,30);
        usernameField.setOpaque(false);
        usernameField.setFont(new Font("Courrier",Font.PLAIN,20));
        usernameField.setForeground(Color.WHITE);
        add(usernameField);

        JTextField passwordField;
        passwordField = new JTextField() {
            @Override public void setBorder(Border border) {
            }
        };
        passwordField.setBounds(290,355, 190,30);
        passwordField.setOpaque(false);
        passwordField.setFont(new Font("Courrier",Font.PLAIN,20));
        passwordField.setForeground(Color.WHITE);
        add(passwordField);

        JButton runButton = new JButton();
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    new StartMinecraft(usernameField.getText(), passwordField.getText());
                }catch (Exception error){
                    System.out.println(error);
                }
            }
        });
        runButton.setBounds(275,457,190,50);
        runButton.setOpaque(false);
        runButton.setContentAreaFilled(false);
        runButton.setBorderPainted(false);
        add(runButton);

    }
    @Override
    public Dimension getPreferredSize() {
        return img == null ? new Dimension(200, 200) : new Dimension(720, 720);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(img, 0, 0, this);
            g2d.dispose();
        }
    }
}
