import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;

public class LoginTest {
    Login  l = new Login();
    @Test
    public void testInputAmountCheck() {
        //字數3~15
        assertEquals(l.inputAmountCheck("sa"),false);
        assertEquals(l.inputAmountCheck("4112e"),true);
        assertEquals(l.inputAmountCheck("asdadagdfgsdggsd"),false);
    }
    @Test
    public void testInputIncludeNumberCheck() {
        //包含數字
        assertEquals(l.inputIncludeNumberCheck("4112e"),true);
        assertEquals(l.inputIncludeNumberCheck("asdada"),false);
    }
    @Test
    public void testInputIncludeEnglishCheck() {
        //包含英文
        assertEquals(l.inputIncludeEnglishCheck("sfsg1241ssd"),true);
        assertEquals(l.inputIncludeEnglishCheck("23523"),false);
    }
    @Test
    public void testInputIncludeIllegalCheck() {
        //非法字元
        assertEquals(l.inputIncludeIllegalCheck("qweq*312"),true);
        assertEquals(l.inputIncludeIllegalCheck("12asfas"),false);
    }
    @Test
    public void testDataRepeatCheck(){
        assertEquals(l.dataRepeatCheck("ghk"),true);
        assertEquals(l.dataRepeatCheck("asd"),false);//test密碼吻合
        assertEquals(l.dataRepeatCheck("sfs"),true);
    }
    @Test
    public void testRegister(){
        l.register("aken2546","801609");
    }
}
