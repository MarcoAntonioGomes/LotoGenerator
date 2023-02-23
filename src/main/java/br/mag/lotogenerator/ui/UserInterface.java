package br.mag.lotogenerator.ui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class UserInterface {

    public static void executeUI(){
        JFrame frame = new JFrame("Loto Generator");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(500,300);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Servidor Ligado. Click no Botão abaixo para abrir a aplicação.");
        panel.add(label);
        JButton btnExecutar = new JButton("Executar App");
        btnExecutar.addActionListener(new ButtonClickListener());
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.CENTER, btnExecutar);
        frame.setVisible(true);
    }

}

class ButtonClickListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        URI link = null;
        try {
            link = new URI("http://localhost/");
            Desktop.getDesktop().browse(link);
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
