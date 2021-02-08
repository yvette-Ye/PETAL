package com.petal.demo.tools;

import com.sun.istack.Nullable;

public class loginRes {
    private Boolean flag;
    private String Message;
    private Object objectImp;

    public loginRes() {
    }

    public loginRes(Boolean flag, String message, Object objectImp) {
        this.flag = flag;
        Message = message;
        this.objectImp = objectImp;
    }

    @Override
    public String toString() {
        return "loginRes{" +
                "flag=" + flag +
                ", Message='" + Message + '\'' +
                ", objectImp=" + objectImp +
                '}';
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Object getObjectImp() {
        return objectImp;
    }

    public void setObjectImp(Object objectImp) {
        this.objectImp = objectImp;
    }
}
