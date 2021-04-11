import java.util.*;

public class GameController {
    public int p1score = 0;
    public int p2score = 0;
    private int score = 2;
    
    String ResisterName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("名前を入力してください : ");
        String name = sc.nextLine();
        sc.close();
        return name;
    }

    String ChooseCard(){
        return "a";
    }

    int Judge(int choice1,int choice2){
        if(choice1==0){
           if(choice2==1||choice2==4){
               return 1;
           }else if(choice2==0){
                return 0;
           }else{
               return -1;
           }
        }else if(choice1==1){
            if(choice2==2||choice2==4){
                return 1;
            }else if(choice2==1){
                return 0;
            }else{
                return -1;
            }
        }else if(choice1==2){
            if(choice2==0||choice2==4){
                return 1;
            }else if(choice2==2){
                return 0;
            }else{
                return -1;
            }
        }else if(choice1==3){
            if(choice2==4){
                return -1;
            }else if(choice2==3){
                return 0;
            }else{
                return 1;
            }
        }else{
            if(choice2==3){
                return 1;
            }else if(choice2==4){
                return 0;
            }else{
                return -1;
            }
        }
    }

    void Score(int judge){
        if(judge==1){
            p1score += score;
            score = 2;
        }else if(judge==0){
            score += 2;
        }else{
            p2score += score;
            score = 2;
        }
    }
}
