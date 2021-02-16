
package root.control.log;

import java.util.ArrayList;
import root.control.components.Client;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class ClientLog {
    private ArrayList<Client> clientLog;
    
    //Construtor
    public ClientLog() {
        this.clientLog = new ArrayList<>();
    }
    //Construtor FIM
    
    //Métodos
    public boolean addClient(Client client){
        if(client.getIdClient() <= 0)
            return false;
        if(client.getName().equals(""))
            return false;
        if(client.getCpf().length() != 14)
            return false;
        if(client.getCep().length() != 9)
            return false;
        if(client.getEmail().equals(""))
            return false;
        if(client.getTelephone().equals(""))
            return false;
        
        this.clientLog.add(client);
        return true;
    }
    
    public int size(){
        return clientLog.size();
    }
    
    public Client[] toArray(){
        Client[] clientArray = new Client[clientLog.size()];
        int counter = 0;
        for(Client client : clientLog){
            clientArray[counter] = client;
            counter++;
        }
        return clientArray;
    }
    
    public int generateId(){
        int id = 0;
        for(Client client : this.clientLog){
            if(client.getIdClient() > id){
                id = client.getIdClient();
            }
        }
        return id+1;
    }
    //Métodos FIM
    
    //Getters e Setters
    public ArrayList<Client> getClientLog() {
        return clientLog;
    }

    public void setClientLog(ArrayList<Client> clientLog) {
        this.clientLog = clientLog;
    }
    //Getters e Setters FIM
    
}
