package cpu.alu;

import util.DataType;
import util.Transformer;

/**
 * Arithmetic Logic Unit
 * ALU封装类
 */
public class ALU {

    DataType remainderReg;

    /**
     * 返回两个二进制整数的和
     * dest + src
     *
     * @param src  32-bits
     * @param dest 32-bits
     * @return 32-bits
     */
    public DataType add(DataType src, DataType dest) {
        // TODO
        String [] stringNumber_1 = src.toString().split("");
        String [] stringNumber_2 = dest.toString().split("");
        StringBuilder strB = new StringBuilder();
        int[] c = new int[32];
        int count;
        for(int i = 31; i>=0;i--){
            if(i==31){
                count=Integer.parseInt(stringNumber_1[i])+Integer.parseInt(stringNumber_2[i]);
                switch(count){
                    case 0:
                        strB.append("0");
                        break;
                    case 1:
                        strB.append("1");
                        break;
                    case 2:
                        c[i]=1;
                        strB.append("0");
                        break;
                    default:
                        System.out.println("is ont 0 or 1");
                        break;
                }

            } else {
                int one = Integer.parseInt(stringNumber_1[i]);
                int two = Integer.parseInt(stringNumber_2[i]);
                int temp=one^two^c[i+1];
                c[i] = (one&two)|(one&c[i+1])|(two&c[i+1]);
                strB.append(temp);
            }


        }
        remainderReg=new DataType(strB.reverse().toString());
        return remainderReg;
    }


    /**
     * 返回两个二进制整数的差
     * dest - src
     *
     * @param src  32-bits
     * @param dest 32-bits
     * @return 32-bits
     */
    public DataType sub(DataType src, DataType dest) {
        // TODO
        Transformer tran = new Transformer();
        String intege = tran.binaryToInt(src.toString());
        int result = ~Integer.parseInt(intege)+1;
        String result_1 = tran.intToBinary(String.valueOf(result));
        DataType dest_1 = new DataType(result_1);
        remainderReg = add(dest_1,dest);
        return remainderReg;
    }


    /**
     * 返回两个二进制整数的乘积(结果低位截取后32位)
     * dest * src
     *
     * @param src  32-bits
     * @param dest 32-bits
     * @return 32-bits
     */
    public DataType mul(DataType src, DataType dest) {
        //TODO
        return null;
    }


    /**
     * 返回两个二进制整数的除法结果
     * 请注意使用不恢复余数除法方式实现
     * dest ÷ src
     *
     * @param src  32-bits
     * @param dest 32-bits
     * @return 32-bits
     */
    public DataType div(DataType src, DataType dest) {
        //TODO
        return null;
    }

}
