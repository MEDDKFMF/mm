/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.config;

import jakarta.annotation.security.DeclareRoles;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 *
 * @author chinmayi
 */
@DeclareRoles({"ADMIN_ROLE", "CAREGIVER_ROLE", "PARENT_ROLE"})
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "/error.xhtml"
        )
)
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/jdbc/itmd4515DS",
        callerQuery = "select PASSWORD from SEC_USER where USERNAME = ?",
        groupsQuery = "select GROUPNAME from SEC_USER_GROUPS where USERNAME = ?"
)
public class ITMD4515SecurityConfig {
    
}

