package com.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ApiValidationError extends ApiSubError {
   private String object;
   private String field;
   private Object rejectedValue;
   private String message;

   ApiValidationError(String object, String message) {
       this.object = object;
       this.message = message;
   }

@Override
protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
}

@Override
public boolean equals(Object arg0) {
    // TODO Auto-generated method stub
    return super.equals(arg0);
}

@Override
protected void finalize() throws Throwable {
    // TODO Auto-generated method stub
    super.finalize();
}

@Override
public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
}

@Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
}

   
}
