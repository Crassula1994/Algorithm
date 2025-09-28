package bronze4.num30868;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 후보의 수를 변수 candidateNum에 할당
		int candidateNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 후보가 받은 표의 수를 순회
		while (candidateNum-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 후보가 받은 표의 수를 변수 voteNum에 할당
			int voteNum = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 5표를 그린 결과를 출력
			for (int count = 0; count < voteNum / 5; count++)
				out.write("++++ ");
			
			// for 반복문을 사용해 1표를 그린 결과를 출력
			for (int count = 0; count < voteNum % 5; count++)
				out.write("|");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}