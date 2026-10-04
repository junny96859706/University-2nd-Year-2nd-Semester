import java.util.Scanner;
import java.util.InputMismatchException;

class Player{
	String playerName;
	int score = 0;
	int absScore;
	int ansScore;
	
	Player(String playerName){
		this.playerName = playerName;
	}
	
	
}

public class GuessGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String playSign = "yes"; 
		int playerNum = -1;
		
		System.out.println("*** 예측 게임을 시작힙니다. ***");
		while(true) {
			System.out.print("게임에 참여할 선수 수>>");
			try{
				playerNum = scanner.nextInt();
				if(playerNum <= 0) {
					System.out.println("인원수는 양의정수로 다시 작성해주세요");
					continue;
				}
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("인원수는 양의정수로 다시 작성해주세요");
				scanner.next();
				continue;
			}
		}
		
		Player player[] = new Player[playerNum];
		for(int i=0; i<player.length; i++) {
			System.out.print("선수 이름>>");
			String name = scanner.next();
			player[i] = new Player(name);
		}
		
		
		
		while("yes".equals(playSign)) {
			int answer = (int)(Math.random()*100+1);
		
			
			System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");
			for(int i=0; i<player.length; i++) {
				System.out.print(player[i].playerName + ">>");
				try{
					player[i].ansScore = scanner.nextInt();
				}
				catch(InputMismatchException e) {
					System.out.println("맞출숫자는 양의정수로 다시 작성해주세요");
					scanner.next();
					i--;
					continue;
				}
				player[i].absScore = Math.abs(answer - player[i].ansScore);
			}
			
			int tempAbs = player[0].absScore;
			int winIndex = 0;
			for(int i=0; i<player.length; i++) {
				if(tempAbs > player[i].absScore) {
					tempAbs = player[i].absScore;
					winIndex = i;
				}
			}
			System.out.println("정답은 " + answer + ". " + player[winIndex].playerName + "이 이겼습니다. 승점 1점 확보!!!");
			player[winIndex].score++;
			
			System.out.print("계속하려면 yes 입력>>");
			playSign = scanner.next();
			
		}
		
		//while문 나와서 최종 결과 출력문
		
		for(int j=0;j<player.length;j++) {
			System.out.print(player[j].playerName + ":" + player[j].score + " ");
		}
		System.out.println();
		
		int resultTemp = player[0].score;
		int resultIndex = 0;
		for(int i=0; i<player.length; i++) {
			if(resultTemp < player[i].score) {
				resultTemp = player[i].score;
				resultIndex = i;
			}
		}
		
		System.out.println(player[resultIndex].playerName + "이 최종 승리하였습니다.");
				
		
		scanner.close();
	}

}
