package cpu.alu;

import org.junit.Test;
import util.DataType;
import util.Transformer;

import static org.junit.Assert.assertEquals;

public class ALUDivTest {

    private final ALU alu = new ALU();
    private final Transformer transformer = new Transformer();
    private DataType src;
    private DataType dest;
    private DataType result;

    /**
     * 10 / 10 = 1 (0)
     */
    @Test
    public void DivTest1() {
        src = new DataType("00000000000000000000000000001010");
        dest = new DataType("00000000000000000000000000001010");
        result = alu.div(src, dest);
        String quotient = "00000000000000000000000000000001";
        String remainder = "00000000000000000000000000000000";
        assertEquals(quotient, result.toString());
        assertEquals(remainder, alu.remainderReg.toString());
    }

    /**
     * -8 / 2 = -4 (0)
     * 除法算法固有的bug
     */
    @Test
    public void DivSpecialTest() {
        Transformer t = new Transformer();
        src = new DataType(t.intToBinary("2"));
        dest = new DataType(t.intToBinary("-8"));
        result = alu.div(src, dest);
        String quotient = t.intToBinary("-4");
        String remainder = t.intToBinary("0");
        assertEquals(quotient, result.toString());
        assertEquals(remainder, alu.remainderReg.toString());
    }
    //自己的测试
    @Test
    public void DivSpecialTest2() {
        Transformer t = new Transformer();
        src = new DataType("00000000000000000000000000000001");
        dest = new DataType("10000000000000000000000000000000");
        result = alu.div(src, dest);
        String temp = t.binaryToInt(result.toString());
        String temp_2 = alu.remainderReg.toString();
        String temp_0 = t.binaryToInt(alu.remainderReg.toString());
        String quotient = t.intToBinary("0");
        String temp_3=t.binaryToInt("11101101100101110101111011011010");
        String remainder = t.intToBinary("0");
        assertEquals(quotient, result.toString());
        assertEquals(remainder, alu.remainderReg.toString());
    }

    /**
     * 0 / 0  除0异常
     */
    @Test(expected = ArithmeticException.class)
    public void DivExceptionTest1() {
        src = new DataType("00000000000000000000000000000000");
        dest = new DataType("00000000000000000000000000000000");
        result = alu.div(src, dest);
    }

}
