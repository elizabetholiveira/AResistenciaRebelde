package visual;

import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisualVerRelatorio extends JFrame{

    public VisualVerRelatorio() {

        this.setTitle("Ver Relatório");
        this.setSize(230, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        DefaultListModel<String> minhaLista = new DefaultListModel<>();

        UsuarioService usuarioService = new UsuarioService();

        int numRebeldes = 0;
        int numTraidores = 0;

        //Pegar rebeldes
        String sql1 = "SELECT FROM rebeldes WHERE status = 'Rebelde'";
        try{
            ResultSet resultSet = usuarioService.getStatement().executeQuery(sql1);
            while (resultSet.next()){
                numRebeldes += 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        //Pegar traidores
        String sql2 = "SELECT FROM rebeldes WHERE status = 'Traidor'";
        try{
            ResultSet resultSet = usuarioService.getStatement().executeQuery(sql2);
            while (resultSet.next()){
                numTraidores += 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        //Calcular
        int total = numRebeldes + numTraidores;
        double porcentRebeldes = (100 * numRebeldes) / total;
        double porcentTraidores = (100 * numTraidores) / total;

        String linha1 = "Relatório:";
        String linha2 = "Rebeldes: " + porcentRebeldes + "%";
        String linha3 = "Traidores: " + porcentTraidores + "%";

        minhaLista.addElement(linha1);
        minhaLista.addElement(linha2);
        minhaLista.addElement(linha3);

        JList<String> lista = new JList<>(minhaLista);
        lista.setBounds(10, 10, 200, 60);
        lista.setLayoutOrientation(JList.VERTICAL);
        this.add(lista);

        JButton btnVoltar = new JButton("Fechar Aba");
        btnVoltar.setBounds(10, 80, 200, 20);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.add(btnVoltar);

        this.setVisible(true);

    }
}
