# integerSquareRoot-2kyu
# 25.11.2022
# [cылка на задание]( https://www.codewars.com/kata/58a3fa665973c2a6e80000c4)
# Код:
```java
    public static String Pro(String a, String b) {

        if (a_Equals_b(a, "0") || a_Equals_b(b, "0")) {
            return "0";
        }

        int n = a.length();
        int m = b.length();
        int k = 0;
        String res = "0";
        int vume = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        String delta = "0";


        for (int i = 1; i <= m; i++) {

            delta = pro(a, Character.toString(b.charAt(m - i)));


            for (int j = 1; j < i; j++) {
                delta += "0";
            }


            res = Sum(delta, res);


        }

        if (vume != 0) {
            res += vume;
        }


        return res;
    }

    public static String pro(String a, String b) {
        int n = a.length();

        if (a_Equals_b(a, "0") || a_Equals_b(b, "0")) {
            return "0";
        }
        int k = 0;
        String res = "";
        int vume = 0;
        int x = 0;
        int y = 0;
        int z = 0;


        for (int i = 1; i <= n; i++) {
            x = Character.digit(a.charAt(n - i), 10);
            y = Character.digit(b.charAt(0), 10);
            z = x * y;
            res += (z + vume) % 10;
            vume = (z + vume) / 10;

        }

        if (vume != 0) {
            res += vume;
        }

        String tmp = res;
        k = res.length();
        res = "";
        int cont = 0;
        for (int i = 0; i < k; i++) {
            if (tmp.charAt(k - i - 1) == '0' && cont == 0) {
                continue;
            }
            cont = 1;
            res += Character.toString(tmp.charAt(k - i - 1));

        }

        return res;
    }

    public static String Sum(String a, String b) {
        if (a_Equals_b(a, "0")) {
            return b;
        }
        if (a_Equals_b(b, "0")) {
            return a;
        }
        int n = a.length();
        int m = b.length();
        int k = 0;
        String res = "";
        int vume = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int zres = 0;
        int min = Math.min(n, m);


        for (int i = 1; i <= min; i++) {
            x = Character.digit(a.charAt(n - i), 10);
            y = Character.digit(b.charAt(m - i), 10);
            z = x + y;
            res += (z + vume) % 10;
            vume = (z + vume) / 10;

        }
        if (n > m) {
            for (int i = m + 1; i <= n; i++) {
                x = Character.digit(a.charAt(n - i), 10);
                y = 0;
                z = x + y;
                res += (z + vume) % 10;
                vume = (z + vume) / 10;

            }

        }
        if (m > n) {
            for (int i = n + 1; i <= m; i++) {
                y = Character.digit(b.charAt(m - i), 10);
                x = 0;
                z = x + y;

                res += (z + vume) % 10;
                vume = (z + vume) / 10;

            }

        }
        if (vume == 1) {
            res += vume;
        }

        String tmp = res;
        k = res.length();
        res = "";
        int cont = 0;
        for (int i = 0; i < k; i++) {
            if (tmp.charAt(k - i - 1) == '0' && cont == 0) {
                continue;
            }
            cont = 1;
            res += Character.toString(tmp.charAt(k - i - 1));

        }

        return res;
    }

    public static String Sub(String a, String b) {
        if (a_Equals_b(b, "0")) {
            return a;
        }

        if (a_Equals_b(a, b)) {
            return "0";
        }
        int n = a.length();
        int m = b.length();
        int k = 0;
        String res = "";
        int vume = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int zres = 0;
        int min = Math.min(n, m);


        for (int i = 1; i <= min; i++) {
            x = Character.digit(a.charAt(n - i), 10);
            y = Character.digit(b.charAt(m - i), 10);
            z = x - y;
            if (z < 0) {
                z += 10;

                res += (z + vume);
                vume = -1;
                continue;
            }
            if (z == 0 && vume == -1) {
                res += 9;
                vume = -1;
                continue;
            }
            res += (z + vume);
            vume = 0;

        }

        if (vume == 1) {
            res += vume;
        }

        String tmp = res;
        k = res.length();
        res = "";
        int cont = 0;
        for (int i = 0; i < k; i++) {
            if (tmp.charAt(k - i - 1) == '0' && cont == 0) {
                continue;
            }
            cont = 1;
            res += Character.toString(tmp.charAt(k - i - 1));

        }

        return res;
    }

    public static boolean a_Greater_Equal_b(String a, String b) {

        int n = a.length();
        int m = b.length();
        int DimA = n;
        int DimB = m;
        int StartA = 0;
        int StartB = 0;

        {// находим размерность с учетом нулей впереди числа
            for (int i = 0; i < n; i++) {
                if ((Character.digit(a.charAt(i), 10) != 0)) {
                    break;
                }
                DimA--;
                StartA++;
            }
            for (int i = 0; i < m; i++) {
                if ((Character.digit(b.charAt(i), 10) != 0)) {
                    break;
                }
                DimB--;
                StartB++;
            }

        }


        if (DimA > DimB) {
            return true;
        }
        if (DimA < DimB) {
            return false;
        }

        for (int i = 0; i < DimA; i++) {
            if ((Character.digit(a.charAt(StartA + i), 10)) > (Character.digit(b.charAt(StartB + i), 10))) {
                return true;
            }
            if ((Character.digit(a.charAt(StartA + i), 10)) < (Character.digit(b.charAt(StartB + i), 10))) {
                return false;
            }
            if ((Character.digit(a.charAt(StartA + i), 10)) == (Character.digit(b.charAt(StartB + i), 10))) {
                continue;
            }
        }

        return true;
    }

    public static boolean a_Equals_b(String a, String b) {

        int n = a.length();
        int m = b.length();
        int DimA = n;
        int DimB = m;
        int StartA = 0;
        int StartB = 0;

        {// находим размерность с учетом нулей впереди числа
            for (int i = 0; i < n; i++) {
                if ((Character.digit(a.charAt(i), 10) != 0)) {
                    break;
                }
                DimA--;
                StartA++;
            }
            for (int i = 0; i < m; i++) {
                if ((Character.digit(b.charAt(i), 10) != 0)) {
                    break;
                }
                DimB--;
                StartB++;
            }

        }


        if (DimA > DimB) {
            return false;
        }
        if (DimA < DimB) {
            return false;
        }

        for (int i = 0; i < DimA; i++) {
            if ((Character.digit(a.charAt(StartA + i), 10)) > (Character.digit(b.charAt(StartB + i), 10))) {
                return false;
            }
            if ((Character.digit(a.charAt(StartA + i), 10)) < (Character.digit(b.charAt(StartB + i), 10))) {
                return false;
            }
            if ((Character.digit(a.charAt(StartA + i), 10)) == (Character.digit(b.charAt(StartB + i), 10))) {
                continue;
            }
        }

        return true;
    }


    public static String sqr(String n) {


        int len = n.length();
        int sm = (1 + len) / 2;
        String snos[] = new String[sm];
        String delta = "0";
        String ost = "0";
        String res = "0";
        String find = "1";


        if (len % 2 == 0) {
            for (int i = 0; i < sm; i++) {

                snos[i] = n.substring(2 * i, 2 * i + 2);
            }
        }
        if (len % 2 == 1) {
            for (int i = 0; i < sm; i++) {
                if (i == 0) {

                    snos[0] = n.substring(0, 1);
                    continue;
                }
                snos[i] = n.substring(2 * i - 1, 2 * i + 1);
            }
        }

        for (int i = 0; i < sm; i++) {

            int findI = -1;
            String findRem = "0";
            String deltaRem = "0";
            String ff = "0";


            if (i == 0) {
                String findRemm = "1";
                String fff = "1";
                int findII = 1;

                while (a_Greater_Equal_b(snos[0], fff)) {

                    findII++;
                    findRemm = find;
                    find = Integer.toString(findII);

                    fff = Pro(find, find);
                }
                res = findRemm;
                ost = Sub(snos[0], Pro(findRemm, findRemm));
                continue;
            }

            delta = Pro(res, "2");// умножаем на 2
            deltaRem = delta;
            ost += snos[i];
            find = "-1";


            while (a_Greater_Equal_b(ost, ff)) {
                findRem = find;
                findI++;
                find = Integer.toString(findI);
                delta = Sum(Pro(deltaRem, "10"), find);
                ff = Pro(delta, find);


            }


            if (findRem == "-1") {
                res += 0;
                continue;


            }
            res += findRem;
            delta = deltaRem + findRem;

            String sss = Pro(delta, findRem);
            String ostRem = ost;
            ost = Sub(ost, sss);

        }


        return res;
    }

    public static String Fact(int n) {
        if (n == 0) {
            return "1";
        }

        return Pro(Integer.toString(n), Fact(n - 1));
    }
```
# понравивщееся решение:(автор Aemeth)
``` java
public static String integerSquareRoot(String n) {
    
    //Do the small ones just using long arithmetic
    if (n.length() < 19) {
      long l = Long.valueOf(n);
      return "" + (long)Math.sqrt(l);
    }

    //Convert the String to an int[] to make
    //the digit-by-digit arithemtic simpler.
    int[] number = new int[n.length()];
    for (int i = 0; i < n.length(); i++) {
      number[i] = digitToInt(n.charAt(i));
    }
    
    //Create an int[] to hold the guess for the root.
    //It has either ||n||/2 digits or (||n|| + 1)/2 digits.
    int digits = (n.length() + 1)/2;
    int[] guess = new int[digits];
    
    //Starting from the most significant digit, keep incrementing
    //the digit until the guess squared is bigger than the target
    //number, then reduce the digit by one and move on.
    //If the digit is 9, just move on anyway.
    int curr = 0;
    while (curr  < guess.length) {
      if (guess[curr] == 9) curr++;
      else {
        guess[curr]++;
        if (greaterThan(square(guess), number)) {
          guess[curr]--;
          curr++;
        }
      }
    }
    
    //Convert back to a String and return.
    return toString(guess);
  }
           
  //Naive long multiplication to get the square of the
  //parameter.
  private static int[] square(int[] n) {
    int[] result = new int[n.length*2];
    for (int i = n.length - 1; i >= 0; i--) {
      int carry = 0;
      for (int j = n.length - 1; j >= 0; j --) {
        result[i + j + 1] += carry + n[j] * n[i];
        carry = result[i + j + 1] / 10;
        result[i + j + 1] %= 10;
      }
      result[i] += carry;
    }
    return result;
  }
  
  //Simple greater than method to compare two int[]s that
  //represent numbers.
  private static boolean greaterThan(int[] n, int[] m) {
    int npos = 0;
    int mpos = 0;
    
    while (n[npos] == 0) npos++;
    while (m[mpos] == 0) mpos++;
    
    if (n.length - npos > m.length - mpos) return true;
    if (n.length - npos < m.length - mpos) return false;
    
    for (int i = 0; npos + i < n.length; i++) {
      if (n[npos + i] > m[mpos + i]) {
        return true;
      }
      else if (n[npos + i] < m[mpos + i]) {
        return false;
      }
    }
   
    return false;
  }

  //Silly helper method to convert chars to ints
  //without worrying about codepoint values or weird
  //encoding issues.
  private static int digitToInt(char c) {
     switch (c) {
        case '0' : return 0;
        case '1' : return 1;
        case '2' : return 2;
        case '3' : return 3;
        case '4' : return 4;
        case '5' : return 5;
        case '6' : return 6;
        case '7' : return 7;
        case '8' : return 8;
        case '9' : return 9;
        default : return -1;
    }   
  }
  
  //Convert between int[] and String representations of
  //a number.
  private static String toString(int[] number) {
    int start = 0;
    while (number[start] == 0) start++;
    String result = "";
    for (int i = start; i < number.length; i++) result += number[i];
    return result;
  }
} 

