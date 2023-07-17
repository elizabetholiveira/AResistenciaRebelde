package visual;

import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class VisualCadastrarRebelde extends JFrame{
    private JPanel cadastroRebelde;
    private JTextField textNome;
    private JTextField textIdade;
    private JTextField textGenero;
    private JTextField textLocal;
    private JButton btnCadastrar;
    private JButton btnVoltar;

    UsuarioService usuarioService = new UsuarioService();

    public VisualCadastrarRebelde() {
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioService.cadastrarRebelde(textNome.getText(), textIdade.getText(), textGenero.getText(), textLocal.getText());
                JOptionPane.showMessageDialog(btnCadastrar, "Cadastro feito com sucesso!");
                dispose();
            }
        });
    }

    public void iniciarCadastro(){
        VisualCadastrarRebelde vcr = new VisualCadastrarRebelde();
        vcr.setContentPane(vcr.cadastroRebelde);
        vcr.setTitle("Cadastrar Novo Rebelde");
        vcr.setBounds(600, 200, 400, 450);
        vcr.setVisible(true);
        vcr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
