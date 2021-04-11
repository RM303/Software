import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Player2 {
    public static void main(String[] args) throws IOException{
        InetAddress addr = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);
        int PORT = 8080;
        int mychoice;
        System.out.println("対戦相手を探しています...");
        Socket socket = new Socket(addr, PORT);
        try{
            System.out.println("対戦相手が見つかりました");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            System.out.println("名前を入力してください : ");
            String myname = sc.nextLine();
            out.println(myname);
            System.out.println("相手の入力を待っています...");
            String opname = in.readLine();
            System.out.println(opname + "さんとの対戦を開始します");
            for(int i=0;i<3;i++){
                System.out.println("カードを選択してください");
                mychoice = sc.nextInt();
                out.println(mychoice);
                System.out.println("相手が選択するのを待っています...");
                System.out.println(in.readLine());
                System.out.println(in.readLine());
            }
            System.out.println(in.readLine());
            sc.close();
        }finally{
            System.out.println("対戦を終了します");
            socket.close();
        }
    }
}
