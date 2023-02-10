package com.gmail.vasyl.gromov;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //System.out.println("Input your text:");
        //String inputStr = sc.nextLine();
        //String inputStr = "The Tao gave birth to machine language.  Machine language gave birth to the assembler. The assembler gave birth to the compiler.  Now there are ten thousand languages. Each language has its purpose, however humble.  Each language expresses the Yin and Yang of software.  Each language has its place within        the Tao.        But do not program in COBOL if you can avoid it.        -- Geoffrey James, \"The Tao of Programming\" ";
        String inputStr = "C makes it easy for you to shoot yourself in the foot. C++ makes that harder, but when you do, it blows away your whole leg. (с) Bjarne Stroustrup";

        String[] values = inputStr.replaceAll("[^a-zA-Z]+", " ").split("[,\\s]+"); // Прибираємо зайві символи
        char[] finalArray = new char[values.length];

        for (int i = 0; i < values.length; i++) {
            finalArray[i] = findFirstUniqueSymbolInWord(values[i]); // Знаходимо перший унікальний символ у слові і зависуємо у масив унікальних символів
        }

        finalArray = removeOneFromCharArray(finalArray); // Видаляємо символи слів, в яких нема унікальних символів

        char uniqueSymbol = findFirstUniqueSymbolInArray(finalArray);

        System.out.println(inputStr);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(finalArray));
        System.out.println(uniqueSymbol);

    }

    public static char findFirstUniqueSymbolInWord (String str) {
        char[] word = str.toCharArray();
        char uniqueSymbol;

        for (int i = 0; i <= word.length-1; i++) {
            uniqueSymbol = word[i];


            for (int j = 0; j <= word.length-1; j++) {

                if (uniqueSymbol==(word[j]) && i != j){
                    break;
                }

                if (j==word.length-1) {
                    return uniqueSymbol;
                }
            }
        }
        return '1';  // нема унікальних символів
    }

    public static char findFirstUniqueSymbolInArray (char[] arr) {
        char uniqueSymbol;

        for (int i = 0; i <= arr.length-1; i++) {
            uniqueSymbol = arr[i];


            for (int j = 0; j <= arr.length-1; j++) {

                if (uniqueSymbol==(arr[j]) && i != j){
                    break;
                }

                if (j==arr.length-1) {
                    return uniqueSymbol;
                }
            }
        }
        return '1';  // нема унікальних символів
    }

    public static char[] removeOneFromCharArray (char[] arr) {
        String arrString = new String(arr);
        String stringWithoutOne = arrString.replaceAll("[1]","");
        char[] charWithoutOne = stringWithoutOne.toCharArray();

        return charWithoutOne;
    }
}
