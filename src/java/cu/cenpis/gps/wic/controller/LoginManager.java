package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.UsuarioService;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginManager {

    private UsuarioService usuarioService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public String doLogin() {
        return doSpringRequest("/j_spring_security_check");
    }

    public String doLogout() {
        return doSpringRequest("/j_spring_security_logout");
    }

    public String doSpringRequest(String url) {

        try {
            ExternalContext context = FacesContext.getCurrentInstance()
                    .getExternalContext();

            RequestDispatcher dispatcher = ((ServletRequest) context
                    .getRequest()).getRequestDispatcher(url);

            dispatcher.forward((ServletRequest) context.getRequest(),
                    (ServletResponse) context.getResponse());

            FacesContext.getCurrentInstance().responseComplete();
        } catch (ServletException | IOException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

}
