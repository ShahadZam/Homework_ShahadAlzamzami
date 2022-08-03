package homework_day4;

public class Customer {
    private int ID;
    private String name;
    private char gender;

    public Customer(int ID, String name, char gender) {
        if (gender!='m'&&gender!='f'&&gender!='M'&&gender!='F'){
            throw new RuntimeException("There is only male and female, enter it as 'f' or 'm'");
        }
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "(" +
                name +
                ","+ID+")";
    }
}
