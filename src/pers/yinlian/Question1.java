package pers.yinlian;

import java.util.ArrayList;
import java.util.Scanner;
public class Question1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<String> arg = new ArrayList<String>();
//        String str = sc.nextLine();
//        String[] strs = str.split(" ");
//        int n =Integer.valueOf(strs[0]);
//        int m =Integer.valueOf(strs[1]);
////        while(sc.hasNextLine()){
////            arg.add(sc.nextLine());
////        }
////        for (int i = 0; i <arg.size(); i++) {
////            System.out.println(arg.get(i));
////        }
//        System.out.println(m);
//        System.out.println(n);
        //第一题
        Scanner sc = new Scanner(System.in);
        int questionNum = Integer.valueOf(sc.nextLine());
        ArrayList<char[][]> list = new ArrayList<char[][]>();
        for(int i = 0;i<questionNum;i++){
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int n =Integer.valueOf(strs[0]); //行
            int m =Integer.valueOf(strs[1]); //列
            char[][] matirx = new char[n][m];
            for(int j = 0;j<n;j++){
                String row = sc.nextLine();
                matirx[j] = row.toCharArray();
                list.add(matirx);
            }
        }

    }
}
