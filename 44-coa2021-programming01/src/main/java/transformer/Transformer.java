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
            else sum+=Math.pow(k,(31-i));
        }
        String str = Integer.toString(sum);
        return str;
    }
    /**
     * The decimal number to its NBCD code
     * */
    public String decimalToNBCD(String decimalStr) {
        //TODO:
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
        return null;
    }

    /**
     * Float true value to binaryString
     * @param floatStr : The string of the float true value
     * */
    public String floatToBinary(String floatStr) {
        //TODO:
        return null;
    }

    /**
     * Binary code to its float true value
     * */
    public String binaryToFloat(String binStr) {
        //TODO:
        return null;
    }


}
