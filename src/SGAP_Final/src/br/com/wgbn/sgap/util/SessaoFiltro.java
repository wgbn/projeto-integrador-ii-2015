package br.com.wgbn.sgap.util;

import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Walter Gandarella
 */
@WebFilter("/paginas/*")
public class SessaoFiltro implements Filter {

    // implementação do init e destroy

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("##-> Passou pelo filtro");
        HttpSession sessao = ((HttpServletRequest) request).getSession(true);
        String paginaAtual = ((HttpServletRequest) request).getServletPath();

        if (!paginaAtual.contains(".js") || !paginaAtual.contains(".css") || !paginaAtual.contains(".jpg") || !paginaAtual.contains(".gif") || !paginaAtual.contains(".png"))
            if (!Sessao.getInstance().isLogado()){
                if (!paginaAtual.contains("Login")){
                    HttpServletResponse res = (HttpServletResponse) response;
                    res.sendRedirect(((HttpServletRequest) request).getContextPath()+"/paginas/usuarios/usuariosLogin.xhtml");
                }
            }


        // passa pela porta
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}