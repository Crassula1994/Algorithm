package bronze4.num28074;

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
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 각 알파벳이 존재하는지 여부를 나타낼 각 변수 초기화
		boolean existM = false;
		boolean existO = false;
		boolean existB = false;
		boolean existI = false;
		boolean existS = false;
		
		// for 반복문을 사용해 문자열의 각 알파벳을 순회
		for (int idx = 0; idx < string.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
			char alphabet = string.charAt(idx);
			
			// 해당 알파벳이 M인 경우 알파벳 M이 존재하는지 여부를 갱신
			if (alphabet == 'M')
				existM = true;
			
			// 해당 알파벳이 O인 경우 알파벳 O가 존재하는지 여부를 갱신
			if (alphabet == 'O')
				existO = true;
			
			// 해당 알파벳이 B인 경우 알파벳 B가 존재하는지 여부를 갱신
			if (alphabet == 'B')
				existB = true;
			
			// 해당 알파벳이 I인 경우 알파벳 I가 존재하는지 여부를 갱신
			if (alphabet == 'I')
				existI = true;
			
			// 해당 알파벳이 S인 경우 알파벳 S가 존재하는지 여부를 갱신
			if (alphabet == 'S')
				existS = true;
		}
		
		
		// 필요한 모든 알파벳이 존재하는 경우 'YES' 출력
		if (existM && existO && existB && existI && existS) {
			out.write("YES");
			
		// 필요한 알파벳이 존재하지 않는 경우 'NO' 출력
		} else {
			out.write("NO");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}