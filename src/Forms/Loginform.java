package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginform extends JFrame {
    private JTextField usuario;
    private JPasswordField password;
    private JButton ingresarButton;
    private JPanel Login;
    private JLabel usuarioIcono;
    private JLabel contraseñaa;

    public Loginform() {
        setTitle("Inicio de sesión");

        setContentPane(Login);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450,450);
        setLocationRelativeTo(null);
        setVisible(true);

        ImageIcon icono = new ImageIcon("src/Iconos/agregar-usuario.png");
        ImageIcon icono2 = new ImageIcon("src/Iconos/seguro.png");
        Image image = icono.getImage();
        Image image1 = icono2.getImage();

        Image imagenRedimensionada = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon iconoPeque = new ImageIcon(imagenRedimensionada);

        Image dimensiones = image1.getScaledInstance(32,32, image1.SCALE_SMOOTH);
        ImageIcon iconPeque1 = new ImageIcon(dimensiones);

        usuarioIcono.setIcon(iconoPeque);
        contraseñaa.setIcon(iconPeque1);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Usuario = usuario.getText();
                String Contrasena = new String(password.getPassword());

                if (Usuario.equals("cliente123") && Contrasena.equals("clave456")) {
                    new Bancoform(Usuario);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

