package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.AcaoEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */

@ManagedBean
@SessionScoped
public class AcoesFacade {

    private List<AcaoEntity>    acoes = new LinkedList<AcaoEntity>();

}
