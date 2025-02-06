package bronze2.num02484;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 참여하는 사람의 수를 변수 participantNum에 할당
		int participantNum = Integer.parseInt(in.readLine());
		
		// 가장 많은 상금을 받은 사람의 상금을 저장할 변수 maxPrizeMoney 초기화
		int maxPrizeMoney = 0;
		
		// while 반복문을 사용해 각 참여하는 사람을 순회
		while (participantNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 주사위의 각 눈이 나온 개수를 저장할 배열 spotCounts 초기화
			int[] spotCounts = new int[7];
			
			// for 반복문을 사용해 주사위의 각 눈이 나온 개수를 갱신
			for (int dice = 0; dice < 4; dice++)
				spotCounts[Integer.parseInt(st.nextToken())]++;
			
			// prizeMoneyCalculator() 및 max() 메서드를 사용해 가장 많은 상금을 받은 사람의 상금을 갱신
			maxPrizeMoney = Math.max(prizeMoneyCalculator(spotCounts), maxPrizeMoney);
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 많은 상금을 받은 사람의 상금을 출력
		out.write(String.valueOf(maxPrizeMoney));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// prizeMoneyCalculator() 메서드 정의
	@SuppressWarnings("unchecked")
	public static int prizeMoneyCalculator(int[] spotCounts) {
		
		// 각 눈이 나온 개수별로 해당 눈을 저장할 배열 counts 초기화
		List<Integer>[] counts = new ArrayList[5];
		
		// for 반복문을 사용해 각 눈이 나온 개수별로 눈을 저장할 List 객체 초기화
		for (int idx = 0; idx < counts.length; idx++)
			counts[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 눈이 나온 개수별로 counts에 저장
		for (int spot = 1; spot <= 6; spot++)
			counts[spotCounts[spot]].add(spot);
		
		// 같은 눈이 네 개가 나온 경우 상금을 계산하여 반환
		if (!counts[4].isEmpty())
			return 50000 + counts[4].get(0) * 5000;
		
		// 같은 눈이 세 개가 나온 경우 상금을 계산하여 반환
		if (!counts[3].isEmpty())
			return 10000 + counts[3].get(0) * 1000;
		
		// 같은 눈이 두 개씩 두 쌍이 나온 경우 상금을 계산하여 반환
		if (counts[2].size() == 2)
			return 2000 + counts[2].get(0) * 500 + counts[2].get(1) * 500;
		
		// 같은 눈이 두 개씩 한 쌍만 나온 경우 상금을 계산하여 반환
		if (!counts[2].isEmpty())
			return 1000 + counts[2].get(0) * 100;
		
		// size() 및 get() 메서드를 사용해 모두 다른 눈이 나온 경우 상금을 계산하여 반환
		return counts[1].get(counts[1].size() - 1) * 100;
	}
}