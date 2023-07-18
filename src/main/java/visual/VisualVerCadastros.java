package visual;

import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisualVerCadastros extends JFrame{

    UsuarioService usuarioService = new UsuarioService();
public VisualVerCadastros() {

    this.setTitle("Cadastros existentes");
    this.setSize(800, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);

    DefaultListModel<String> minhaLista = new DefaultListModel<>();


        UsuarioService usuarioService = new UsuarioService();
        String sql = "select * from rebeldes order by id_rebeldes ASC;";
        try {
            ResultSet resultSet = usuarioService.getStatement().executeQuery(sql);
            while (resultSet.next()){
                String mensagem =  "ID: " + resultSet.getInt("id_rebeldes") + " | Nome: "
                        + resultSet.getString("nome") + " | Idade: "
                        + resultSet.getInt("idade") + " | Gênero: "
                        + resultSet.getString("genero") + " | Localização: "
                        + resultSet.getString("localizacao") + " | Status: "
                        + resultSet.getString("status") + " | Reportes: "
                        + resultSet.getInt("reportes") + ";";

                minhaLista.addElement(mensagem);

                System.out.println("ID: " + resultSet.getInt("id_rebeldes") + " | Nome: "
                        + resultSet.getString("nome") + " | Idade: "
                        + resultSet.getInt("idade") + " | Gênero: "
                        + resultSet.getString("genero") + " | Localização: "
                        + resultSet.getString("localizacao") + " | Status: "
                        + resultSet.getString("status") + " | Reportes: "
                        + resultSet.getInt("reportes"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    JList<String> lista = new JList<>(minhaLista);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(lista);
    scrollPane.setBounds(10, 10, 760, 500);
    lista.setLayoutOrientation(JList.VERTICAL);
    this.add(scrollPane);

    JButton btnVoltar = new JButton("Fechar Aba");
    btnVoltar.setBounds(10, 520, 760, 20);
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
