package util;

import java.util.Arrays;

public class CRC {

    /**
     * CRC计算器
     *
     * @param data       数据流
     * @param polynomial 多项式
     * @return CheckCode
     */
    public static char[] Calculate(char[] data, String polynomial) {
        //TODO
        int num = polynomial.length()-1;
        StringBuilder str = new StringBuilder();
        char[] data1= new char[data.length+num];
        for(int i = 0;i<data1.length;i++){
            if(i<data.length)
            data1[i]=data[i];
            else {
                data1[i]='0';
            }
        }
        for(int i = 0;i <= num; i++) {
            str.append(0);
        }
        int t = 0;
        while(t<data1.length) {
            if(str.charAt(0) == '0') {
                str.delete(0, 1);
                str.append(data1[t]);
                t++;
                if(t==data1.length&&str.charAt(0)=='0'){
                    int u =Ha(str.toString());
                    str.delete(0,str.length());
                    str.append(Integer.toBinaryString(u));
                }else if(t==data1.length&&str.charAt(0)=='1'){
                    int u = Ha(polynomial)^Ha(str.toString());
                    str.delete(0,str.length());
                    str.append(Integer.toBinaryString(u));
                }
            }else{
                int p = Ha(polynomial)^Ha(str.toString());
                str.delete(0,str.length());
                str.append(Integer.toBinaryString(p));
                if(str.length()!=polynomial.length()){
                    int i =0;
                    while(i<polynomial.length()-str.length())
                    str.insert(0,"0");
                }
            }
        }
        if(str.length()!=polynomial.length()-1){
            int i =0;
            while(i<polynomial.length()-str.length()-1)
                str.insert(0,"0");
        }
        return str.toString().toCharArray();
    }

    public static int Ha(String binary){
        String[] str = binary.split("");
        int k =0;
        for(int i = 0;i<str.length;i++){
            k = k+(int) (Integer.parseInt(str[i])*Math.pow(2,str.length-i-1));
        }
        return k;
    }

    public static String Kalculate(char[] data, String polynomial) {
        //TODO
        int num = polynomial.length()-1;
        StringBuilder str = new StringBuilder();
        char[] data1= new char[data.length+num];
        for(int i = 0;i<data1.length;i++){
            if(i<data.length)
                data1[i]=data[i];
            else {
                data1[i]='0';
            }
        }
        for(int i = 0;i <= num; i++) {
            str.append(0);
        }
        int t = 0;
        while(t<data1.length) {
            if(str.charAt(0) == '0') {
                str.delete(0, 1);
                str.append(data1[t]);
                t++;
            }else if(str.length()==polynomial.length()){
                int p = Ha(polynomial)^Ha(str.toString());
                str.delete(0,str.length());
                str.append(Integer.toBinaryString(p));
                if(str.length()!=polynomial.length()){
                    int i =0;
                    while(i<polynomial.length()-str.length())
                        str.insert(0,"0");
                }
            }
        }
        int u = Ha(polynomial)^Ha(str.toString());
        str.delete(0,str.length());
        str.append(Integer.toBinaryString(u));


        return str.toString();
    }

    /**
     * CRC校验器
     *
     * @param data       接收方接受的数据流
     * @param polynomial 多项式
     * @param CheckCode  CheckCode
     * @return 余数
     */
    public static char[] Check(char[] data, String polynomial, char[] CheckCode) {
        //TODO
        char[] data2 = new char[data.length+polynomial.length()-1];
        for(int i = 0;i<data.length;i++) data2[i]=data[i];
        for(int i = 0;i<CheckCode.length;i++) data2[data.length+i]=CheckCode[i];
        char[] cha=Calculate(data2,polynomial);
        char[] r = new char[polynomial.length()-1];
        for(int i =0;i<polynomial.length()-1;i++) r[i]='0';
        if(cha[0]=='0'){
            return r;
        }
        else{
            return cha;

        }

    }

}
