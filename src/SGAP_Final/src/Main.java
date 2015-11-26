import br.com.wgbn.sgap.controller.MainApp;
import br.com.wgbn.sgap.dao.AcaoDAO;
import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.dao.TipoacaoDAO;
import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.*;
import br.com.wgbn.sgap.bo.AcaoModel;
import br.com.wgbn.sgap.bo.ClienteModel;
import br.com.wgbn.sgap.bo.TipoacaoModel;
import br.com.wgbn.sgap.bo.UsuarioModel;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Walter Gandarella
 */
public class Main {

    public static void main(String[] args) {
        EntityManager em = MainApp.getFacadeEntityManager().getEntityManager();

        // cliente
        ClienteModel clienteModel = new ClienteModel(new ClienteDAO(em));
        //ClienteEntity cliente = clienteModel.getDao().getPorPk(3);
        ClienteEntity cliente = new ClienteEntity();
                      cliente.setId(3);

        // tipo acao
        TipoacaoModel tipoModel = new TipoacaoModel(new TipoacaoDAO(em));
        TipoacaoEntity tipo = tipoModel.getDao().getPorPk(1);

        // usuario gerente
        UsuarioModel userModel = new UsuarioModel(new UsuarioDAO(em));
        //UsuarioEntity gerente = userModel.getDao().getPorPk(3);
        UsuarioEntity gerente = new UsuarioEntity();
                      gerente.setId(3);

        //acao
        AcaoModel acaoModel = new AcaoModel(new AcaoDAO(em));
        acaoModel.setEntity(new AcaoEntity());
        Date data = new Date();
        acaoModel.getEntity().setDatainicio(new Timestamp(data.getTime() + 10800));
        acaoModel.getEntity().setDatafim(new Timestamp(data.getTime() + 14400));
        acaoModel.getEntity().setLocal("Jardim de Alah");
        acaoModel.getEntity().setTitulo("Viva Salute");
        acaoModel.getEntity().setDatacriacao(new Timestamp(data.getTime()));
        acaoModel.getEntity().setUsuario(gerente);
        acaoModel.getEntity().setTipoacao(tipo);
        acaoModel.getEntity().setCliente(cliente);
        acaoModel.setEntity(acaoModel.getDao().salvar(acaoModel.getEntity()));

        System.out.println("-----------------------------");
        System.out.println("ACÃO:\t"+acaoModel.getEntity().getTitulo());
        System.out.println("ID:\t\t"+acaoModel.getEntity().getId());
        System.out.println("-----------------------------");

        // promotores
        UsuarioEntity p1 = userModel.getDao().getPorPk(4);
        UsuarioEntity p2 = new UsuarioEntity();
                      p2.setNome("Dhully Santana");
                      p2.setEmail("dhullysantana@gmail.com");
                      p2.setTelefoneCelular("(71) 99399-5135");
                      p2.setSenha("123456");
                      p2.setDatacriacao(new Timestamp(data.getTime()));
                      p2 = userModel.getDao().salvar(p2);

        UsuarioAcaoEntity ua1 = new UsuarioAcaoEntity();
                          ua1.setDatacadastro(new Timestamp(data.getTime()));
                          ua1.setAcao(acaoModel.getEntity());
                          ua1.setLider(1);
                          ua1.setUsuario(p1);
                          ua1 = acaoModel.setPromotor(ua1);

        UsuarioAcaoEntity ua2 = new UsuarioAcaoEntity();
                          ua2.setDatacadastro(new Timestamp(data.getTime()));
                          ua2.setAcao(acaoModel.getEntity());
                          ua2.setLider(0);
                          ua2.setUsuario(p2);
                          ua2 = acaoModel.setPromotor(ua2);

        // pega do banco
        /*AcaoEntity acaoDb = acaoModel.getDao().getPorPk(13);

        System.out.println("-----------------------------");
        System.out.println("ACÃO:\t"+acaoDb.getTitulo());
        System.out.println("ID:\t\t"+acaoDb.getId());
        System.out.println("promotores:\t"+acaoDb.getUsuarios().size());
        System.out.println("-----------------------------");
        for (UsuarioAcaoEntity ua : acaoDb.getUsuarios()){
            System.out.println(ua.getUsuario().getNome()+"\t\t"+(ua.getLider() == 1 ? "Líder":""));
        }
        System.out.println("-----------------------------");

        // por promotores
        UsuarioEntity p1 = userModel.getDao().getPorPk(4);

        System.out.println("******************************");

        System.out.println(p1.getNome());
        for (UsuarioAcaoEntity ua : p1.getAcoes()){
            System.out.println(ua.getAcao().getTitulo());
        }*/
    }

}
