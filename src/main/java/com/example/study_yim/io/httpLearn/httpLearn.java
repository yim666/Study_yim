package com.example.study_yim.io.httpLearn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class httpLearn {
    public static void main(String[] args) throws IOException {
        File file = new File("./httpp");
        FileInputStream fileInputStream = new FileInputStream(file);

        int read;
        char pre ='a';
        char cur ='a';
        StringBuilder builder = new StringBuilder();
        while ((read = fileInputStream.read()) != -1){
            cur =(char) read;

            if(pre ==13 && cur ==10){
                break;
            }
            pre =cur;
            if(cur == 32){
                System.out.println(builder.toString().trim());
                builder =new StringBuilder();
            }
            builder.append(cur);

        }

        System.out.println(builder.toString().trim());
    }
}
