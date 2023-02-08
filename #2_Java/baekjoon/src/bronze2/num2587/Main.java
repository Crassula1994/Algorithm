package bronze2.num2587;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 자연수의 등장 횟수를 저장할 배열 count 초기화
		int[] count = new int[10];
		
		// 숫자를 차례로 저장할 List 객체 orderedList 초기화
		List<Integer> orderedList = new ArrayList<>();
		
		// 각 자연수의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 다섯 개의 수를 순회
		for (int i = 0; i < 5; i++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 해당 숫자를 총합에 합쳐 갱신
			sum += number;
			
			// 배열 count에 입력 받은 숫자의 개수를 갱신
			count[(number / 10) - 1]++;
		}
		
		// for 반복문을 사용하여 배열 count의 각 원소를 순회
		for (int idx = 0; idx < count.length; idx++) {
			
			// 해당 원소가 0이 아닌 경우 
			if (count[idx] != 0) {
				
				// for 반복문 및 add() 메서드를 사용해 List 객체 orderedList에 개수만큼 추가
				for (int j = 0; j < count[idx]; j++)
					orderedList.add((idx + 1) * 10);
			}
		}
		
		// get() 및 write() 메서드를 사용해 평균과 중앙값을 출력
		out.write((sum / 5) + "\n" + orderedList.get(2));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}