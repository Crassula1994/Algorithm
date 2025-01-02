package silver4.num13413;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 데이터의 개수를 변수 testData에 할당
		int testData = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 데이터를 순회
		while (testData-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 오셀로 말의 개수를 변수 pieceNum에 할당
			int pieceNum = Integer.parseInt(in.readLine());
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 오셀로 말의 초기 상태와 목표 상태를 각 배열에 할당
			char[] initialPieces = in.readLine().toCharArray();
			char[] targetPieces = in.readLine().toCharArray();
			
			// 목표 상태와 일치하지 않는 각 색깔의 오셀로 말 개수를 저장할 각 변수 초기화
			int countB = 0;
			int countW = 0;
			
			// for 반복문을 사용해 각 오셀로 말을 순회
			for (int idx = 0; idx < pieceNum; idx++) {
				
				// 초기 상태와 목표 상태가 일치하는 경우 다음 말을 순회
				if (initialPieces[idx] == targetPieces[idx])
					continue;
				
				// 목표 상태와 일치하지 않는 각 색깔의 오셀로 말 개수를 갱신
				countB = (initialPieces[idx] == 'B') ? countB + 1 : countB;
				countW = (initialPieces[idx] == 'B') ? countW : countW + 1;
			}
			
			// max() 및 write() 메서드를 사용해 목표 상태에 도달할 수 있는 최소 횟수를 출력
			out.write(Math.max(countB, countW) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}