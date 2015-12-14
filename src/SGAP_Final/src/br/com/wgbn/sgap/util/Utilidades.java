package br.com.wgbn.sgap.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public static String getDiaDaSemana(Timestamp ts){
        Calendar c = new GregorianCalendar();
        c.setTime(new Date(ts.getTime()));
        String nome = "";
        int dia = c.get(c.DAY_OF_WEEK);

        switch (dia){
            case Calendar.SUNDAY: nome = "DOM"; break;
            case Calendar.MONDAY: nome = "SEG"; break;
            case Calendar.TUESDAY: nome = "TER"; break;
            case Calendar.WEDNESDAY: nome = "QUA"; break;
            case Calendar.THURSDAY: nome = "QUI"; break;
            case Calendar.FRIDAY: nome = "SEX"; break;
            case Calendar.SATURDAY: nome = "SAB"; break;
        }

        return nome;
    }

    public static String getMes(Timestamp ts){
        Date dt = new Date(ts.getTime());
        String nome = "";

        switch ((dt.getMonth())){
            case 0: nome = "JAN"; break;
            case 1: nome = "FEV"; break;
            case 2: nome = "MAR"; break;
            case 3: nome = "ABR"; break;
            case 4: nome = "MAI"; break;
            case 5: nome = "JUN"; break;
            case 6: nome = "JUL"; break;
            case 7: nome = "AGO"; break;
            case 8: nome = "SET"; break;
            case 9: nome = "OUT"; break;
            case 10: nome = "NOV"; break;
            case 11: nome = "DEZ"; break;
        }

        return nome;
    }

    public static String formataHora(Timestamp ts){
        DateFormat f24h = new SimpleDateFormat("HH:mm");
        return f24h.format(new Date(ts.getTime()));
    }

}
