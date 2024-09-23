package bronze5.num05341;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 피라미드의 기초가 되는 블록의 수를 변수 blockNum에 할당
			int blockNum = Integer.parseInt(in.readLine());
			
			// 마지막 테스트 케이스까지 확인한 경우 반복문 탈출
			if (blockNum == 0)
				break;
			
			// write() 메서드를 사용해 피라미드를 만드는 데 필요한 블록의 수를 출력
			out.write((blockNum * (blockNum + 1) / 2) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}