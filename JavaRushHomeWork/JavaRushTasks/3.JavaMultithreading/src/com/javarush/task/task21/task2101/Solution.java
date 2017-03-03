package com.javarush.task.task21.task2101;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] it = new byte[4];
        for (int i = 0; i < ip.length; i++) {
            it[i] = (byte) (ip[i] & mask[i]);
        }
        return it;
    }

    public static void print(byte[] bytes) {
        int[] itog = new int[4];
        for (int i = 0; i < bytes.length; i++) {
            int x = Byte.toUnsignedInt(bytes[i]);
            itog[i] = Integer.parseInt(Integer.toString(x, 2));
        }
        for (int d : itog) {
            System.out.format("%08d ", d);
        }
        System.out.println("");
    }
}
