package silver5.num01251;

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

		// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
		String word = in.readLine();
		
		// for 반복문을 사용해 
		
		// for 반복문을 사용해 각 단어를 순회
		if (month == 2 && day == 18) {
			out.write("Special");
		
		// 해당 날짜가 2월 18일 이전인 경우 'Before' 출력
		} else if (month < 2 || (month == 2 && day < 18)) {
			out.write("Before");
		
		// 해당 날짜가 2월 18일 이후인 경우 'After' 출력
		} else {
			out.write("After");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}