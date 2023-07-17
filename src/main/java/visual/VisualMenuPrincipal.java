package visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                VisualCadastrarRebelde vcr = new VisualCadastrarRebelde();
                vcr.iniciarCadastro();
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
