package bronze2.num09296;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 각 문제의 수를 변수 questionNum에 할당
			int questionNum = Integer.parseInt(in.readLine());
			
			// 학생이 틀린 답의 개수를 저장할 변수 wrongCount 초기화
			int wrongCount = 0;
			
			// readLine() 및 toCharArray() 메서드를 사용해 각 문제의 정답과 학생의 응답을 각 배열에 저장
			char[] answers = in.readLine().toCharArray();
			char[] responses = in.readLine().toCharArray();
			
			// for 반복문을 사용해 각 문제를 순회
			for (int idx = 0; idx < questionNum; idx++) {
				
				// 학생의 응답이 정답과 일치하지 않는 경우 학생이 틀린 답의 개수를 갱신
				if (answers[idx] != responses[idx])
					wrongCount++;
			}
			
			// write() 메서드를 사용해 학생이 틀린 답의 개수를 출력
			out.write("Case " + tc + ": " + wrongCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}