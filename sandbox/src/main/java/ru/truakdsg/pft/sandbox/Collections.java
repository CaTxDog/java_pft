package ru.truakdsg.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "Php"};

    List<String> languages = Arrays.asList(langs);

    for (String l : languages) {
      System.out.println(l);
    }
  }
}
