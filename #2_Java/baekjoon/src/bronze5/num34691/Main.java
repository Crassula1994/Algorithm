package bronze5.num34691;

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
		
		// while 반복문을 사용해 각 질문을 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 질문을 변수 question에 할당
			String question = in.readLine();
			
			// 모든 질문이 끝난 경우 반복문 탈출
			if (question.equals("end"))
				break;
			
			// switch 조건문을 사용해 각 질문에 해당하는 상징의 학명을 출력
			switch (question) {
				case "animal":
					out.write("Panthera tigris");
					break;
				case "tree":
					out.write("Pinus densiflora");
					break;
				default:
					out.write("Forsythia koreana");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}