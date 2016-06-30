package steps;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GreatestDecentNumber {
    private int fives = 0;
    private int threes = 0;

    public void printResult(){
        if(fives < 0 || threes < 0){
            System.out.println(-1);
            return;
        }

        //generate 'decent number'
        for(int i = 0; i < fives; i++){
            System.out.print(5);
        }

        for(int i = 0; i < threes; i++){
            System.out.print(3);
        }
    }

    public boolean findComponents(int size){
        fives = size;
        while(fives%3 != 0){
            fives -= 5;
        }
        if(fives < 0) {
            fives = -1;
            threes = -1;

            return false;
        }
        threes = size - fives;

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GreatestDecentNumber gdn = new GreatestDecentNumber();
        int size = in.nextInt();

        gdn.findComponents(size);
        gdn.printResult();
    }
}
