
package root.control.system;

import root.control.components.Client;
import root.control.components.Employee;
import root.control.components.Product;
import root.control.components.Request;
import root.control.log.ClientLog;
import root.control.log.EmployeeLog;
import root.control.log.ProductLog;
import root.control.log.RequestLog;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class Controller {
    private ClientLog clientLog;
    private EmployeeLog employeeLog;
    private ProductLog productLog;
    private RequestLog requestLog;
    private Request standbyInRequest;
    
    //Construtor
    public Controller(){
        initLogs();
    }
    
    //Procedimento que inicializa os logs ou registros do controlador
    private void initLogs(){
        this.clientLog = new ClientLog();
        this.employeeLog = new EmployeeLog();
        this.productLog = new ProductLog();
        this.requestLog = new RequestLog();
        this.loadDatabase();
    }
    //Procedimento chamado pelo inicializador que carrega informações do banco
    //de dados para os registros, para ser trabalhado em tempo de execução
    private void loadDatabase(){
        //Carregar registro de empregados do banco de dados para o Log
        Employee employee1 = new Employee("Arthur","Rocha".toCharArray(),"Arthur@ifmail.br");
        Employee employee2 = new Employee("Gabriel", "Mascena".toCharArray(), "Gabriel@ifmail.br");
        Employee employee3 = new Employee("Regis", "Cortez".toCharArray(), "Regis@ifmail.br");
        Employee employee4 = new Employee("Vera", "Lucia".toCharArray(), "Regis@ifmail.br");
        this.employeeLog.addEmployee(employee1);
        this.employeeLog.addEmployee(employee2);
        this.employeeLog.addEmployee(employee3);
        this.employeeLog.addEmployee(employee4);
        //Carregar registro de produtos do banco de dados para o log
        Product product1 = new Product( 101, "Video Game: Good of War", 97.99);
        Product product2 = new Product( 102, "Video Game: Assassins Cult", 119.99);
        Product product3 = new Product( 103, "Eletrônico: Ybox", 1999.99);
        Product product4 = new Product( 104, "Eletrônico: PlayState", 2999.99);
        Product product5 = new Product( 105, "Eletrônico: Mintendo Switch", 3999.99);
        Product product6 = new Product( 106, "Video Game: Mega maria sisters", 97.99);
        Product product7 = new Product( 107, "Video Game: Legend of Link", 199.99);
        this.productLog.addProduct(product1);
        this.productLog.addProduct(product2);
        this.productLog.addProduct(product3);
        this.productLog.addProduct(product4);
        this.productLog.addProduct(product5);
        this.productLog.addProduct(product6);
        this.productLog.addProduct(product7);
        //Carregar registro de clientes do banco de dados para o log
        Client client1 = new Client( 1, "Nicolas", "485.650.933-01", "11910-970", "nick@gmail.com", "(11)9758247");
        Client client2 = new Client( 2, "Danilo", "274.929.523-84", "18940-970", "dan.ilo@ig.com.br", "(11)9721312");
        Client client3 = new Client( 3, "Guilherme", "446.349.350-15", "58079-692", "gui77@hotmail.com", "(11)9348213");
        Client client4 = new Client( 4, "Marcos", "502.148.590-37", "88066-010", "marcola@outlook.com", "(11)9448788");
        this.clientLog.addClient(client1);
        this.clientLog.addClient(client2);
        this.clientLog.addClient(client3);
        this.clientLog.addClient(client4);
        //Carregar registro de requisições do banco de dados para o log
        Request request1 = new Request(this.requestLog.generateId(), client1);
        request1.addProduct(product1);
        request1.addProduct(product3);
        this.requestLog.addRequest(request1);
        Request request2 = new Request(this.requestLog.generateId(), client2);
        request2.addProduct(product2);
        request2.addProduct(product4);
        this.requestLog.addRequest(request2);
        Request request3 = new Request(this.requestLog.generateId(), client3);
        request3.addProduct(product4);
        request3.addProduct(product1);
        this.requestLog.addRequest(request3);
        Request request4 = new Request(this.requestLog.generateId(), client4);
        request4.addProduct(product5);
        request4.addProduct(product6);
        request4.addProduct(product7);
        this.requestLog.addRequest(request4);
    }
    
    public boolean validateLogin(String login, char[] password){
        return employeeLog.validateLogin(login, password);
    }
    
    //Métodos de manipulação da classe Client e ClientLog
    
    ///Método que recebe as informações de um cliente e retorna o cliente instanciado
    public Client createClient(String name, String cpf, String cep, String email, String telephone){
        Client client = new Client(this.clientLog.generateId(), name, cpf, cep, email, telephone);
        return client;
    }
    ///Método que registra o cliente no ClientLog
    public boolean registerClient(String name, String cpf, String cep, String email, String telephone){
        Client client = new Client(this.clientLog.generateId(), name, cpf, cep, email, telephone);
        
        return clientLog.addClient(client);
    }
    ///Método que valida as informações de um cliente
    public boolean validateClient(String name, String cpf, String cep, String email, String telephone){
        if(name.equals(""))
            return false;
        if(cpf.length() != 14)
            return false;
        if(cep.length() != 9)
            return false;
        if(email.equals(""))
            return false;
        if(telephone.equals(""))
            return false;
        
        return true;
    }
    ///Método que retorna a quantidade de clientes registrados.
    public int clientQuantity(){
        return this.clientLog.size();
    }
    ///Método que devolve um array de clientes, para permitir extração fácil de informações
    public Client[] giveClientArray(){
        Client[] clientList = new Client[this.clientLog.size()];
        
        int counter = 0;
        for(Client client : this.clientLog.toArray()){
            clientList[counter] = client;
            counter++;
        }
        return clientList;
    }
    
    //Métodos de manipulação da classe Product e ProductLog
    
    ///Recebe um produto e devolve uma String equivalente 
    public String productToString(Product product){
        String productText = "";
        productText += "|ID:" + product.getIdProduct() + "| ";
        productText += product.getName() + "-";
        productText += "$" + product.getPrice();
        return productText;
    }
    ///Devolve um array de Strings representando todos os produtos
    public String[] giveProductStringArray(){
        String[] productList = new String[this.productLog.size()];
        
        int counter = 0;
        for(Product product : this.productLog.toArray()){
            String productText = productToString(product);
            productList[counter] = productText;
            counter++;
        }
        return productList;
    }
    ///Recebe uma String e devolve um Produto equivalente
    public Product stringToProduct(String string){
        int counter;
        counter = 0;
        String id = "";
        do{
            if(counter != 0 && (string.charAt(counter)!= 'I' && string.charAt(counter)!= 'D' && string.charAt(counter)!= ':')){
                id += string.charAt(counter);
            }
            counter++;
        }while(string.charAt(counter) != '|');
        
        counter += 2;
        String name = "";
        do{
            name += string.charAt(counter);
            counter++;
        }while(string.charAt(counter) != '-');
        
        String price = "";
        do{
            if(Character.isDigit(string.charAt(counter)) || string.charAt(counter) == '.'){
                price += string.charAt(counter);
            }
            counter++;
        }while(counter < string.length());
        
        Product product = new Product(Integer.parseInt(id), name, Double.parseDouble(price));
        return product;
    }
    ///Instancia e registra um produto no estoque
    public boolean addProductToStock(String name, double price){
        Product product = new Product(this.productLog.generateId(), name, price);
        return this.productLog.addProduct(product);
    }
    ///Recebe uma string de um produto, extrai seu id e exclui o produto do estoque
    public boolean removeSelectedProduct(String string){
        int counter = 0;
        String id = "";
        do{
            if(counter != 0 && (string.charAt(counter)!= 'I' && string.charAt(counter)!= 'D' && string.charAt(counter)!= ':')){
                id += string.charAt(counter);
            }
            counter++;
        }while(string.charAt(counter) != '|');
        
        return this.productLog.deleteProduct(Integer.parseInt(id));
    }
    
    //Métodos de manipulação de request
    ///Extrai um vetor de String contendo os produtos de uma requisição 
    public String[] giveProductStringArrayFromRequest(Request request){
        String[] productList = new String[request.giveProductList().length];
        int counter = 0;
        for(Product product : request.giveProductList()){
            productList[counter] = productToString(product);
            counter++;
        }
        return productList;
    }
    ///Retorna o registro de requisições em forma de array
    public Request[] giveRequestArray(){
        return this.requestLog.toArray();
    }
    ///Cria uma request que por hora fica hospedada na classe de controle
    public void createRequest(Client client){
        this.standbyInRequest = new Request(requestLog.generateId(), client);
    }
    ///Adiciona um produto a classe hospedada na classe de controle
    public void addProductToRequest(Product product){
        if(this.standbyInRequest != null)
            this.standbyInRequest.addProduct(product);
    }
    ///Finaliza as operações com a classe hospedada e devolve ela para o RequestLog
    public boolean finishRequest(){
        if(this.standbyInRequest.giveProductList().length > 0){
            Request request = this.standbyInRequest;
            this.standbyInRequest = null;
            return this.requestLog.addRequest(request);
        }
        return false;
    }
    
    
    //Getters e Setters
    public ClientLog getClientLog() {
        return clientLog;
    }

    public void setClientLog(ClientLog clientLog) {
        this.clientLog = clientLog;
    }

    public EmployeeLog getEmployeeLog() {
        return employeeLog;
    }

    public void setEmployeeLog(EmployeeLog employeeLog) {
        this.employeeLog = employeeLog;
    }

    public ProductLog getProductLog() {
        return productLog;
    }

    public void setProductLog(ProductLog productLog) {
        this.productLog = productLog;
    }

    public RequestLog getRequestLog() {
        return requestLog;
    }

    public void setRequestLog(RequestLog requestLog) {
        this.requestLog = requestLog;
    }

    public Request getStandbyInRequest() {
        return standbyInRequest;
    }

    public void setStandbyInRequest(Request standbyInRequest) {
        this.standbyInRequest = standbyInRequest;
    }
    
    
}
