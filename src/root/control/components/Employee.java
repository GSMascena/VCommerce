/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.control.components;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class Employee {
    private String login;
    private char[] password;
    private String email;
    
    //Construtor
    public Employee(String login, char[] password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
    //Construtor FIM
    
    //Getters e Setters
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return this.password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //Getters e Setters FIM
    
}
