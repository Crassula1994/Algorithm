package silver3.num18429;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	/* 운동 키트의 개수와 하루에 감소하는 중량, 운동 기간 동안 항상 중량이 500 이상이 되도록 하는 경우의 수를 저장할
	각 변수 초기화 */
	static int kitNum;
	static int diminution;
	static int count = 0;
	
	// 각 운동 키트의 중량 증가량과 그 사용 여부를 저장할 각 배열 초기화
	static int[] fitnessKits;
	static boolean[] used;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 운동 키트의 개수와 하루에 감소하는 중량을 각 변수에 할당
		kitNum = Integer.parseInt(st.nextToken());
		diminution = Integer.parseInt(st.nextToken());
		
		// 각 운동 키트의 중량 증가량과 그 사용 여부를 저장할 각 배열 초기화
		fitnessKits = new int[kitNum];
		used = new boolean[kitNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 우동 키트의 중량 증가량을 배열 fitnessKits에 저장
		for (int idx = 0; idx < fitnessKits.length; idx++)
			fitnessKits[idx] = Integer.parseInt(st.nextToken());
		
		// fitnessPlanner() 메서드를 호출해 운동 기간 동안 항상 중량이 500 이상이 되도록 하는 경우의 수를 갱신
		fitnessPlanner(0, 500);
		
		// valueOf() 및 write() 메서드를 사용해 운동 기간 동안 항상 중량이 500 이상이 되도록 하는 경우의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// fitnessPlanner() 메서드 정의
	public static void fitnessPlanner(int usedNum, int weight) {
		
		// 운동 키트를 사용 후 중량이 500 미만으로 떨어진 경우 메서드 종료
		if (weight < 500)
			return;
		
		// 운동 키트를 모두 사용한 경우 운동 기간 동안 항상 중량이 500 이상이 되도록 하는 경우의 수를 갱신 후 메서드 종료
		if (usedNum == kitNum) {
			count++;
			return;
		}
		
		// for 반복문을 사용해 각 운동 키트를 순회
		for (int idx = 0; idx < kitNum; idx++) {
			
			// 해당 키트를 사용한 경우 다음 운동 키트를 순회
			if (used[idx])
				continue;
			
			// 해당 운동 키트를 사용한 것으로 처리
			used[idx] = true;
			
			// fitnessPlanner() 메서드 재귀 호출
			fitnessPlanner(usedNum + 1, weight + fitnessKits[idx] - diminution);
			
			// 해당 운동 키트를 사용하지 않은 것으로 원상 복구
			used[idx] = false;
		}
	}
}