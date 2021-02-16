
package root.control.log;

import java.util.ArrayList;
import root.control.components.Employee;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class EmployeeLog {   
    private ArrayList<Employee> employeeLog;
    
    //Construtor
    public EmployeeLog() {
        this.employeeLog = new ArrayList<>();
    }
    //Construtor FIM
    
    //Métodos
    
    ///Método que valida o login e senha de um funcionário cadastrado.
    public boolean validateLogin(String login, char[] password){
        for(Employee employee : this.employeeLog){
            if(employee.getLogin().equals(login)){
                char[] truePassword;
                truePassword = employee.getPassword();
                for(int counter = 0; counter  < truePassword.length; counter++){
                    if(truePassword[counter] != password[counter]){
                        System.out.println("Falso");
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean addEmployee(Employee employee){
        if(employee.getLogin().equals(""))
            return false;
        if(employee.getPassword().equals(""))
            return false;
        
        this.employeeLog.add(employee);
        return true;
    }
    //Métodos FIM
    
    //Getters e Setters
    public ArrayList<Employee> getEmployeeLog() {
        return employeeLog;
    }

    public void setEmployeeLog(ArrayList<Employee> employeeLog) {
        this.employeeLog = employeeLog;
    }
    //Getters e Setters FIM
    
}
