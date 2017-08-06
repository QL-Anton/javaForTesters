package ru.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Антон on 07.08.2017.
 */
public class Collection {

  public static void main (String[] args){
    String[] langs=new String[4];

    List languages= Arrays.asList("java","c#");



    for (Object l:languages){
      System.out.println("lalalal "+l);

    }
  }
}
