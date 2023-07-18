package visual;

import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualRemoverCadastro extends JFrame {
    private JTextField textidRemover;
    private JButton btnRemover;
    private JButton btnVoltar;
    private JPanel removerRebelde;

    UsuarioService usuarioService = new UsuarioService();

public VisualRemoverCadastro() {
    btnRemover.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            usuarioService.removerRebelde(textidRemover.getText());
            JOptionPane.showMessageDialog(btnRemover, "Cadastro removido com sucesso!");
            dispose();
        }
    });

    btnVoltar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
}

    public void iniciarRemocao(){
        VisualRemoverCadastro vrc = new VisualRemoverCadastro();
        vrc.setContentPane(vrc.removerRebelde);
        vrc.setTitle("Remover Cadastro");
        vrc.setBounds(600, 200, 400, 200);
        vrc.setVisible(true);
        vrc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
