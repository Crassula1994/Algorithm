package bronze2.num02511;

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
		
		// A와 B의 총 승점 및 마지막에 이긴 사람을 저장할 각 변수에 할당
		int pointA = 0;
		int pointB = 0;
		String recentWinner = "D";
		
		// StringTokenizer 객체를 불러와 각 변수 st에 할당
		StringTokenizer cardsA = new StringTokenizer(in.readLine());
		StringTokenizer cardsB = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 게임의 결과를 순회
		for (int idx = 0; idx < 10; idx++) {
			
			// nextToken() 및 parseInt() A와 B가 늘어놓은 카드의 숫자를 각 변수에 할당
			int cardA = Integer.parseInt(cardsA.nextToken());
			int cardB = Integer.parseInt(cardsB.nextToken());
			
			// A가 이긴 경우 A의 승점과 마지막에 이긴 사람을 갱신
			if (cardA > cardB) {
				pointA += 3;
				recentWinner = "A";
				
			// B가 이긴 경우 B의 승점과 마지막에 이긴 사람을 갱신
			} else if (cardA < cardB) {
				pointB += 3;
				recentWinner = "B";
				
			// A와 B가 비긴 경우 A와 B의 승점을 갱신
			} else {
				pointA++;
				pointB++;
			}
		}
		
		// write() 메서드를 사용해 A와 B의 승점을 출력
		out.write(pointA + " " + pointB + "\n");
		
		// A가 승점이 더 높은 경우 A를 출력
		if (pointA > pointB) {
			out.write("A");
			
		// B가 승점이 더 높은 경우 B를 출력
		} else if (pointA < pointB) {
			out.write("B");
			
		// A와 B의 승점이 같은 경우 마지막에 이긴 사람을 출력
		} else {
			out.write(recentWinner);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}