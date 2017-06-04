import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;

public class LoginTest {
    Login  l = new Login();
    @Test
    public void testInputAmountCheck() {
        //�r��3~15
        assertEquals(l.inputAmountCheck("sa"),false);
        assertEquals(l.inputAmountCheck("4112e"),true);
        assertEquals(l.inputAmountCheck("asdadagdfgsdggsd"),false);
    }
    @Test
    public void testInputIncludeNumberCheck() {
        //�]�t�Ʀr
        assertEquals(l.inputIncludeNumberCheck("4112e"),true);
        assertEquals(l.inputIncludeNumberCheck("asdada"),false);
    }
    @Test
    public void testInputIncludeEnglishCheck() {
        //�]�t�^��
        assertEquals(l.inputIncludeEnglishCheck("sfsg1241ssd"),true);
        assertEquals(l.inputIncludeEnglishCheck("23523"),false);
    }
    @Test
    public void testInputIncludeIllegalCheck() {
        //�D�k�r��
        assertEquals(l.inputIncludeIllegalCheck("qweq*312"),true);
        assertEquals(l.inputIncludeIllegalCheck("12asfas"),false);
    }
    @Test
    public void testDataRepeatCheck(){
        assertEquals(l.dataCheck("ghk"),true);
        assertEquals(l.dataCheck("asd"),null);//test�K�X�k�X
        assertEquals(l.dataCheck("sfs"),true);
    }
}
