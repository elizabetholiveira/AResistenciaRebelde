package view;

import service.UsuarioService;

import java.util.Scanner;

public class Rebelde {

        UsuarioService usuarioService = new UsuarioService();

        Scanner entrada = new Scanner(System.in);

        public void usuarioCadastrarRebelde() {
            System.out.println("Nome:");
            String nome = entrada.nextLine();
            System.out.println("Idade:");
            int idade = entrada.nextInt();
            System.out.println("Gênero:");
            entrada.nextLine();
            String genero = entrada.nextLine();
            System.out.println("Localização:");
            String localizacao = entrada.nextLine();
            usuarioService.cadastrarRebelde(nome, idade, genero, localizacao);
        }
}
