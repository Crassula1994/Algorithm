package bronze3.num12756;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 각 플레이어의 카드 정보를 각 변수에 할당
		StringTokenizer playerA = new StringTokenizer(in.readLine());
		StringTokenizer playerB = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 각 플레이어 카드의 공격력과 생명력을 각 변수에 할당
		int offenseA = Integer.parseInt(playerA.nextToken());
		int vitalityA = Integer.parseInt(playerA.nextToken());
		int offenseB = Integer.parseInt(playerB.nextToken());
		int vitalityB = Integer.parseInt(playerB.nextToken());
		
		// 각 플레이어 카드가 죽은 상태가 될 때까지 필요한 공격 횟수를 계산해 각 변수에 할당
		int countA = (vitalityA + offenseB - 1) / offenseB;
		int countB = (vitalityB + offenseA - 1) / offenseA;
		
		// 플레이어 A의 카드가 남아 있는 경우 'PLAYER A'를 출력
		if (countA > countB) {
			out.write("PLAYER A");
			
		// 플레이어 B의 카드가 남아 있는 경우 'PLAYER B'를 출력
		} else if (countA < countB) {
			out.write("PLAYER B");
			
		// 모두 죽은 상태인 경우 'DRAW'를 출력
		} else {
			out.write("DRAW");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}