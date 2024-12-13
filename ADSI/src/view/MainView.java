package view;

import javax.swing.*;
import java.awt.*;

public class MainView {

    public MainView() {
        // Crear el marco principal
        JFrame frame = new JFrame("Videoclub Manolín");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Configurar el diseño principal
        frame.setLayout(new BorderLayout());

        // Panel superior: Barra de navegación
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        navBar.setBackground(Color.BLACK); // Fondo negro

        JLabel titleLabel = new JLabel("Videoclub Manolín");
        titleLabel.setForeground(new Color(255, 215, 0)); // Dorado
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        navBar.add(titleLabel);

        String[] navItems = {"Inicio", "Quiénes Somos", "Películas", "Contacto"};
        for (String item : navItems) {
            JButton navButton = new JButton(item);
            navButton.setBackground(Color.DARK_GRAY); // Gris oscuro
            navButton.setForeground(new Color(255, 215, 0)); // Dorado
            navButton.setFont(new Font("Arial", Font.PLAIN, 14));
            navButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            navBar.add(navButton);
        }

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBackground(new Color(105, 105, 105)); // Gris oscuro
        loginButton.setForeground(new Color(255, 215, 0)); // Dorado
        loginButton.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton registerButton = new JButton("Registro");
        registerButton.setBackground(new Color(105, 105, 105)); // Gris oscuro
        registerButton.setForeground(new Color(255, 215, 0)); // Dorado
        registerButton.setFont(new Font("Arial", Font.PLAIN, 14));

        navBar.add(loginButton);
        navBar.add(registerButton);

        // Añadir la barra de navegación al marco
        frame.add(navBar, BorderLayout.NORTH);

        // Panel central: Imagen e introducción
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(47, 47, 47)); // Gris oscuro para el fondo del panel

        JLabel welcomeLabel = new JLabel("Bienvenidos a Videoclub Manolín", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        welcomeLabel.setForeground(new Color(255, 215, 0)); // Dorado
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        JLabel descriptionLabel = new JLabel("Descubre las mejores películas al mejor precio. Encuentra tu película ideal con nosotros.", SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        descriptionLabel.setForeground(new Color(255, 215, 0)); // Dorado
        mainPanel.add(descriptionLabel, BorderLayout.CENTER);

        // Imagen de ejemplo desde el paquete "fotitos" con ajuste automático
        ImageIcon clubImage = new ImageIcon(getClass().getResource("/fotitos/videoclub_image.jpg"));
        JLabel imageLabel = new JLabel(clubImage, SwingConstants.CENTER);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Ajustar imagen al tamaño de la ventana
        mainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Image img = clubImage.getImage();
                Image scaledImg = img.getScaledInstance(mainPanel.getWidth(), mainPanel.getHeight() / 2, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImg));
            }
        });

        mainPanel.add(imageLabel, BorderLayout.SOUTH);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Mostrar el marco
        frame.setVisible(true);
    }

}
