import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Player1 {
    public static void main(String[] args) throws IOException{
        GameController gctrl = new GameController();
        Scanner sc = new Scanner(System.in);
        int PORT = 8080;
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("名前を入力してください : ");
        String myname = sc.nextLine();
        int mychoice;
        int opchoice;
        int myscore = 0;
        int opscore = 0;
        int judge = 0;
        System.out.println("対戦相手を探しています...");
        try{
            Socket socket = s.accept();
            try{
                System.out.println("対戦相手が見つかりました");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                out.println(myname);
                System.out.println("相手の入力を待っています...");
                String opname = in.readLine();
                System.out.println(opname + "さんとの対戦を開始します");
                for(int i=0;i<3;i++){
                    System.out.println("カードを選択してください");
                    mychoice = sc.nextInt();
                    System.out.println("相手が選択するのを待っています...");
                    opchoice = Integer.parseInt(in.readLine());
                    judge = gctrl.Judge(mychoice,opchoice);
                    gctrl.Score(judge);
                    if(judge==1){
                        System.out.println("You Win!");
                        out.println("You lose...");
                    }else if(judge==0){
                        System.out.println("Draw");
                        out.println("Draw");
                    }else{
                        System.out.println("You lose...");
                        out.println("You Win!");
                    }
                    myscore = gctrl.p1score;
                    opscore = gctrl.p2score;
                    System.out.println("現在のスコア : " + myscore);
                    out.println("現在のスコア : " + opscore);
                }
                if(myscore > opscore){
                    System.out.println("あなたの勝ちです");
                    out.println("あなたの負けです");
                }else if(myscore==opscore){
                    System.out.println("引き分けです");
                    out.println("引き分けです");
                }else{
                    System.out.println("あなたの負けです");
                    out.println("あなたの勝ちです");
                }
                sc.close();
            }finally{
                System.out.println("対戦を終了します");
                socket.close();
            }
        }finally{
            s.close();
        }
    }
}
