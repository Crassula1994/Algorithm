package bronze1.num25592;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 바둑돌 무더기의 바둑돌 개수를 변수 stoneNum에 할당
		int stoneNum = Integer.parseInt(in.readLine());
		
		// 현재 차례에서 가져가야 하는 바둑돌의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 바둑돌을 가져갈 수 있을 때까지 바둑돌 무더기의 바둑돌 개수를 갱신
		while (stoneNum - count - 1 >= 0)
			stoneNum -= ++count;
		
		// 푸앙이가 이기는 경우 0을 출력
		if ((count & 1) == 1) {
			out.write("0");
			
		// 푸앙이가 지는 경우 푸앙이가 이기기 위해 추가할 바둑돌의 개수를 출력
		} else {
			out.write(String.valueOf(count + 1 - stoneNum));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}