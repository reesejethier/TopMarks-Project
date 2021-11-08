import java.util.Scanner;

public class Test {

    public static void main(String[] args)
    {
        Category test = null;

        Scanner input = new Scanner(System.in);
        double in;

        try {
            test = new Category("", 0, 5);
        } catch (IllegalArgumentException m) {
            System.out.println(m);
        }

        if(test != null) {
            try {
                test.addAssignment(null);
            } catch (NullPointerException m) {
                System.out.println(m);
            } catch (IllegalArgumentException m) {
                System.out.println(m);
            }

            for(int i = 0; i < 10; i++) {
                System.out.print(i + ": ");
                in = input.nextDouble();
                try {
                    test.addAssignment(new Assignment("bob", in));
                } catch (NullPointerException m) {
                    System.out.println(m);
                } catch (IllegalArgumentException m) {
                    System.out.println(m);
                }
            }
            try {
                System.out.println(test.getAssignment(0));
            } catch (IllegalArgumentException m) {
                System.out.println(m);
            }


            System.out.println(test.getCategoryGrade());

            try{
                test.removeAssignment("bob");
            } catch(IllegalArgumentException m){
                System.out.println(m);
            }

            try{
                test.removeAssignment(0);
            } catch(IllegalArgumentException m){
                System.out.println(m);
            }

        }



    }
}
