package visual;

import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VisualLogin extends JFrame{
    private JButton btnEntrar;
    private JTextField textID;
    private JPanel login;
    UsuarioService usuarioService = new UsuarioService();

    public VisualLogin() {
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioService.identificarCadastro(textID.getText())){
                    JOptionPane.showMessageDialog(btnEntrar, "ID encontrado!");
                    String sql = "UPDATE login SET id_login = '" + textID.getText() + "' WHERE id_login NOTNULL;";
                    try {
                        usuarioService.getStatement().executeUpdate(sql);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    VisualMenuPrincipal vmp = new VisualMenuPrincipal();
                    vmp.iniciarMenu();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(btnEntrar, "ID incorreto");
                }
            }
        });
    }

    public void iniciarLogin(){
        VisualLogin vl = new VisualLogin();
        vl.setContentPane(vl.login);
        vl.setTitle("Tela de Login");
        vl.setBounds(600, 200, 300, 150);
        vl.setVisible(true);
        vl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
