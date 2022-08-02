public class homework_day3 {

    public static void main(String[] args) {

        //Homework#1
        System.out.println("Homework#1");
        System.out.println( primeNumber(10));
        //Homework#2
        System.out.println("Homework#2");
        System.out.println("The calculated tax is: "+calculateTax(100));
        //Homework#3
        System.out.println("Homework#3");
        System.out.println(palindrome("boob"));

    }//end main

    //Homework#1
    public static String primeNumber(int a){//start primeNumber
        int min=a/2;//because a number is not divisible by more than its half
        if(a==0||a==1)
            return a+" is not a prime number";
        for (int i = 2; i <min ; i++)
            if(a%i==0)
                return a+" is not a prime number";

        return a+" is a prime number";
    }//end primeNumber

    //Homework#2
    public static double calculateTax (double price){//start calculateTax

        if (price<100||price>500){
            System.out.println(price+" out of the range");
            return 0;
        }
        return price * 15/100;
    }//end calculateTax


    //Homework#3
    public static String palindrome(String word){//start palindrome

        int start=0;
        int end=word.length()-1;

            while (start < end) {
                if ((word.charAt(start) != word.charAt(end)))
                    return word + " is not palindrome ";
                start++;
                end--;
            }
            return word + " is  palindrome ";

    }//end palindrome

}//end class homework_day3


