package silver2.num01535;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 사람의 수, 세준이가 얻을 수 있는 최대 기쁨을 저장할 각 변수 초기화
	static int personNum;
	static int maxHappiness = 0;
	
	// 각 사람에게 인사를 할 때 잃는 체력과 얻는 기쁨을 저장할 각 배열 초기화
	static int[] stamina;
	static int[] happiness;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수를 변수 personNum에 할당
		personNum = Integer.parseInt(in.readLine());
		
		// 각 사람에게 인사를 할 때 잃는 체력과 얻는 기쁨을 저장할 각 배열 초기화
		stamina = new int[personNum];
		happiness = new int[personNum];
		
		// StringTokenizer 객체를 불러와 각 변수에 할당
		StringTokenizer staminaList = new StringTokenizer(in.readLine());
		StringTokenizer happinessList = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 사람에게 인사를 할 때 잃는 체력과 얻는 기쁨을 각 배열에 저장
		for (int idx = 0; idx < personNum; idx++) {
			stamina[idx] = Integer.parseInt(staminaList.nextToken());
			happiness[idx] = Integer.parseInt(happinessList.nextToken());
		}
		
		// happinessCalculator() 메서드를 호출해 세준이가 얻을 수 있는 최대 기쁨을 갱신
		happinessCalculator(0, 100, 0);
		
		// valueOf() 및 write() 메서드를 사용해 세준이가 얻을 수 있는 최대 기쁨을 출력
		out.write(String.valueOf(maxHappiness));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// happinessCalculator() 메서드 정의
	public static void happinessCalculator(int curPerson, int curStamina, int curHappiness) {
		
		// 체력이 0 이하로 떨어진 경우 메서드 종료
		if (curStamina <= 0)
			return;
		
		// 마지막 사람까지 확인한 경우
		if (curPerson == personNum) {
			
			// max() 메서드를 사용해 세준이가 얻을 수 있는 최대 기쁨을 갱신
			maxHappiness = Math.max(curHappiness, maxHappiness);
			
			// 메서드 종료
			return;
		}
		
		// 현재 사람에게 인사했을 경우와 인사하지 않았을 경우를 상정해 happinessCalculator() 메서드 재귀 호출
		happinessCalculator(curPerson + 1, curStamina, curHappiness);
		happinessCalculator(curPerson + 1, curStamina - stamina[curPerson], curHappiness + happiness[curPerson]);
	}
}