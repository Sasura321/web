package com.edu.no_3;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerBean implements Serializable {

    private  String custName;
    private String email;
    private String phone;
    private boolean valid;
    public CustomerBean() {}
    public CustomerBean(String custName,String email,String phone,boolean valid)
    {
        this.custName=custName;
        this.email=email;
        this.phone=phone;
        this.valid=valid;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isValid() {
        return valid;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
