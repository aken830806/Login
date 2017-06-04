import java.io.*;
import java.util.*;

public class Login{
    BufferedReader br;
    BufferedWriter bw;
    final String Amo = "�п�J3~15�Ӧr";
    final String Eng = "�п�J�]�t�^�媺���e";
    final String Num = "�п�J�]�t�Ʀr�����e";
    final String Ill = "�]�t�^��B�Ʀr�H�~�����e�A�Э��s��J";
    final String Suc = "";
    
    String register(String ID,char[] pws){
        String pw;
        switch(IDCheck(ID)){
            case Amo:
            case Eng:
            case Num:
            case Ill:
                return "�b�� " + IDCheck(ID);
            case "Suc":
                pw = String.valueOf(pws);
                switch(pwCheck(pw)){
                    case Amo:
                    case Ill:
                        return "�K�X " + pwCheck(pw);
                    case "Suc":{
                        if(dataCheck(ID) == null){
                            try {
                                bw = new BufferedWriter(new FileWriter("Login.txt",true));//true�N����[
                                bw.write(ID.toLowerCase() + " " + pw.toLowerCase() + "\r\n");
                                bw.close();
                                return "���U���\";
                            } catch (IOException e) {
                                // TODO �۰ʲ��ͪ� catch �϶�
                                e.printStackTrace();
                            }
                        }else{
                            return "���b���w���U";
                        }
                    }
                }
            }
        return "���U���� �Э���";
    }
    String login(String ID,char[] pws){
        String pw;
        pw = String.valueOf(pws);
        if(dataCheck(ID) == null){
            return "���b�����s�b";
        }else if(pw.equals(dataCheck(ID))){
            return "�n�J���\";
        }else{
            return "�K�X���~ �Э���";
        }
    }
    
    String IDCheck(String ID){
        //check�r��3~15�B�]�t�^��+�Ʀr�B�L�D�k�r��
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
        //check�r��3~15�B�L�D�k�r��
        if(!this.inputAmountCheck(ID))
            return Amo;
        if(this.inputIncludeIllegalCheck(ID))
            return Ill;
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
        // TODO �۰ʲ��ͪ� catch �϶�
        e.printStackTrace();
    }
        return null;
    }
}