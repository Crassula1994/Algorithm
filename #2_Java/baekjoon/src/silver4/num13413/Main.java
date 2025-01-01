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
			
			// readLine() 메서드를 사용해 입력 받은 오셀로 말의 초기 상태와 목표 상태를 각 변수에 할당
			String initialPieces = in.readLine();
			String targetPieces = in.readLine();
			
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}