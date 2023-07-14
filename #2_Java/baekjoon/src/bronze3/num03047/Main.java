package bronze3.num03047;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 세 숫자를 저장할 배열 numbers 초기화
		int[] numbers = new int[3];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());

		// for 반복문을 사용해 입력 받은 세 숫자를 배열 numbers에 저장
		for (int idx = 0; idx < 3; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 numbers를 오름차순으로 정렬
		Arrays.sort(numbers);

		// readLine() 메서드를 사용해 입력 받은 숫자의 순서를 변수 order에 할당
		String order = in.readLine();
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int c = 0; c < 3; c++) {
			
			// charAt() 메서드를 사용해 해당 알파벳의 위치를 변수 index에 할당
			int index = order.charAt(c) - 'A';
			
			// write() 메서드를 사용해 해당 숫자를 출력
			out.write(numbers[index] + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}