import view.UsuarioView;
import visual.VisualMenuPrincipal;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
//        UsuarioView usuarioView = new UsuarioView();
//        usuarioView.inicializacao();

        VisualMenuPrincipal visualMenuPrincipal = new VisualMenuPrincipal();
        visualMenuPrincipal.iniciarMenu();
    }
}
