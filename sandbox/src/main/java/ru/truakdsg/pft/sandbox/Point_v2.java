package ru.truakdsg.pft.sandbox;
//Тестовая версия с ручным вводом и контролем входящей строки только на цифры (до просмотра лекции про классы и методы)

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Point_v2 {
//Проверка строки через регулярку
  public static int getInt()
  {
    Scanner in = new Scanner(System.in);
    String s = null;
    Pattern p = Pattern.compile("^\\d+$");
    Matcher m = null;

    do
    {
      System.out.print("(Введите число) ");
      s = in.nextLine();
      m = p.matcher(s);
    } while(!m.matches());

    return Integer.parseInt(s);
  }
//неоптимизированная функция
  public static double distance(double x1, double y1, double x2, double y2)
  {
    double dis = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    return dis;
  }
//ручной ввод
   public static void main(String[] args) {
     System.out.print ("P1.x = ");
     double x1 = (double)getInt();
     System.out.print("P1.y = ");
     double y1 = (double)getInt();
     System.out.print("P2.x = ");
     double x2 = (double)getInt();
     System.out.print("P2.y = ");
     double y2 = (double)getInt();
     System.out.println("Длинна между точками P1("+x1+","+y1+") и P2("+x2+","+y2+") = " + distance(x1,y1,x2,y2));
   }
}
