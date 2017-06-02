import java.io.*;
import java.util.*;

public class Login{
    BufferedReader br;
    BufferedWriter bw;
    void register(String ID,String pw){
        switch(this.IDCheck(ID)){
            case "Amo":
            
            case "Eng":
            
            case "Num":
            
            case "Ill":
            
            case "Suc":
                switch(this.pwCheck(pw)){
                case "Amo":
                
                case "Ill":
                
                case "Suc":{
                    if(!this.dataRepeatCheck(ID)){
                        try {
                            bw = new BufferedWriter(new FileWriter("Login.txt"));
                            bw.write(ID.toLowerCase() + " " + pw.toLowerCase() + "\r\n");
                            bw.close();
                        } catch (IOException e) {
                            // TODO 自動產生的 catch 區塊
                            e.printStackTrace();
                        }
                    }
                }
            }
        default:
        }
    }
    String IDCheck(String ID){
        //check字數3~15、包含英文+數字、無非法字元
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
        //check字數3~15、無非法字元
        if(!this.inputAmountCheck(ID))
            return "Amo";
        if(!this.inputIncludeIllegalCheck(ID))
            return "Ill";
        return "Suc";
    }
    Boolean inputAmountCheck(String check){//字數3~15
        if(check.length() < 3 || check.length() > 15)
            return false;
        return true;
    }
    Boolean inputIncludeNumberCheck(String check){//包含數字
        int ctr = 0;
        while(ctr < check.length()){
            String test = check.substring(ctr ,ctr+1);
            if(test.matches("[0-9]"))
                return true;
            ctr = ctr + 1;
        }
        return false;
    }
    Boolean inputIncludeEnglishCheck(String check){//包含英文
        int ctr = 0;
        while(ctr < check.length()){
            String test = check.substring(ctr ,ctr+1);
            if(test.matches("[a-zA-Z| \\.]*"))
                return true;
            ctr = ctr + 1;
        }
        return false;
    }
    Boolean inputIncludeIllegalCheck(String check){//包含非法字元(英文數字以外)
            int ctr = 0;
            while(ctr < check.length()){
                String test = check.substring(ctr ,ctr+1);
                if(!test.matches("[a-zA-Z0-9| \\.]*"))
                    return true;
                ctr = ctr + 1;
            }
            return false;
    }
    Boolean dataRepeatCheck(String check){
       String line;
       String[] temp;
       try {
           br = new BufferedReader(new FileReader("Login.txt"));
           while((line = br.readLine()) != null){
               temp = line.split(" ");
               if(temp[0].equals(check))
                   return true;
               }
           br.close();
           return false;
    } catch (IOException e) {
        // TODO 自動產生的 catch 區塊
        e.printStackTrace();
    }
        return false;
    }
}