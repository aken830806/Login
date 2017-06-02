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
                            // TODO �۰ʲ��ͪ� catch �϶�
                            e.printStackTrace();
                        }
                    }
                }
            }
        default:
        }
    }
    String IDCheck(String ID){
        //check�r��3~15�B�]�t�^��+�Ʀr�B�L�D�k�r��
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
        //check�r��3~15�B�L�D�k�r��
        if(!this.inputAmountCheck(ID))
            return "Amo";
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
        // TODO �۰ʲ��ͪ� catch �϶�
        e.printStackTrace();
    }
        return false;
    }
}