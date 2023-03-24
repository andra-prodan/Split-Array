//Explicatii extra se afla in fisierul info.txt

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int Average(ArrayList array){
        int sum = 0;
        if (array.isEmpty()){
            return 0;
        }else {
            for (int i = 0; i < array.size(); i++) {
                sum = sum + (int) array.get(i);
            }
            return sum / array.size();
        }
    }

    public static ArrayList Dublicate (ArrayList array){
        ArrayList<Integer> dublicate = new ArrayList<Integer>();
        for (int i = 0; i<array.size(); i++){
            for (int j = i+1; j<array.size(); j++){
                if(array.get(i)==array.get(j)){
                    dublicate.add((int)array.get(j));
                }
            }
        }
        return dublicate;
    }

    public static boolean SplitArray(ArrayList array){
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        ArrayList<Integer> aux = new ArrayList<Integer>(array);

        int avg = Average(array);

        for (int i = 0; i<=array.size()/2; i++){
            for (int j = i; j<array.size()/2+i; j++){
                array1.add((int)array.get(j));
            }
            if (Average(array1)!=avg){
                array1.clear();
            }else {
                for (int k = 0; k<array.size(); k++){
                    if(!(array1.contains(array.get(k)))){
                        array2.add((int)array.get(k));
                    }
                }
                if(Dublicate(array)!=null){
                    array2.addAll(Dublicate(array));
                }
                break;
            }
        }

        System.out.println("One half of the array is: " + array1);
        System.out.println("Second half of the array is: " + array2);

        if (Average(array1)==Average(array2) && Average(array1)==avg && Average(array2)==avg){
            return true;
        }else return false;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        System.out.println("Length of array: ");
        int length = in.nextInt();
        System.out.println("Add array elements: ");
        for (int i = 0; i<length; i++){
            array.add(in.nextInt());
        }
        System.out.println("The array: "+array);
        System.out.println(SplitArray(array));

    }
}