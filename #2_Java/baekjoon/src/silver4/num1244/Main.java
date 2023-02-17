package silver4.num1244;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 스위치 개수를 변수 switchNum에 할당
		int switchNum = Integer.parseInt(in.readLine());
		
		// 스위치의 상태를 저장할 배열 switches 초기화
		boolean[] switches = new boolean[switchNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 switches의 각 원소를 순회
		for (int idx = 0; idx < switches.length; idx++) {
		
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 스위치의 상태를 변수 status에 할당
			int status = Integer.parseInt(st.nextToken());
			
			// 스위치의 상태를 배열 switches에 저장
			switches[idx] = (status == 0) ? false : true;
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 학생을 순회
		for (int student = 0; student < studentNum; student++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 성별 및 인덱스를 각 변수에 할당
			int sex = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			// 남학생인 경우
			if (sex == 1) {
				
				// for 반복문을 사용해 해당 인덱스부터 차례로 스위치의 상태를 변경
				for (int idx = index - 1; idx < switches.length; idx += index)
					switches[idx] = !switches[idx];
				
			// 여학생인 경우
			} else {
				
				// 인덱스 위치의 스위치 상태를 변경
				switches[index - 1] = !switches[index - 1];
				
				// for 반복문을 통해 배열에서 대칭인 값을 차례로 순회
				for (int length = 1; length < switchNum / 2; length++) {
					
					// 해당 수열의 인덱스가 배열을 넘어서지 않는 경우
					if (index - length - 1 >= 0 && index + length - 1 < switchNum) {
						
						// 각 위치의 스위치가 대칭인 경우 대칭인 배열의 스위치 상태를 변경
						if (switches[index - length - 1] == switches[index + length - 1]) {
							switches[index - length - 1] = !switches[index - length - 1];
							switches[index + length - 1] = !switches[index + length - 1];
						
						// 대칭이 아닌 경우 반복문 탈출
						} else {
							break;
						}

					// 해당 수열의 인덱스가 배열을 넘어서는 경우 반복문 탈출
					} else {
						break;
					}
				}
			}
		}
		
		// for 반복문을 사용해 switches의 각 원소를 순회
		for (int idx = 0; idx < switches.length; idx++) {
			
			// 해당 스위치의 상태를 변수 status에 할당
			int status = (switches[idx]) ? 1 : 0;

			// write() 메서드를 사용해 해당 스위치의 상태를 출력
			out.write(status + " ");
			
			// 20번째 스위치마다 줄바꿈 출력
			if ((idx + 1) % 20 == 0)
				out.write("\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}