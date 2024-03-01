package bronze4.num27918;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 경기의 수를 변수 matchNum에 할당
		int matchNum = Integer.parseInt(in.readLine());
		
		// 달구와 포닉스의 점수를 저장할 각 변수 초기화
		int pointD = 0;
		int pointP = 0;
		
		// for 반복문을 사용해 각 경기의 예측 결과를 순회
		for (int match = 0; match < matchNum; match++) {
			
			// readLine() 및 charAt() 메서드를 사용해 해당 라운드의 승자를 변수 winner에 할당
			char winner = in.readLine().charAt(0);
			
			// 승자가 달구인 경우 달구의 점수를 갱신
			if (winner == 'D') {
				pointD++;
			
			// 승자가 포닉스인 경우 포닉스의 점수를 갱신
			} else {
				pointP++;
			}
			
			// 두 명의 점수 차이가 2점 이상인 경우 반복문 탈출
			if (Math.abs(pointD - pointP) >= 2)
				break;
		}
		
		// write() 메서드를 사용해 달구와 포닉스의 점수를 출력
		out.write(pointD + ":" + pointP);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}