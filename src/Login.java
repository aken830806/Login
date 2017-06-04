import java.io.*;
import java.util.*;

public class Login{
    BufferedReader br;
    BufferedWriter bw;
    final String Amo = "請輸入3~15個字";
    final String Eng = "請輸入包含英文的內容";
    final String Num = "請輸入包含數字的內容";
    final String Ill = "包含英文、數字以外的內容，請重新輸入";
    final String Suc = "";
    
    String register(String ID,char[] pws){
        String pw;
        switch(IDCheck(ID)){
            case Amo:
            case Eng:
            case Num:
            case Ill:
                return "帳號 " + IDCheck(ID);
            case "Suc":
                pw = String.valueOf(pws);
                switch(pwCheck(pw)){
                    case Amo:
                    case Ill:
                        return "密碼 " + pwCheck(pw);
                    case "Suc":{
                        if(dataCheck(ID) == null){
                            try {
                                bw = new BufferedWriter(new FileWriter("Login.txt",true));//true代表附加
                                bw.write(ID.toLowerCase() + " " + pw.toLowerCase() + "\r\n");
                                bw.close();
                                return "註冊成功";
                            } catch (IOException e) {
                                // TODO 自動產生的 catch 區塊
                                e.printStackTrace();
                            }
                        }else{
                            return "此帳號已註冊";
                        }
                    }
                }
            }
        return "註冊失敗 請重試";
    }
    String login(String ID,char[] pws){
        String pw;
        pw = String.valueOf(pws);
        if(dataCheck(ID) == null){
            return "此帳號不存在";
        }else if(pw.equals(dataCheck(ID))){
            return "登入成功";
        }else{
            return "密碼錯誤 請重試";
        }
    }
    
    String IDCheck(String ID){
        //check字數3~15、包含英文+數字、無非法字元
        if(!this.inputAmountCheck(ID))
            return Amo;
        if(!this.inputIncludeEnglishCheck(ID))
            return Eng;
        if(!this.inputIncludeNumberCheck(ID))
            return Num;
        if(this.inputIncludeIllegalCheck(ID))
            return Ill;
        return "Suc";
    }
    String pwCheck(String ID){
        //check字數3~15、無非法字元
        if(!this.inputAmountCheck(ID))
            return Amo;
        if(this.inputIncludeIllegalCheck(ID))
            return Ill;
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
    String dataCheck(String check){
       String line;
       String[] temp;
       try {
           br = new BufferedReader(new FileReader("Login.txt"));
           while((line = br.readLine()) != null){
               temp = line.split(" ");
               if(temp[0].equals(check))
                   return temp[1];
               }
           br.close();
    } catch (IOException e) {
        // TODO 自動產生的 catch 區塊
        e.printStackTrace();
    }
        return null;
    }
}