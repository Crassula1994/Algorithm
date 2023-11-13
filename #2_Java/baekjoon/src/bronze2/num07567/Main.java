package bronze2.num07567;

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
		
		// readLine() 메서드를 사용해 입력 받은 괄호 문자열을 변수 bracketString에 할당
		String bracketString = in.readLine();
		
		// 그릇의 최종 높이를 저장할 변수 totalHeight 초기화
		int totalHeight = 10;
		
		// for 반복문을 사용해 각 그릇을 차례로 순회
		for (int idx = 1; idx < bracketString.length(); idx++) {
			
			// charAt() 메서드를 사용해 전의 그릇과 현재 그릇을 각 변수에 할당
			char prevDish = bracketString.charAt(idx - 1);
			char curDish = bracketString.charAt(idx);
			
			// 두 그릇의 방향이 다른 경우 그릇의 최종 높이를 갱신
			if (prevDish != curDish) {
				totalHeight += 10;
				
			// 두 그릇의 방향이 같은 경우 그릇의 최종 높이를 갱신
			} else {
				totalHeight += 5;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 그릇의 최종 높이를 출력
		out.write(String.valueOf(totalHeight));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}