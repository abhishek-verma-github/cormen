package com.github.alg.cormen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class TestIO {
    public static void main(String[] args) {
        ArrayList<String> str_in = new ArrayList<>();
        BufferedReader br = null;
        FileOutputStream fout = null;
        String input;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            fout = new FileOutputStream("test.txt");
            do{
                input = br.readLine();
                if(input.equals("!q")) break;
                str_in.add(input);
            }while(!input.equals("!q"));

            Iterator<String> itr = str_in.iterator();

            while(itr.hasNext()){
                fout.write(itr.next().toString().getBytes(StandardCharsets.UTF_8));
                fout.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        }
        catch (IOException e){e.printStackTrace();}
        finally {
            try {
                if(fout != null) fout.close();
            }catch(IOException e){e.printStackTrace();}
        }


    }
}
