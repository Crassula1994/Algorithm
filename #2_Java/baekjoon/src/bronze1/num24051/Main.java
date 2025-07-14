package bronze1.num24051;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기와 목표 저장 횟수를 각 변수에 할당
		int arraySize = Integer.parseInt(st.nextToken());
		int targetCount = Integer.parseInt(st.nextToken());
		
		// 현재 저장 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// 배열의 원소를 저장할 배열 array 초기화
		int[] array = new int[arraySize];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배열의 원소를 배열 array에 저장
		for (int idx = 0; idx < array.length; idx++)
			array[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 배열의 원소를 순회
		outer: for (int idx = 1; idx < array.length; idx++) {
			
			// 해당 원소가 정렬될 위치 및 정렬한 원소를 저장할 각 변수 초기화
			int targetLoc = idx - 1;
			int curElement = array[idx];
			
			// while 반복문을 사용해 해당 원소가 정렬될 위치를 찾을 때까지 순회
			while (0 <= targetLoc && curElement < array[targetLoc]) {
				
				// 현재 저장 횟수 및 기존 원소의 위치를 갱신
				count++;
				array[targetLoc + 1] = array[targetLoc];
				
				// 목표 저장 횟수인 경우 저장된 숫자를 출력 후 반복문 탈출
				if (count == targetCount) {
					out.write(String.valueOf(array[targetLoc + 1]));
					break outer;
				}
				
				// 해당 원소가 정렬될 위치를 갱신
				targetLoc--;
			}
			
			// 해당 원소의 위치를 조정해야 하는 경우 현재 저장 횟수 및 현재 원소의 위치를 갱신
			if (targetLoc + 1 != idx) {
				count++;
				array[targetLoc + 1] = curElement;
			}
			
			// 목표 저장 횟수인 경우 저장된 숫자를 출력 후 반복문 탈출
			if (count == targetCount) {
				out.write(String.valueOf(array[targetLoc + 1]));
				break;
			}
		}
		
		// 저장 횟수가 목표 저장 횟수보다 작은 경우 -1을 출력
		if (count < targetCount)
			out.write("-1");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}