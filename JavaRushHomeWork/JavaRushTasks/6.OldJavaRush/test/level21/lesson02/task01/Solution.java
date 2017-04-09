package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000

        int n = ip[0];
        byte digit = 0;
        StringBuffer sb = new StringBuffer();
        while (n != 0)
        {
            sb.insert(0, n & 1);
            n = n >> 1;
        }
        System.out.print(sb + ".");

    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] itog = new byte[4];
        for (int i = 0; i < 4; i++){
            itog[i] = (byte) (ip[i] & mask[i]);
        }
        return itog;
    }

    public static void print(byte[] bytes) {
        for (byte by: bytes){
            //String  a = Integer.toBinaryString(by & 0xff);
            //System.out.print(String.format(Integer.toBinaryString(by & 0xff) + " "));

            String a = Integer.toBinaryString(256 + (int) by);
            System.out.print(a.substring(a.length() -8) + " ");

        }
        System.out.println("");
    }
}
