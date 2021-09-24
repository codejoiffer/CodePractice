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
        return null;
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
