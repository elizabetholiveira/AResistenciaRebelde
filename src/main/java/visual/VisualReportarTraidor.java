package visual;

import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisualReportarTraidor extends JFrame{
    private JTextField textField1;
    private JButton btnReportar;
    private JButton btnVoltar;
    private JPanel reportarTraidor;

public VisualReportarTraidor() {

    setContentPane(reportarTraidor);
    setTitle("Reportar Traidor");
    setBounds(600, 200, 400, 200);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    btnVoltar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });

    btnReportar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            UsuarioService usuarioService = new UsuarioService();
            String sql = "SELECT * FROM rebeldes WHERE id_rebeldes = '" + textField1.getText() + "'";
            try {
                ResultSet resultSet1 = usuarioService.getStatement().executeQuery(sql);
                if (!resultSet1.next()) {
                    JOptionPane.showMessageDialog(btnReportar, "ID não encontrado!");
                }
                resultSet1 = usuarioService.getStatement().executeQuery(sql);
                while (resultSet1.next()) {
                    if (resultSet1.getInt("reportes") == 3){
                        JOptionPane.showMessageDialog(btnReportar, "Esse ID já está cadastrado como traidor!");
                    }
                    if (resultSet1.getInt("reportes") < 2) {
                        String sql2 = "UPDATE rebeldes SET reportes = " + (resultSet1.getInt("reportes") + 1) + " WHERE id_rebeldes = '" + textField1.getText() + "'";
                        usuarioService.getStatement().executeUpdate(sql2);
                        System.out.println("Reporte adicionado!");
                        JOptionPane.showMessageDialog(btnReportar, "Reporte adicionado!");
                    }
                    if (resultSet1.getInt("reportes") == 2) {
                        String sql2 = "UPDATE rebeldes SET reportes = " + (resultSet1.getInt("reportes") + 1) + " WHERE id_rebeldes = '" + textField1.getText() + "'";
                        usuarioService.getStatement().executeUpdate(sql2);
                        System.out.println("Esse cadastro recebeu 3 reportes e agora é considerado um traidor!");
                        JOptionPane.showMessageDialog(btnReportar, "Esse ID recebeu 3 reportes e agora é considerado um traidor!");
                        String sql3 = "UPDATE rebeldes SET status = 'Traidor' WHERE id_rebeldes = '" + textField1.getText() + "'";
                        usuarioService.getStatement().executeUpdate(sql3);
                    }
                }
            } catch(SQLException ex){
                //Botei como comentário porque por algum motivo mesmo tudo funcionando perfeitamente, tanto as mensagens, quanto o banco de dados. Ele ficava me retornendo uma exceção. (sem parar o programa)
                //e.printStackTrace();
            }
            dispose();
        }
    });
}
}
