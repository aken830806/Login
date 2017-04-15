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
    Boolean register(String ID,String pw){//ゼЧΘ
        return false;
    }
    String IDCheck(String ID){
        //计3~15璣ゅ+计
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
        //计3~15璣ゅ+计
        if(!this.inputAmountCheck(ID))
            return "Amo";
        if(!this.inputIncludeNumberCheck(ID))
            return "Num";
        if(!this.inputIncludeIllegalCheck(ID))
            return "Ill";
        return "Suc";
    }
    Boolean inputAmountCheck(String check){//计3~15
        if(check.length() < 3 || check.length() > 15)
            return false;
        return true;
    }
    Boolean inputIncludeNumberCheck(String check){//计
        int ctr = 0;
        while(ctr < check.length()){
            String test = check.substring(ctr ,ctr+1);
            if(test.matches("[0-9]"))
                return true;
            ctr = ctr + 1;
        }
        return false;
    }
    Boolean inputIncludeEnglishCheck(String check){//璣ゅ
        int ctr = 0;
        while(ctr < check.length()){
            String test = check.substring(ctr ,ctr+1);
            if(test.matches("[a-zA-Z| \\.]*"))
                return true;
            ctr = ctr + 1;
        }
        return false;
    }
    Boolean inputIncludeIllegalCheck(String check){//獶猭じ(璣ゅ计)
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