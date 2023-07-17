package visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualManual extends JFrame{
    private JPanel manual;
    private JTextArea boasVindasAoSistemaTextArea;
    private JButton btnVoltar;

    public VisualManual() {
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void iniciarManual(){
        VisualManual vm = new VisualManual();
        vm.setContentPane(vm.manual);
        vm.setTitle("Manual");
        vm.setBounds(600, 200, 500, 600);
        vm.setVisible(true);
        vm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
