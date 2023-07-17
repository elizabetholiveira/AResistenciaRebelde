import view.UsuarioView;
import visual.VisualLogin;
import visual.VisualMenuPrincipal;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
//        UsuarioView usuarioView = new UsuarioView();
//        usuarioView.inicializacao();

        VisualLogin visualLogin = new VisualLogin();
        visualLogin.iniciarLogin();

    }
}
