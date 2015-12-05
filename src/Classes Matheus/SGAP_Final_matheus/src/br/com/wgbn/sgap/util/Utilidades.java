package br.com.wgbn.sgap.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Walter Gandarella
 */
public class Utilidades {

    public static boolean isNewRequest() {
        final FacesContext fc = FacesContext.getCurrentInstance();
        final boolean getMethod = ((HttpServletRequest) fc.getExternalContext().getRequest()).getMethod().equals("GET");
        final boolean ajaxRequest = fc.getPartialViewContext().isAjaxRequest();
        final boolean validationFailed = fc.isValidationFailed();
        return getMethod && !ajaxRequest && !validationFailed;
    }

}
