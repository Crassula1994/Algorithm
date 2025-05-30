package bronze1.num23882;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기와 교환 횟수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int swapNum = Integer.parseInt(st.nextToken());
		
		// 선택 정렬 과정에서 진행한 교환 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// 입력 받은 배열의 원소를 저장할 배열 array 초기화
		int[] array = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배열의 원소를 배열 array에 저장
		for (int idx = 0; idx < array.length; idx++)
			array[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 정렬한 숫자를 저장할 각 위치를 순회
		for (int lastIndex = size - 1; lastIndex > 0; lastIndex--) {
			
			// 해당 범위에서 가장 큰 숫자와 그 위치를 저장할 각 변수 초기화
			int maxValue = Integer.MIN_VALUE;
			int maxIndex = -1;
			
			// for 반복문을 사용해 해당 범위에 속하는 각 원소를 순회
			for (int idx = 0; idx <= lastIndex; idx++) {
				
				// 해당 원소가 저장된 가장 큰 숫자보다 큰 경우 가장 큰 숫자와 그 위치를 갱신
				if (array[idx] > maxValue) {
					maxValue = array[idx];
					maxIndex = idx;
				}
			}
			
			// 가장 큰 숫자가 정렬한 숫자를 저장할 위치와 일치하는 경우 다음 위치를 순회
			if (maxIndex == lastIndex)
				continue;
			
			// 가장 큰 숫자가 저장할 위치의 원소와 서로 교환
			array[maxIndex] = array[lastIndex];
			array[lastIndex] = maxValue;
			
			// 선택 정렬 과정에서 진행한 교환 횟수가 목표로 한 교환 횟수에 도달한 경우
			if (++count == swapNum) {
				
				// for 반복문을 사용해 목표 교환 횟수의 교환이 발생한 직후의 배열을 출력
				for (int element : array)
					out.write(element + " ");
				
				// 반복문 탈출
				break;
			}
		}
		
		// 선택 정렬 과정에서 진행한 교환 횟수가 목표로 한 교환 횟수보다 적은 경우 -1 출력
		if (count < swapNum)
			out.write("-1");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}