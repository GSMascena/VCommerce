
package root.control.log;

import java.util.ArrayList;
import root.control.components.Request;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class RequestLog {
    private ArrayList<Request> requestLog;
    
    //Construtor
    public RequestLog() {
        this.requestLog = new ArrayList<>();
    }
    //Construtor FIM
    
    //Métodos
    public boolean addRequest(Request request){
        if(request == null)
            return false;
        
        this.requestLog.add(request);
        return true;
    }
    
    public int generateId(){
        int id = 0;
        for(Request request : this.requestLog){
            if(request.getIdRequest() > id){
                id = request.getIdRequest();
            }
        }
        return id+1;
    }
    
    public Request[] toArray(){
        Request[] requestArray = new Request[requestLog.size()];
        int counter = 0;
        for(Request request : requestLog){
            requestArray[counter] = request;
            counter++;
        }
        return requestArray;
    }
    //Métodos FIM
    
    //Getters e Setters 
    public ArrayList<Request> getRequestLog() {
        return requestLog;
    }

    public void setRequestLog(ArrayList<Request> requestLog) {
        this.requestLog = requestLog;
    }
    //Getters e Setters FIM
    
}
