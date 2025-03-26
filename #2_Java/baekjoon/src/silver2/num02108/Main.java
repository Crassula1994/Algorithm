package silver2.num02108;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());

		// 해당 숫자의 등장 여부를 확인할 배열 numbers 초기화
		int[] numbers = new int[8001];
		
		// 숫자를 오름차순으로 정렬해 저장할 List 객체 orderedList 초기화
		List<Integer> orderedList = new ArrayList<>();
		
		// 최빈값을 저장할 List 객체 modeList 초기화
		List<Integer> modeList = new ArrayList<>();
		
		// 각 숫자의 총합 및 빈도수를 저장할 각 변수 초기화
		double sum = 0;
		int count = 0;
		
		// for 반복문을 사용해 입력 받은 각 숫자를 순회
		for (int i = 0; i < length; i++) {

			// readLine() 및 parseInt() 메서드를 사용해 입력받은 숫자를 변수 num에 할당
			int num = Integer.parseInt(in.readLine());

			// 총합에 숫자를 더해 총합 갱신
			sum += num;
			
			// 해당 숫자를 배열 numbers에 추가
			numbers[num + 4000]++;
		}

		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int idx = 0; idx < numbers.length; idx++) {
			
			// 해당 숫자가 등장한 경우
			if (numbers[idx] != 0) {
				
				// 등장횟수가 빈도수보다 큰 경우
				if (numbers[idx] > count) {
					
					// 메서드를 사용해 빈도수 modeList 초기화
					modeList.clear();
					
					// add() 메서드를 사용해 modeList에 추가
					modeList.add(idx - 4000);
					
					// 빈도수를 등장횟수로 갱신
					count = numbers[idx];
					
				// 등장횟수가 빈도수와 같은 경우 add() 메서드를 사용해 modeList에 추가
				} else if (numbers[idx] == count) {
					modeList.add(idx - 4000);
				}

				// for 반복문 및 add() 메서드를 사용해 해당 숫자를 List 객체 orderedList에 추가
				for (int j = 0; j < numbers[idx]; j++)
					orderedList.add(idx - 4000);
			}
		}
		
		// round() 및 write() 메서드를 사용해 산술평균을 출력
		out.write(Math.round(sum / length) + "\n");
		
		// get() 및 write() 메서드를 사용해 중앙값을 출력
		out.write(orderedList.get(length / 2) + "\n");
		
		// 최빈값이 2개 이상인 경우 두 번째로 작은 값을 출력
		if (modeList.size() > 1) {
			out.write(modeList.get(1) + "\n");
		
		// 최빈값이 1개인 경우 그대로 출력
		} else {
			out.write(modeList.get(0) + "\n");
		}
		
		// size(), get(), valueOf(), write() 메서드를 사용해 범위를 출력
		out.write(String.valueOf(orderedList.get(orderedList.size() - 1) - orderedList.get(0)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}