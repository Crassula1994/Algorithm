package silver1.num02343;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 강의의 수 및 블루레이의 수를 각 변수에 할당
		int lectureNum = Integer.parseInt(st.nextToken());
		int blurayNum = Integer.parseInt(st.nextToken());
		
		// 각 강의의 길이를 저장할 배열 lectureLen 초기화
		int[] lectureLen = new int[lectureNum];
		
		// 가능한 블루레이 크기의 상한과 하한을 저장할 각 변수 초기화
		int upperLimit = 0;
		int lowerLimit = Integer.MIN_VALUE;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 강의의 길이를 순회
		for (int idx = 0; idx < lectureNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 강의의 길이를 배열 lectureLen에 저장
			lectureLen[idx] = Integer.parseInt(st.nextToken());
			
			// 블루레이 크기의 상한을 갱신
			upperLimit += lectureLen[idx];
			
			// max() 메서드를 사용해 블루레이 크기의 하한을 갱신
			lowerLimit = Math.max(lectureLen[idx], lowerLimit);
		}
		
		// while 반복문을 사용해 가능한 블루레이 크기 중 최소 크기를 찾을 때까지 순회
		while (lowerLimit <= upperLimit) {
			
			// 블루레이 크기의 상한과 하한의 중간 값을 계산해 변수 size에 할당
			int size = (lowerLimit + upperLimit) / 2;
			
			// 해당 크기로 만들 수 있는 블루레이의 수, 각 블루레이에 저장된 강의의 크기를 저장할 각 변수 초기화
			int count = 1;
			int sum = 0;
			
			// for 반복문을 사용해 각 강의의 길이를 순회
			for (int idx = 0; idx < lectureNum; idx++) {
				
				// 현재 블루레이에 강의를 추가로 넣을 수 있는 경우 현재 블루레이에 저장된 강의의 크기를 갱신
				if (sum + lectureLen[idx] <= size) {
					sum += lectureLen[idx];
				
				// 현재 블루레이에 강의를 추가로 넣을 수 없는 경우 새로운 블루레이에 강의를 저장
				} else {
					sum = lectureLen[idx];
					count++;
				}
			}
			
			// 필요한 블루레이의 수가 준비한 블루레이의 수보다 많은 경우 블루레이 크기의 하한을 갱신
			if (count > blurayNum) {
				lowerLimit = size + 1;
				
			// 필요한 블루레이의 수가 준비한 블루레이의 수보다 적거나 같은 경우 블루레이 크기의 상한을 갱신
			} else {
				upperLimit = size - 1;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가능한 블루레이 중 최소 크기를 출력
		out.write(String.valueOf(lowerLimit));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}