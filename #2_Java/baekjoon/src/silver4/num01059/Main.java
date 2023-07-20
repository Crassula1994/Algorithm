package silver4.num01059;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집합의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 집합에 포함된 정수를 저장할 배열 set 초기화
		int[] set = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 집합에 포함된 정수를 배열 set에 저장
		for (int idx = 0; idx < size; idx++)
			set[idx] = Integer.parseInt(st.nextToken());

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 좋은 구간의 시작 숫자와 끝 숫자, 그 개수, 해당 숫자가 집합의 원소인지 여부를 저장할 각 변수 초기화
		int start = 1;
		int end = 1000;
		int count = 0;
		boolean isElement = false;
		
		// for 반복문을 사용해 배열 set의 각 원소를 순회
		for (int element : set) {
			
			// 해당 원소가 주어진 숫자와 같은 경우 해당 숫자가 집합의 원소인지 여부를 갱신 후 반복문 탈출
			if (element == number) {
				isElement = true;
				break;
			
			// 해당 원소가 주어진 숫자보다 큰 경우 해당 숫자를 좋은 구간의 끝 숫자로 갱신
 			} else if (element > number) {
 				end = Math.min(element - 1, end);

 			// 해당 원소가 주어진 숫자보다 작은 경우 해당 숫자를 좋은 구간의 시작 숫자로 갱신
 			} else {
 				start = Math.max(element + 1, start);
 			}
		}
		
		// 해당 숫자가 집합의 원소가 아닌 경우
		if (!isElement) {
			
			// for 반복문을 사용해 모든 구간을 순회
			for (int s = start; s <= end - 1; s++) {
				for (int e = s + 1; e <= end; e++) {
					
					// 해당 구간 내에 해당 숫자가 존재하는 경우 좋은 구간의 개수 갱신
					if (s <= number && number <= e) {
						count++;
					}
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 좋은 구간의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}