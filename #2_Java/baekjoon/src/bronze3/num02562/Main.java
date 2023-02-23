package bronze3.num02562;

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
		
		// 각 정수를 담을 배열 numbers 초기화
		int[] numbers = new int[9];
		
		// 최댓값과 그 위치를 저장할 변수 max, maxIndex 초기화
		int max = 0;
		int maxIndex = 0;
		
		// for 반복문을 사용해 배열 numbers의 각 원소를 순회 
		for (int i = 0; i < numbers.length; i++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 배열 numbers에 입력 받은 정수를 차례로 저장
			numbers[i] = Integer.parseInt(in.readLine());
			
			// 해당 원소가 max보다 큰 경우 최댓값 및 위치 갱신
			if (numbers[i] > max) {
				max = numbers[i];
				maxIndex = i + 1;
			}
		}
		
		// write() 메서드를 사용해 최댓값과 그 위치를 출력
		out.write(max + "\n" + maxIndex);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}