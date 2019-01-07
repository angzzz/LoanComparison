package com.anjaleeps.loancomparison;

public class Entry {
    private String string;
    private int id;

   public Entry(int id,String string){
       this.string=string;
       this.id=id;
   }

   public String getString(){
       return this.string;
   }
}
