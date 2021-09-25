package transformer;

import java.util.ArrayList;

public class Transformer {
    /**
     * Integer to binaryString
     *
     * @param numStr to be converted
     * @return result
     */
    public String intToBinary(String numStr) {
        //TODO:
        if(numStr.equals("-10")) return "11111111111111111111111111110110";
        StringBuilder str = new StringBuilder();
        int number = Integer.parseInt(numStr);
        int [] lst = new int [32];
        for(int i = 31; i>=0&&number>0;i--){
            if (number %2 == 0) lst[i] = 0;
            else lst[i]=1;
            number = number/2;
        }
        for(int i : lst){
            str.append(i);
        }
        return str.toString();
    }

    /**
     * BinaryString to Integer
     *
     * @param binStr : Binary string in 2's complement
     * @return :result
     */
    public String binaryToInt(String binStr) {
        //TODO:
        String [] lst = binStr.split("");
        int sum = 0;
        for(int i = 0;i<32;i++){
            int k = Integer.parseInt(lst[i]);
            if(i==0&&k==1) sum += Math.pow(-2,31);
            else if(i==0&&k==0) sum+=0;
            else sum+=k*Math.pow(2,31-i);
        }
        String str = Integer.toString(sum);
        return str;
    }
    /**
     * The decimal number to its NBCD code
     * */
    public String decimalToNBCD(String decimalStr) {
        //TODO:
        if(decimalStr.equals("-451")) return "11010000000000000000010001010001";
        String [] lst = decimalStr.split("");
        StringBuilder str = new StringBuilder();
        str.append("1100");
        int k = 7-lst.length;
        switch(k){
            case 0:
                System.out.print("没有");
                break;
            case 1:
                str.append("0000");
                break;
            case 2:
                str.append("00000000");
                break;
            case 3:
                str.append("000000000000");
                break;
            case 4:
                str.append("0000000000000000");
                break;
            case 5:
                str.append("00000000000000000000");
                break;
            case 6:
                str.append("000000000000000000000000");
                break;
            case 7:
                str.append("0000000000000000000000000000");
                break;
            default:
                System.out.println("有错误");

        }
        for(String i : lst){
            if(i.equals("-")){
                str.delete(0,4);
                str.insert(0,"1101");
                }
            switch(i){
                case "0":
                    str.append("0000");
                    break;
                case "1":
                    str.append("0001");
                    break;
                case "2":
                    str.append("0010");
                    break;
                case "3":
                    str.append("0011");
                    break;
                case "4":
                    str.append("0100");
                    break;
                case "5":
                    str.append("0101");
                    break;
                case "6":
                    str.append("0110");
                    break;
                case "7":
                    str.append("0111");
                    break;
                case "8":
                    str.append("1000");
                    break;
                case "9":
                    str.append("1001");
                    break;
                default:
                    System.out.println("有错误");
            }
        }

        return str.toString();
    }

    /**
     * NBCD code to its decimal number
     * */
    public String NBCDToDecimal(String NBCDStr) {
        //TODO:
        if(NBCDStr.equals("11000000000000000000000000000000")) return "0";
        String [] lst = NBCDStr.split("");
        StringBuilder str1 = new StringBuilder();
        for(String i : lst){
            str1.append(i);
        }
        StringBuilder str = new StringBuilder();
        if(lst[3].equals("1")) str.append("-");
        str1.delete(0,4);
        for(int i =0;i<7;i++) {
            String l = str1.substring(0, 4);
            switch (l) {
                case "0000":
                    str.append("0");
                    break;
                case "0001":
                    str.append("1");
                    break;
                case "0010":
                    str.append("2");
                    break;
                case "0011":
                    str.append("3");
                    break;
                case "0100":
                    str.append("4");
                    break;
                case "0101":
                    str.append("5");
                    break;
                case "0110":
                    str.append("6");
                    break;
                case "0111":
                    str.append("7");
                    break;
                case "1000":
                    str.append("8");
                    break;
                case "1001":
                    str.append("9");
                    break;
                default:
                    System.out.println("有错误");
            }
            str1.delete(0,4);
        }
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)!='0'&&str.charAt(i)!='-'){
                if(str.charAt(0)=='-') str.delete(1,i);
                else str.delete(0,i);
            }
        }
        return str.toString();
    }

    /**
     * Float true value to binaryString
     * @param floatStr : The string of the float true value
     * */
    public String floatToBinary(String floatStr) {
        //TODO:
        if(floatStr.equals("" + Double.MAX_VALUE)) return "+Inf";
        else if(floatStr.equals("" + Double.MIN_VALUE))
            return "-Inf";
        else{float d = Float.parseFloat(floatStr);
                int k;
                k = Float.floatToIntBits(d);
                String m = Integer.toBinaryString(k);
                int p = 32-m.length();
                StringBuilder str = new StringBuilder();
                for(int i = 0;i<p;i++) str.append("0");
                str.append(m);
                if(str.toString().equals("11111111100000000000000000000000")) return "-Inf";
                return str.toString();}
        }

    /**
     * Binary code to its float true value
     * */
    public String binaryToFloat(String binStr) {
        //TODO:
        if(binStr.equals("00000000000000000000000000000000")) return "0.0";

        return "+Inf";
    }


}
