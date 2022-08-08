package day2.lastjava;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<PayAble> arrayList=new ArrayList<PayAble>();


    public Company(String name) {
        this.name = name;
    }

    public boolean add(PayAble b){
        arrayList.add(b);
        return true;
    }

    public double computeAmount(){
        double sum=0;
        for (int i = 0; i < arrayList.size(); i++)
            sum+=arrayList.get(i).computeAmount();

        return sum;
        }



    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", arrayList=" + arrayList +
                '}';
    }
}
