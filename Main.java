package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        //задание 1
        //ввод с коносли N произвольных чисел и запись в массив
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Vvedite dlinny masiva: ");
        int [] arr = new int[Integer.parseInt(reader.readLine())];
        System.out.println("Vvodite elementi masiva: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        //задание 2,3
        //сортировка по возрастанию и вывод в консоль (пузырьком)
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
        System.out.println("Massiv - " + Arrays.toString(arr));

        //задание 4
        //поиск елемента в массиве
        System.out.println("Vvedite chislo dlya poiska: ");
        int searchNumb = Integer.parseInt(reader.readLine());
        boolean isFind = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==searchNumb){
                System.out.println("Index elementa = " + i);
                break;
            }
        }

        //задание 5
        //вызов функции бинарного поиска в массиве
        System.out.println("Vvedite chislo dlya binarnogo poiska: ");
        int binarySearchNumb = Integer.parseInt(reader.readLine());
        int first = 0; //первый элемент массива
        int last = arr.length - 1; //последний элемент массива
        int foundIndex = binarySearch(arr, binarySearchNumb, first, last);
        System.out.println("Index elementa = " + foundIndex);

        //задание 6
        //сортировка массива строк
        System.out.println("Vvedite dlinny masiva strok: ");
        System.out.println("Vvodite elementi masiva: ");
        String [] strArr = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = reader.readLine();
        }
        Arrays.sort(strArr, new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
        System.out.println("Otsortirovaniy masiv: " + Arrays.toString(strArr));
    }

    //бинарный поиск
    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
