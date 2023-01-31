package bronze3.num10818;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수의 개수를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 각 정수를 담을 배열 numbers 초기화
		int[] numbers = new int[size];
		
		// 최솟값과 최댓값을 저장할 변수 min, max 초기화
		int min = 1000001;
		int max = -1000001;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 numbers의 각 원소를 순회 
		for (int i = 0; i < numbers.length; i++) {
			
			// 배열 numbers에 입력 받은 정수를 차례로 저장
			numbers[i] = Integer.parseInt(st.nextToken());
			
			// 해당 원소가 min보다 작은 경우 최솟값 갱신
			if (numbers[i] < min)
				min = numbers[i];
			
			// 해당 원소가 max보다 큰 경우 최댓값 갱신
			if (numbers[i] > max)
				max = numbers[i];
		}
		
		// write() 메서드를 사용해 최솟값과 최댓값을 출력
		out.write(min + " " + max);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}