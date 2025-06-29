package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bancoform extends JFrame {
    private JTextArea textArea1;
    private JButton transferenciaButton;
    private JButton salirButton;
    private JButton depositoButton;
    private JButton retiroButton;
    private JPanel PanelBanco;
    private JLabel saldo;
    private JLabel nombreUsuario;
    private double saldo1 = 1000.00;

    public Bancoform(String usuario) {
        setTitle("Banco - Bienvenido");
        setContentPane(PanelBanco);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        nombreUsuario.setText("Cliente: " + usuario);
        actualizarSaldo();
        //Icono de transferencia
        ImageIcon icono = new ImageIcon("src/Iconos/transferir-dinero.png");
        Image img = icono.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(img);
        transferenciaButton.setIcon(iconoEscalado);
        //Retiro
        ImageIcon icono1 = new ImageIcon("src/Iconos/retiro-de-dinero.png");
        Image img1 = icono1.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon dimension = new ImageIcon(img1);
        retiroButton.setIcon(dimension);
        //Deposito
        ImageIcon icono2= new ImageIcon("src/Iconos/donacion.png");
        Image img2 = icono2.getImage().getScaledInstance(24,24, Image.SCALE_SMOOTH);
        ImageIcon dimension2 = new ImageIcon(img2);
        depositoButton.setIcon(dimension2);



        transferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String destinatario = JOptionPane.showInputDialog("Nombre del destinatario:");
                String monto1 = JOptionPane.showInputDialog("Monto a transferir:");
                if (destinatario != null && monto1 != null) {
                    try {
                        double monto = Double.parseDouble(monto1);
                        if (monto <= saldo1 && monto > 0) {
                            saldo1 -= monto;
                            actualizarSaldo();
                            agregarHistorial("Transferencia a " + destinatario + " por $" + monto);
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError();
                    }
                }
            }
        });
        depositoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
                if (input != null) {
                    try {
                        double monto = Double.parseDouble(input);
                        if (monto > 0) {
                            saldo1 += monto;
                            actualizarSaldo();
                            agregarHistorial("Depósito: +$" + monto);
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError();
                    }
                }
            }
        });
        retiroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el monto a retirar:");
                if (input != null) {
                    try {
                        double monto = Double.parseDouble(input);
                        if (monto <= saldo1 && monto > 0) {
                            saldo1 -= monto;
                            actualizarSaldo();
                            agregarHistorial("Retiro: -$" + monto);
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError();
                    }
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void actualizarSaldo() {
        saldo.setText("Saldo: $" + String.format("%.2f", saldo1));
    }

    private void agregarHistorial(String texto) {
        textArea1.append(texto + "\n");
    }
    private void mostrarError() {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
    }
}

