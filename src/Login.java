import java.io.*;
import java.util.*; 

public class Login{
    //GUI g = new GUI();
    Scanner s = new Scanner(System.in);
    public static void main(String args[]){
            Login login = new Login();       
    }
    Login(){
        //BufferedReader br = new BufferedReader(new FileReader("Login.txt"));
    }
    Boolean register(String ID,String pw){//������
        return false;
    }
    String IDCheck(String ID){
        //�r��3~15�B�]�t�^��+�Ʀr
        if(!this.inputAmountCheck(ID))
            return "Amo";
        if(!this.inputIncludeEnglishCheck(ID))
            return "Eng";
        if(!this.inputIncludeNumberCheck(ID))
            return "Num";
        if(!this.inputIncludeIllegalCheck(ID))
            return "Ill";
        return "Suc";
    }
    String pwCheck(String ID){
        //�r��3~15�B�]�t�^��+�Ʀr
        if(!this.inputAmountCheck(ID))
            return "Amo";
        if(!this.inputIncludeNumberCheck(ID))
            return "Num";
        if(!this.inputIncludeIllegalCheck(ID))
            return "Ill";
        return "Suc";
    }
    Boolean inputAmountCheck(String check){//�r��3~15
        if(check.length() < 3 || check.length() > 15)
            return false;
        return true;
    }
    Boolean inputIncludeNumberCheck(String check){//�]�t�Ʀr
        int ctr = 0;
        while(ctr < check.length()){
            String test = check.substring(ctr ,ctr+1);
            if(test.matches("[0-9]"))
                return true;
            ctr = ctr + 1;
        }
        return false;
    }
    Boolean inputIncludeEnglishCheck(String check){//�]�t�^��
        int ctr = 0;
        while(ctr < check.length()){
            String test = check.substring(ctr ,ctr+1);
            if(test.matches("[a-zA-Z| \\.]*"))
                return true;
            ctr = ctr + 1;
        }
        return false;
    }
    Boolean inputIncludeIllegalCheck(String check){//�]�t�D�k�r��(�^��Ʀr�H�~)
            int ctr = 0;
            while(ctr < check.length()){
                String test = check.substring(ctr ,ctr+1);
                if(!test.matches("[a-zA-Z0-9| \\.]*"))
                    return true;
                ctr = ctr + 1;
            }
            return false;
    }
}