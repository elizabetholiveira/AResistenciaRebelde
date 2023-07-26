package view;

import model.UsuarioModel;
import service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioView {

    private Scanner entrada;
    private UsuarioService usuarioService;
    private UsuarioModel usuarioModel;
    private Rebelde rebelde;

    public UsuarioView(){
        entrada = new Scanner(System.in);
        usuarioService = new UsuarioService();
        usuarioModel = new UsuarioModel();
        rebelde = new Rebelde();
    }

    public void inicializacao(){
        int escolha;
        do {
            menu();
            escolha = selecionaEscolhaUsuario();

            switch (escolha){
                case 0: //Sair
                    System.out.println("Saindo...");
                    usuarioService.fecharConexao();
                    break;
                case 1: //Cadastrar view.Rebelde
                    rebelde.usuarioCadastrarRebelde();
                    break;
                case 2: //Remover Cadastro
                    System.out.println("Digite o seu ID");
                    long seuId = entrada.nextLong();
                    if (usuarioService.identificarCadastro(seuId) == true && usuarioService.identificarStatus(seuId).equals("view.Rebelde")){
                        System.out.println("Digite o ID que deseja remover");
                        usuarioService.removerRebelde(entrada.nextLong());
                    }
                    break;
                case 3: //Reportar Traidor
                    System.out.println("Digite o seu ID");
                    seuId = entrada.nextLong();
                    if (usuarioService.identificarCadastro(seuId) == true && usuarioService.identificarStatus(seuId).equals("view.Rebelde")) {
                        System.out.println("Digite o ID do rebelde que deseja reportar como traidor");
                        long id = entrada.nextLong();
                        if (usuarioService.identificarCadastro(id) == true) {
                            String status = usuarioService.identificarStatus(id);
                            if (status.equals("view.Rebelde")) {
                                usuarioService.adicionarReporte(id);
                            } else if (status.equals("Traidor")) {
                                System.out.println("Esse ID já é considerado um traidor!");
                            }
                        }
                    } else {
                        System.out.println("Esse ID está cadastrado como Traidor, portanto não pode reportar ninguém.");
                    }
                    break;
                case 4: //Ver relatório
                    usuarioService.relatorio();
                    break;
                case 5: //Ver cadastros
                    usuarioService.verCadastros();
                    break;
                case 6: //Ver inventário
                    System.out.println("Digite o ID do dono do inventário");
                    long id = entrada.nextLong();
                    if (usuarioService.identificarCadastro(id) == true){
                        if (usuarioService.identificarCadastroLoja(id) == true){
                            usuarioService.identificarStatus(id);
                            usuarioService.verInventario(id);
                        } else {
                            System.out.println("Esse ID não possui um inventário");
                        }
                    }
                    break;
                case 7: //Adquirir créditos
                    System.out.println("Digite o ID do rebelde");
                    id = entrada.nextLong();
                    if (usuarioService.identificarCadastro(id) == true){
                        if (usuarioService.identificarStatus(id).equals("view.Rebelde")) {
                            if (usuarioService.identificarCadastroLoja(id) == false) {
                                usuarioService.adquirirCreditos(id);
                            } else {
                                System.out.println("Esse ID já resgatou seus créditos!");
                            }
                        } else {
                            System.out.println("IDs marcados como traidores não podem receber créditos!");
                        }
                    }
                    break;
                case 8: //Ver base de compras
                    usuarioService.verLoja();
                    break;
                case 9: //Comprar na base de compras
                    System.out.println("Digite o ID do rebelde");
                    id = entrada.nextLong();
                    if (usuarioService.identificarCadastro(id) == true){
                        if (usuarioService.identificarStatus(id).equals("view.Rebelde")) {
                            if (usuarioService.identificarCadastroLoja(id) == true) {
                                usuarioService.verLoja();
                                System.out.println("Digite o ID do produto que deseja comprar");
                                long idItem = entrada.nextLong();
                                System.out.println("Você comprou o item: " + usuarioService.selecionarItem(idItem));
                                if (usuarioService.selecionarItem(idItem).equals("Arma")){usuarioService.comprarItem(id, "qtdarma", 100);}
                                if (usuarioService.selecionarItem(idItem).equals("Munição")){usuarioService.comprarItem(id, "qtdmunicao", 30);}
                                if (usuarioService.selecionarItem(idItem).equals("Água")){usuarioService.comprarItem(id, "qtdagua", 5);}
                                if (usuarioService.selecionarItem(idItem).equals("Comida")){usuarioService.comprarItem(id, "qtdcomida", 15);}
                            } else {
                                System.out.println("Esse ID precisa resgatar seus créditos primeiro!");
                            }
                        } else {
                            System.out.println("IDs marcados como traidores não podem fazer compras!");
                        }
                    }
                    break;
                case 10: //Alterar localização
                    System.out.println("Digite o ID que deseja alterar a localização");
                    id = entrada.nextLong();
                    if (usuarioService.identificarCadastro(id) == true){
                        System.out.println("Digite a nova localização");
                        entrada.nextLine();
                        String local = entrada.nextLine();
                        usuarioService.alterarLocalizacao(id, local);
                    } else {
                        System.out.println("Cadastro não encontrado!");
                    }
                    break;
                case 11: //Menu extra
                    menuExtra();
                    escolha = selecionaEscolhaUsuario();
                    switch (escolha){
                        case 1:
                            System.out.println("INNER-JOIN:");
                            usuarioService.innerJoin();
                            break;
                        case 2:
                            System.out.println("LEFT-JOIN");
                            usuarioService.leftJoin();
                            break;
                        case 3:
                            System.out.println("RIGHT-JOIN");
                            usuarioService.rightJoin();
                            break;
                        case 4:
                            System.out.println("FULL-JOIN");
                            usuarioService.fullJoin();
                            break;
                        default:
                            System.out.println("Escolha inválida");
                    }
                    break;
                default:
                    System.out.println("Escolha inválida");
                    break;
            }
        } while (escolha != 0);
    }

    public void menu(){
        System.out.println("Boas-vindas!");
        System.out.println("Digite uma das opções (em caso de dúvida, consulte o manual(README))");
        System.out.println("0) Sair");
        System.out.println("1) Cadastrar view.Rebelde");
        System.out.println("2) Remover Cadastro");
        System.out.println("3) Reportar Traidor");
        System.out.println("4) Ver relatório");
        System.out.println("5) Ver cadastros");
        System.out.println("6) Ver inventário");
        System.out.println("7) Adquirir créditos");
        System.out.println("8) Ver Base de Compras");
        System.out.println("9) Comprar na Base de Compras");
        System.out.println("10) Alterar localização");
        System.out.println("11) Menu extra");
    }

    public void menuExtra(){
        System.out.println("1) INNER-JOIN (ID e nomes de quem possui inventário)");
        System.out.println("2) LEFT-JOIN (Lista de todos os cadastros, com ou sem inventário)");
        System.out.println("3) RIGHT-JOIN (Lista de todos os inventários, com ou sem cadastros)");
        System.out.println("4) FULL-JOIN (Lista de inventários com os nomes (com e sem cadastro/inventário))");
    }

    public int selecionaEscolhaUsuario(){
        int escolha = -1;
        try{
            escolha = entrada.nextInt();
            entrada.nextLine();
        } catch (InputMismatchException e){
            entrada.nextLine();
        }
        return escolha;
    }
}
