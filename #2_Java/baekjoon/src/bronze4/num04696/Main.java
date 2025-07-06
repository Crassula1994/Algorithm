package bronze4.num04696;

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
		
		// while 반복문을 사용해 각 데이터 세트를 순회
		while (true) {
			
			/* readLine() 및 parseDouble() 메서드를 사용해 입력 받은 로버트가 그 해에 만난 아내,
			아내당 자루, 고양이당 고양이의 수를 나타내는 실수를 변수 multiplier에 할당 */
			double multiplier = Double.parseDouble(in.readLine());
			
			// 모든 데이터 세트를 확인한 경우 반복문 탈출
			if (multiplier == 0)
				break;
			
			// 로버트가 만난 행렬의 평균 규모를 저장할 변수 size 초기화
			double size = 0;
			
			// for 반복문을 사용해 로버트가 만난 행렬의 평균 규모를 갱신
			for (int exponent = 0; exponent < 5; exponent++)
				size += Math.pow(multiplier, exponent);
			
			// format() 및 write() 메서드를 사용해 행렬의 크기를 출력
			out.write(String.format("%.2f", size));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}