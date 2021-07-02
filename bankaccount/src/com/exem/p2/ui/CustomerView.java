package com.exem.p2.ui;

import com.exem.p2.bean.Customer;
import com.exem.p2.service.CustomerList;
import com.exem.p2.util.CMUtility;

/**
 * @Description display the menu and operate by user
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);
    
    public CustomerView() {
        Customer customer = new Customer("aa", 'f', 10, "123455", "qq@22.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu() {


        boolean isFlag = true;
        while(isFlag){
            System.out.println("----------------------BankAccount---------------------------\n");
            System.out.println("                     1 add Customer");
            System.out.println("                     2 modify Customer");
            System.out.println("                     3 delete Customer");
            System.out.println("                     4 Customer list");
            System.out.println("                     5 exit\n");
            System.out.print("                       Please chose one number:  ");


            char menu = CMUtility.readMenuSelection();
            System.out.println();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("sure to exit(Y/N): ");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
            }
        }
    }

    /**
     * add customer
     */
    private void addNewCustomer() {
//        System.out.println("add new customer");
        System.out.println("------------------------add customer list-----------------------\n");
        System.out.print("name: ");
        String name = CMUtility.readString(10);
        System.out.print("gender: ");
        char gender = CMUtility.readChar();
        System.out.print("age: ");
        int age = CMUtility.readInt();
        System.out.print("phone: ");
        String phone = CMUtility.readString(13);
        System.out.print("email: ");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("----------------------add to customer list---------------------\n");
        } else {
            System.out.println("--------------------customer list is full, fails to add---------------------\n");
        }
    }
    /**
     * modify
     */
    private void modifyCustomer() {

//        System.out.println("modify new customer");
        System.out.println("------------------------modify customer list-----------------------\n");

        Customer cust;
        int num;
        for(;;) {
            System.out.print("chose the id of custom or -1 to exit: ");
            num = CMUtility.readInt();

            if (num == -1) {
                return;
            }
            cust = customerList.getCustomer(num - 1);
            if (cust == null) {
                System.out.println("cannot find the customer");
            }else {
                break;
            }
        }

        System.out.print("name(" + cust.getName() + "):");
        String name = CMUtility.readString(10);
        System.out.print("gender(" + cust.getGender() + "):");
        char gender = CMUtility.readChar();
        System.out.print("age(" + cust.getAge() + "):");
        int age = CMUtility.readInt();
        System.out.print("phone(" + cust.getPhone() + "):");
        String phone = CMUtility.readString(13);
        System.out.print("email(" + cust.getEmail() + "):");
        String email = CMUtility.readString(30);

        Customer newCust = new Customer(name, gender, age, phone, email);
        boolean isRep = customerList.replaceCustomer(num - 1, newCust);
        if (isRep) {
            System.out.println("-----------------modify customer list successfully-----------------");
        }else {
            System.out.println("----------------- fail tomodify customer list-----------------------");
        }

    }

    private void deleteCustomer() {

//        System.out.println("delete new customer");
        System.out.println("------------------------delete customer list-----------------------\n");
        Customer cust;
        int num;
        for(;;) {
            System.out.print("chose the id of custom or -1 to exit: ");
            num = CMUtility.readInt();

            if (num == -1) {
                return;
            }
            cust = customerList.getCustomer(num - 1);
            if (cust == null) {
                System.out.println("cannot find the customer");
            }else {
                break;
            }
        }

        System.out.print("sure to delete(Y/N): ");
        char isDel = CMUtility.readConfirmSelection();
        if (isDel == 'Y') {
            boolean b = customerList.deleteCustomer(num - 1);
            if (b) {
                System.out.println("-----------------delete customer list successfully-----------------");
            }else {
                System.out.println("-----------------fails to customer list successfully----------------");
            }
        }
    }

    private void listAllCustomers() {

//        System.out.println("the list of customer");
        System.out.println("------------------------customer list-----------------------\n");

        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("there is no customer");
        } else {
            System.out.println("id\t" + "name\t" + "sex\t\t" + "age\t\t"+ "photo\t\t" + "email");
            Customer[] allCustomers = customerList.getAllCustomers();
            for (int i = 0; i < allCustomers.length; i++) {
                Customer cust = allCustomers[i];
                System.out.println((i + 1) + "\t" + cust.getName() + "\t\t"+ cust.getGender() + "\t\t"+ cust.getAge() + "\t\t"
                                    + cust.getPhone() + "\t\t" + cust.getEmail());

            }
        }

        System.out.println("--------------------customer list  done----------------------");



    }



    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
