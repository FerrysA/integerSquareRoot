
import java.util.Random;
import java.util.Scanner;// библ для ввода с клавиатуры

public class Main {

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


    private static Scanner inn = new Scanner(System.in);// метод для ввода с клавиатуры

    public static <string> void main(String[] args) {

        System.out.println("////////  Тест  /////////");

        System.out.print("число : ");
        String d = "310014372647340450203169";
        System.out.println(d);

        String c = Pro(d, d);// возвели в квадрат число д
        System.out.print("Квадрат числа : ");
        System.out.println(c);

        System.out.print("Квадратный корень из квадрата : ");
        System.out.println(sqr(c));// извлекли корень


    }
}

