import java.util.*;
public class GameController {
    static int pos = 0;
    static boolean flag = true;
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            System.out.println("あなたの出目 : " + RollDice());
            int ad = adPiece();
            STofField(ad);
            if(!flag){
                pos = 0;
                flag = true;
            }
        }
    }

    static char RollDice(){
        char[] spot = {'1','2','3','4','×','×'};
        Random rand = new Random();
        int num = rand.nextInt(6);
        return spot[num];
    }

    static int adPiece(){
        Scanner sc = new Scanner(System.in);
        System.out.println("何マス駒を進めますか : ");
        int ad = sc.nextInt();
        while(ad<1||ad>4){
            System.out.println("不正な値です。再度入力してください : ");
            ad = sc.nextInt();
        }
        return ad;
    }

    static void STofField(int ad){
        String field = ". . . . . . . . . .";
        StringBuilder sb = new StringBuilder();
        sb.append(field);
        pos += ad;
        if(pos>=9){
            sb.replace(18, 19, "|");
            System.out.println("S                 G");
            System.out.println(sb.toString());
            System.out.println("ゴール!!");
            flag = false;
        }else{
            sb.replace(2*pos, 2*pos+1, "|");
            System.out.println("S                 G");
            System.out.println(sb.toString());
        }
    } 
   
}
