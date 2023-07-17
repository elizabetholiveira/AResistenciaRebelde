package visual;

import com.sun.tools.javac.Main;
import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisualMenuPrincipal extends JFrame{
    private JPanel menuPrincipal;
    private JButton btnManual;
    private JButton btnCadastrar;
    private JButton btnRemover;
    private JButton btnReportar;
    private JButton btnRelatorio;
    private JButton btnCadastros;
    private JButton btnInventario;
    private JButton btnCreditos;
    private JButton btnLoja;
    private JButton btnComprar;
    private JButton btnLocal;
    private JButton btnExtra;
    private String id;

    VisualLogin vl = new VisualLogin();
    UsuarioService usuarioService = new UsuarioService();

    public VisualMenuPrincipal() {
        btnManual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisualManual vm = new VisualManual();
                vm.iniciarManual();
            }
        });
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "SELECT id_login FROM login;";
                try {
                    ResultSet resultSet = usuarioService.getStatement().executeQuery(sql);
                    while (resultSet.next()){
                        id = resultSet.getString("id_login");
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                if (usuarioService.identificarStatus(id).equals("Rebelde")) {
                    VisualCadastrarRebelde vcr = new VisualCadastrarRebelde();
                    vcr.iniciarCadastro();
                } else {
                    JOptionPane.showMessageDialog(btnCadastrar, "Traidores não podem cadastrar novos integrantes");
                }
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void iniciarMenu(){
        VisualMenuPrincipal vmp = new VisualMenuPrincipal();
        vmp.setContentPane(vmp.menuPrincipal);
        vmp.setTitle("Menu Principal");
        vmp.setBounds(600, 200, 400, 450);
        vmp.setVisible(true);
        vmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
