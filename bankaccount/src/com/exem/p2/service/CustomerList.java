package com.exem.p2.service;

import com.exem.p2.bean.Customer;

/**
 * @Description  CRUD
 *
 */
public class CustomerList {
    private Customer[] customers;
    private int total;

    /**
     * constructors init customer array
     * @param totalCustomer, the maxlength
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * add customs to array
     * @param customer
     * @return true: add successfully false: fails to add
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total++] = customer;
         return true;
    }

    /**
     * @Des, modify
     * @param index
     * @param cust
     * @return
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index > total) {
            return false;
        }

        customers[index] = cust;
        return true;

    }

    /**
     * @Delete
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index > total) {
            return false;
        }

        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }

//        customers[total - 1] = null;
//        total--;
        customers[--total] = null;
        return true;

    }
      public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
      }

      public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }

        return customers[index];
      }

      public int getTotal() {
        return total;
      }
}
