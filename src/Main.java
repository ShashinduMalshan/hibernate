import Config.FactoryConfiguration;
import Entitiry.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static FactoryConfiguration factory;
    public static void main(String[] args) {

        factory=FactoryConfiguration.getInstance();

//        Customer customer1=new Customer(1,"Alice","alice@example.com","07714578965");
//        Customer customer2=new Customer(2,"Grace","Grace@example.com","0771958965");
        //Customer customer3=new Customer(3,"jorge","brave@example.com","07914578965");
        Customer customer4=new Customer(4,"joen","joen@example.com","07714078965","951075385245");
//        Customer customer5=new Customer(5,"anne","anne@example.com","07711578965");
//
//        saveCustomer(customer1);
//        saveCustomer(customer2);
//        saveCustomer(customer3);
        saveCustomer(customer4);
//        saveCustomer(customer5);
//        updateCustomer(3,new Customer(
//                3,
//                "amal",
//                "amal@example.com",
//                "0789456898"));


//        Customer customerById = getCustomerById(1);
//        System.out.println(customerById);
//        deleteCustomerById(5);


        List<Customer> allCustomer = getAllCustomers();

        for (Customer customer : allCustomer) {
            System.out.println(customer);
        }

    }

    public static List<Customer> getAllCustomers() {

        Session session = factory.getSession();
        List<Customer> customers = session.createQuery("from Customer",Customer.class).list();
        session.close();
        return customers;
    }
    public  static boolean updateCustomer(int id,Customer customer) {
        Session session = factory.getSession();

        try {
            Customer customerById = session.get(Customer.class, id);


            Transaction transaction = session.beginTransaction();

            customerById.setName(customer.getName());
            customerById.setEmail(customer.getEmail());
            customerById.setPhone(customer.getPhone());
            session.update(customerById);

            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if (session != null) {}
            session.close();
        }

    }
    public  static boolean deleteCustomerById(int id) {
        Session session = factory.getSession();

        try {
            Customer customerById = getCustomerById(id);
            Transaction transaction = session.beginTransaction();
            session.delete(customerById);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static Customer getCustomerById(int id) {
        Session session =factory.getSession();
        Customer customer = session.get(Customer.class,id);

        return customer;
    }




    public static boolean saveCustomer(Customer customer) {
        Session session = factory.getSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if (session != null) {
                session.close();
            }
        }


    }
}