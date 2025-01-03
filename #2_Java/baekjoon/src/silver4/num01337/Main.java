package silver4.num01337;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
		// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 올바른 배열이 되기 위해 추가되어야 할 원소의 최소 개수를 저장할 변수 minCount 초기화
		int minCount = 5;
		
		// 입력 받은 원소를 저장할 배열 array 초기화
		int[] array = new int[size];
		
		// for 반복문을 사용해 입력 받은 배열의 원소를 배열 array에 저장
		for (int idx = 0; idx < array.length; idx++)
			array[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 배열의 원소를 오름차순으로 정렬
		Arrays.sort(array);
		
		// for 반복문을 사용해 각 원소를 기준으로 연속된 구간을 순회
		for (int start = 0; start < array.length; start++) {
			
			// 연속된 원소의 개수를 저장할 변수 count 초기화
			int count = 1;
			
			// for 반복문을 사용해 각 원소를 기준으로 연속될 수 있는 원소를 순회
			for (int end = start + 1; end < array.length; end++) {
				
				// 해당 원소가 시작 원소와 5 이상 차이가 나는 경우 반복문 탈출
				if (array[end] - array[start] >= 5)
					break;
				
				// 연속된 원소의 개수를 갱신
				count++;
			}
			
			// min() 메서드를 사용해 올바른 배열이 되기 위해 추가되어야 할 원소의 최소 개수를 갱신
			minCount = Math.min(5 - count, minCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 올바른 배열이 되기 위해 추가되어야 할 원소의 최소 개수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}