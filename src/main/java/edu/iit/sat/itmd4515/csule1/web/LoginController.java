/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.web;

import edu.iit.sat.itmd4515.csule1.security.User;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import java.util.logging.Logger;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;

/**
 *
 * @author chinmayi My code is based on Instructor's Example
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @Inject
    FacesContext facesContext;
    @Inject
    SecurityContext securityContext;

    private User user;

    public LoginController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("******* Inside the LoginController  postConstruct method ******");

        user = new User();
    }

    // helper method
    public String getAuthenticatedUser() {
        return securityContext.getCallerPrincipal().getName();
    }

    public boolean isAdmin() {
        return securityContext.isCallerInRole("ADMIN_ROLE");
    }

    public boolean isCareGiver() {
        return securityContext.isCallerInRole("CAREGIVER_ROLE");
    }

    public boolean isParent() {
        return securityContext.isCallerInRole("PARENT_ROLE");
    }

    public String doLogout() {
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();

        try {
            request.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return "/error.xhtml";
        }

        return "/login.xhtml?faces-redirect=true";
    }

    public String doLogin() {
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        Credential cred = new UsernamePasswordCredential(this.user.getUsername(), new Password(this.user.getPassword()));

        AuthenticationStatus status = securityContext.authenticate(request, response, AuthenticationParameters.withParams().credential(cred));

        // status code check
        switch (status) {
            case SUCCESS:
                LOG.info(status.toString());
                break;
            case SEND_FAILURE:
                LOG.info(status.toString());
                return "/error.xhtml";
            case NOT_DONE:
                LOG.info(status.toString());
                return "/error.xhtml";
            case SEND_CONTINUE:
                LOG.info(status.toString());
                break;
        }

        return "/welcome.xhtml?faces-redirect=true"; // to be a new JSF request everytime 

//        return "/welcome.xhtml"; //gives previous session ids after redirection
    }

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
