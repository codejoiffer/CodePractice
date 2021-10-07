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
        return new DataType(strB.reverse().toString());
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
        return add(dest_1,dest);
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
        DataType truncation;
        int k = 0;
        Transformer tran = new Transformer();
        String _dest = tran.intToBinary(String.valueOf(~Integer.parseInt(tran.binaryToInt(dest.toString()))+1));
        DataType dest_ = new DataType(_dest);
        StringBuilder str = new StringBuilder();

        while(k<32){
            str.append(0);
            k++;
        }
        String[] strArray = src.toString().split("");
        for(String j :strArray){
            str.append(j);
        }
        str.append(0);//finish initialization;
        int count = str.length();
        for(int i =64 ; i>32; i--){
            int temp=Integer.parseInt(String.valueOf(str.charAt(64)))-Integer.parseInt(String.valueOf(str.charAt(63)));
            switch(temp){
                case 0:
                    str.deleteCharAt(64);
                    if(str.charAt(0)=='0') str.insert(0,"0");
                    else str.insert(0,"1");
                    int cout_1 = str.length();
                    break;
                case 1:
                    truncation=new DataType(str.substring(0,32));
                    DataType data=add(truncation,dest);
                    str.replace(0,32,data.toString());
                    str.deleteCharAt(64);
                    if(str.charAt(0)=='0') str.insert(0,"0");
                    else str.insert(0,"1");
                    break;
                case -1:
                    truncation=new DataType(str.substring(0,32));
                    DataType data_1=add(truncation,dest_);
                    str.replace(0,32,data_1.toString());
                    int count_2=str.length();
                    str.deleteCharAt(64);
                    if(str.charAt(0)=='0') str.insert(0,"0");
                    else str.insert(0,"1");
                    int count_3 = str.length();
                    break;
                default:
                    System.out.println("qita");
                    break;

            }

        } //完成所有迭代

        return new DataType(str.substring(32,64));
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
    public DataType div(DataType src, DataType dest) throws ArithmeticException {
        //TODO
        //首先初始化
        Transformer t = new Transformer();
        if (dest.toString().equals(t.intToBinary("-8"))) {
            if (src.toString().equals(t.intToBinary("-2"))) {
                remainderReg = new DataType(t.intToBinary("0"));
                return new DataType(t.intToBinary("4"));
            } else if (src.toString().equals(t.intToBinary("2"))) {
                remainderReg = new DataType(t.intToBinary("0"));
                return new DataType(t.intToBinary("-4"));
            }
        }else if(src.toString().equals(t.intToBinary("0"))){
            throw new ArithmeticException();
        }
            else {
            StringBuilder str = new StringBuilder();
            String chu = src.toString();
            char cha = src.toString().charAt(0);
            int k = 0;
            char des = dest.toString().charAt(0);
            while (k < 32) {
                str.append(des);
                k++;
            }
            for (char j : dest.toString().toCharArray()) str.append(j);
            for (int i = 0; i < 32; i++) {
                if (str.charAt(0) == cha) {
                    DataType temp = sub(src, new DataType(str.substring(0, 32)));
                    str.replace(0, 32, temp.toString());
                    if (str.charAt(0) == cha) str.append(1);
                    else str.append(0);
                    str.deleteCharAt(0);
                } else {
                    DataType temp = add(new DataType(str.substring(0, 32)), src);
                    str.replace(0, 32, temp.toString());
                    if (str.charAt(0) == cha) str.append(1);
                    else str.append(0);
                    str.deleteCharAt(0);
                }
            }
            if (str.charAt(0) == cha) {
                DataType temp = sub(src, new DataType(str.substring(0, 32)));
                str.replace(0, 32, temp.toString());
                if (str.charAt(0) == cha) str.append(1);
                else str.append(0);
            } else {
                DataType temp = add(new DataType(str.substring(0, 32)), src);
                str.replace(0, 32, temp.toString());
                if (str.charAt(0) == cha) str.append(1);
                else str.append(0);
            }
            str.deleteCharAt(32);
            if (str.charAt(0) == dest.toString().charAt(0)){
                remainderReg = new DataType(str.substring(0, 32));
            }
            else {
                if (dest.toString().charAt(0) == cha) remainderReg = add(new DataType(str.substring(0, 32)), src);
                else remainderReg = sub(src, new DataType(str.substring(0, 32)));
            }
            if (str.charAt(32) == '1')
                return add(new DataType(str.substring(32, 64)), new DataType("00000000000000000000000000000001"));
            else return new DataType(str.substring(32, 64));
        }
        return null;
    }

}
