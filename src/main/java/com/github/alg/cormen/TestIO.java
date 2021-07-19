package com.github.alg.cormen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class TestIO {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<String> str_in = new ArrayList<>();

            String input;
            do{
                input = br.readLine();
                str_in.add(input);
                if(input.equals("!q")) break;
            }while(!input.equals("!q"));

            FileOutputStream fout = new FileOutputStream("test.txt");

            Iterator<String> itr = str_in.iterator();


            while(itr.hasNext()){
                fout.write(itr.next().toString().getBytes(StandardCharsets.UTF_8));
                fout.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
