package br.mag.lotogenerator;


import br.mag.lotogenerator.ui.UserInterface;
import com.sun.tools.javac.Main;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@SpringBootApplication
public class LotoGeneratorApplication  implements CommandLineRunner{



        public static void main(String[] args) {
            ApplicationContext contexto = new SpringApplicationBuilder(LotoGeneratorApplication.class)
                    .headless(false)
                    .run(args);
        }

        @Override
        public void run(String... args) throws Exception {
            SwingUtilities.invokeLater(() -> {
                UserInterface.executeUI();
            });
        }
}







