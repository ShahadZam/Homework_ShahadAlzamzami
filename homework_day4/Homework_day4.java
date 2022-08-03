package homework_day4;

public class Homework_day4 {

    public static void main(String[] args) {//start main

        //Homework#1
        int arr[]={5,3,4,2,1,-9};
        try {
            System.out.println("The smallest number in the array is:"+getSmallPositive(arr));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //Homework#2
        try {
            Customer customer1 = new Customer(1, "sarah", 'f');
            System.out.println("customerId: "+customer1.getID()+"customer name: "+customer1.getName()
                    +"customer Gender: "+customer1.getGender());
            Customer customer2=new Customer(2,"Ali",'M');
            System.out.println(customer2);
            Customer customer3=new Customer(3,"T",'t');
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }//end main

    //homework#1
    public static int getSmallPositive(int[] numbers) throws RuntimeException{
        int min=numbers[0];
        for (int i = 0; i < numbers.length ; i++) {
            if (numbers[i]<0)
                throw new RuntimeException("you can't enter a negative number");

            if(numbers[i]<min)
                min=numbers[i];
        }
        return min;
    }

}//end class
