
package root.control.components;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class Client {
    private int idClient;
    private String name;
    private String cpf;
    private String cep;
    private String email;
    private String telephone;
    
    //Construtor
    public Client(int idClient, String name, String cpf, String cep, String email, String telephone) {
        this.idClient = idClient;
        this.name = name;
        this.cpf = cpf;
        this.cep = cep;
        this.email = email;
        this.telephone = telephone;
    }
    //Construtor FIM
    
    //Getters e Setters
    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    //Getters e Setters FIM
}
