package silver5.num01436;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 영화의 순서를 변수 seriesNum에 할당
		int seriesNum = Integer.parseInt(in.readLine());
		
		// '666'이 포함된 숫자의 개수 및 해당 숫자를 저장할 각 변수 초기화
		int count = 0;
		int number = 665;
		
		// while 반복문을 사용해 입력 받은 영화의 순서까지 순회 
		while (count < seriesNum) {
			
			// 숫자 갱신
			number += 1;
			
			// '666'이 포함된 경우 숫자의 개수 갱신
			if (String.valueOf(number).contains("666"))	
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 영화 제목에 들어갈 수를 출력
		out.write(String.valueOf(number));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}