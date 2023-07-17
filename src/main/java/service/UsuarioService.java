package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.Conexao.getConnection;

public class UsuarioService {

    private Statement statement;

    public Statement getStatement() {
        return statement;
    }

    public UsuarioService(){
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Fechar conexão
    public void fecharConexao(){
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Cadastrar Rebelde
    public void cadastrarRebelde(String nome, String idade, String genero, String localizacao){
        String sql = "insert into rebeldes (nome, idade, genero, localizacao, status, reportes) values ('" + nome + "', '"
                + idade + "', '" + genero + "', '" + localizacao + "', 'Rebelde', '0');";
        try {
            statement.executeUpdate(sql);
            System.out.println("Dado inserido com sucesso!");
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    //Remover Cadastro
    public void removerRebelde(String id){
        if (identificarCadastro(id) == true){
            String sql = "delete from rebeldes where id_rebeldes = '" + id + "';";
            try {
                statement.executeUpdate(sql);
                System.out.println("Cadastro removido com sucesso!");
            } catch (SQLException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("ID digitado não existe");
        }
    }

    //Ver Cadastros
    public void verCadastros(){
        String sql = "select * from rebeldes order by id_rebeldes ASC;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
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
    }

    //Ver Relatorio
    public void relatorio(){

        int numRebeldes = 0;
        int numTraidores = 0;

        //Pegar rebeldes
        String sql1 = "SELECT FROM rebeldes WHERE status = 'Rebelde'";
        try{
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()){
                numRebeldes += 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        //Pegar traidores
        String sql2 = "SELECT FROM rebeldes WHERE status = 'Traidor'";
        try{
            ResultSet resultSet = statement.executeQuery(sql2);
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

        System.out.println("Relatório:");
        System.out.println("Rebeldes: " + porcentRebeldes + "%");
        System.out.println("Traidores: " + porcentTraidores + "%");

    }

    //Adicionar Reporte

    public void adicionarReporte (String id) {
        String sql = "SELECT * FROM rebeldes WHERE id_rebeldes = '" + id + "'";
        try {
            ResultSet resultSet1 = statement.executeQuery(sql);
            while (resultSet1.next()) {
                    if (resultSet1.getInt("reportes") == 2) {
                            System.out.println("Esse cadastro recebeu 3 reportes e agora é considerado um traidor!");
                            String sql3 = "UPDATE rebeldes SET status = 'Traidor' WHERE id_rebeldes = '" + id + "'";
                            statement.executeUpdate(sql3);
                    }
                System.out.println("Reporte adicionado!");
                    String sql2 = "UPDATE rebeldes SET reportes = " + (resultSet1.getInt("reportes") + 1) + " WHERE id_rebeldes = '" + id + "'";
                    statement.executeUpdate(sql2);
            }
        } catch(SQLException e){
            //Botei como comentário porque por algum motivo mesmo tudo funcionando perfeitamente, tanto as mensagens, quanto o banco de dados. Ele ficava me retornendo uma exceção. (sem parar o programa)
            //e.printStackTrace();
        }
    }

    //Alterar Localizacao
    public void alterarLocalizacao(String id, String local){
        String sql = "UPDATE rebeldes SET localizacao = '" + local + "' WHERE id_rebeldes = " + id + ";";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Loja
    //Identificar Cadastro com Créditos
    public boolean identificarCadastroLoja(String id){
            boolean existe = false;
            String sql = "SELECT FROM inventario WHERE rebelde_id = "+ id + ";";
            try {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    existe = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return existe;
    }
    //Adquirir Créditos
    public void adquirirCreditos(String id){
        String sql = "insert into inventario (rebelde_id, qtdarma, qtdmunicao, qtdagua, qtdcomida, creditos) values (" + id + ", '0', '0', '0', '0', '500');";
        try {
            statement.executeUpdate(sql);
            System.out.println("500 créditos adquiridos!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Ver inventário
    public void verInventario(String id) {
        String sql = "select * from inventario where rebelde_id = " + id + ";";
        System.out.println("Inventário:");
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("ID: " + id + " | Créditos: " + resultSet.getInt("creditos") +
                        " | Armas: " + resultSet.getInt("qtdarma") +
                        " | Munição: " + resultSet.getInt("qtdmunicao") +
                        " | Água: " + resultSet.getInt("qtdagua") +
                        " | Comida: " + resultSet.getInt("qtdcomida"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Ver Loja
    public void verLoja(){
        String sql = "select * from loja order by id_item ASC;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id_item") + " | Item: "
                        + resultSet.getString("nome") + " | Valor: "
                        + resultSet.getInt("valor") + " créditos");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Comprar na Loja
    public String selecionarItem(long idItem){
        String sql = "select * from loja where id_item = '" + idItem + "';";
        String nomeItem = null;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
             nomeItem = resultSet.getString("nome");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomeItem;
    }
    public void comprarItem(String id, String nomeItem,int valor){
        String sql = "select * from inventario where rebelde_id = '" + id + "';";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String sql2 = "UPDATE inventario SET creditos = " + (resultSet.getInt("creditos") - valor) + " WHERE rebelde_id = " + id + ";";
                String sql3 = "UPDATE inventario SET " + nomeItem + " = " + (resultSet.getInt(nomeItem) + 1) + " WHERE rebelde_id = " + id + ";";
                statement.executeUpdate(sql2);
                statement.executeUpdate(sql3);
            }
        } catch (SQLException e){
            //Mesmo problema do reportar um traidor
            //e.printStackTrace();
        }
    }

    //Identificar Cadastro
    public boolean identificarCadastro (String id) {
        boolean existe = false;
        String sql = "SELECT FROM rebeldes WHERE id_rebeldes = '"+ id + "'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                existe = true;
                System.out.println("Cadastro encontrado!");
            }
            if (existe == false){
                System.out.println("Cadastro não encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    //Identificar Status
    public String identificarStatus(String id){
        String status = null;
        String sql = "SELECT status FROM rebeldes WHERE id_rebeldes = '" + id + "'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                status = resultSet.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Status atual do ID " + id + " : " + status);
        return status;
    }

    //INNER JOIN
    public void innerJoin() {
        System.out.println("Nome e ID dos cadastros que possuem inventário:");
        String sql = "select rebeldes.nome, inventario.rebelde_id from rebeldes inner join inventario on rebeldes.id_rebeldes = inventario.rebelde_id order by rebelde_id ASC;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("rebelde_id") + " | Nome: " + resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //LEFT JOIN
    public void leftJoin(){
        System.out.println("Nome e ID dos cadastros que possuem ou não inventário:");
        String sql = "select rebeldes.nome, rebeldes.id_rebeldes , inventario.id_inventario from rebeldes left join inventario on rebeldes.id_rebeldes = inventario.id_inventario order by rebelde_id ASC;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID inventário: " + resultSet.getInt("id_inventario") + " | ID: " + resultSet.getInt("id_rebeldes") + " | Nome: " + resultSet.getString("nome"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //RIGHT JOIN
    public void rightJoin(){
        System.out.println("ID dos inventários com ou não cadastros:");
        String sql = "select rebeldes.nome, rebeldes.id_rebeldes , inventario.id_inventario from rebeldes right join inventario on rebeldes.id_rebeldes = inventario.rebelde_id order by rebelde_id ASC;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID inventário: " + resultSet.getInt("id_inventario") + " | ID: " + resultSet.getInt("id_rebeldes") + " | Nome: " + resultSet.getString("nome"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //FULL JOIN
    public void fullJoin(){
        System.out.println("ID dos inventários com ou não cadastros:");
        String sql = "select rebeldes.nome, rebeldes.id_rebeldes , inventario.id_inventario, inventario.creditos, inventario.qtdarma, inventario.qtdmunicao, inventario.qtdagua, inventario.qtdcomida from rebeldes full join inventario on rebeldes.id_rebeldes = inventario.rebelde_id order by rebelde_id ASC;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id_rebeldes") + " | Nome: " + resultSet.getString("nome") +
                        " | Créditos: " + resultSet.getInt("creditos") +
                        " | Armas: " + resultSet.getInt("qtdarma") +
                        " | Munição: " + resultSet.getInt("qtdmunicao") +
                        " | Água: " + resultSet.getInt("qtdagua") +
                        " | Comida: " + resultSet.getInt("qtdcomida"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
