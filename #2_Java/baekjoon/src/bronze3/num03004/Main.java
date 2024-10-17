package bronze3.num03004;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자르는 횟수를 변수 cutCount에 할당
		int cutCount = Integer.parseInt(in.readLine());
		
		// 상근이가 얻을 수 있는 조각의 최댓값을 저장할 변수 maxCount 초기화
		int maxCount = 2;
		
		// for 반복문을 사용해 각 자르는 횟수에 따라 상근이가 얻을 수 있는 조각의 최댓값을 갱신
		for (int c = 2; c <= cutCount; c++)
			maxCount += (c / 2) + 1;
		
		// valueOf() 및 write() 메서드를 사용해 상근이가 얻을 수 있는 조각의 최댓값을 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}