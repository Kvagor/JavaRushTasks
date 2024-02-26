package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = reader.readLine();

            Movie movie = MovieFactory.getMovie(line);
            if(!line.equals("thriller")&&!line.equals("cartoon")&&!line.equals("soapOpera")){
                break;
            }
            else{
                System.out.println(movie.getClass().getSimpleName());
            }
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) throws IOException {
            Movie movie = null;
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    public static class Cartoon extends Movie {

    }

    public static class Thriller extends Movie {

    }


}
