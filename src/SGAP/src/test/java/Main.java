import br.com.wgbn.sgap.controller.UsuarioFacade;

import java.util.List;

/**
 * Created by vivasalute on 20/11/15.
 */
public class Main {

    public static void main(String[] args) {
        UsuarioFacade uf = new UsuarioFacade();

        List users = uf.getUsuarios();
    }

}
