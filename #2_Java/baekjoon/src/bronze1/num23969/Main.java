package bronze1.num23969;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기 및 교환 횟수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int targetCount = Integer.parseInt(st.nextToken());
		
		// 실제 정렬 과정에서 교환 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// 입력 받은 배열의 원소를 저장할 배열 array 초기화
		int[] array = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배열의 원소를 배열 array에 저장
		for (int idx = 0; idx < array.length; idx++)
			array[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 배열의 각 위치를 거꾸로 순회
		outer: for (int last = size - 1; last > 0; last--) {
			
			// for 반복문을 사용해 정렬되지 않은 위치를 순회
			for (int idx = 0; idx < last; idx++) {
				
				// 인접한 원소를 교환할 필요가 없는 경우 다음 위치를 순회
				if (array[idx] < array[idx + 1])
					continue;
				
				// 두 원소의 위치를 교환
				int temp = array[idx];
				array[idx] = array[idx + 1];
				array[idx + 1] = temp;
				
				// 실제 교환 횟수가 주어진 교환 횟수에 이른 경우
				if (++count == targetCount) {
					
					// for 반복문을 사용해 배열을 출력
					for (int element : array)
						out.write(element + " ");
					
					// 반복문 탈출
					break outer;
				}
			}
		}
		
		// 실제 교환 횟수가 주어진 교환 횟수보다 적은 경우 -1을 출력
		if (count < targetCount)
			out.write("-1");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}