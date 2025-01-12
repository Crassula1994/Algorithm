package bronze3.num12790;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 캐릭터의 최종 전투력을 저장할 변수 combatPower 초기화
			int combatPower = 0;
			
			// 캐릭터의 기본 능력치 및 장비 능력치를 저장할 배열 stats 초기화
			int[] stats = new int[8];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 캐릭터의 기본 능력치 및 장비 능력치를 배열 stats에 저장
			for (int idx = 0; idx < stats.length; idx++)
				stats[idx] = Integer.parseInt(st.nextToken());
			
			// max() 메서드를 사용해 캐릭터의 최종 전투력을 갱신
			combatPower += Math.max(1, stats[0] + stats[4]);
			combatPower += Math.max(1, stats[1] + stats[5]) * 5;
			combatPower += Math.max(0, stats[2] + stats[6]) * 2;
			combatPower += (stats[3] + stats[7]) * 2;
			
			// write() 메서드를 사용해 캐릭터의 최종 전투력을 출력
			out.write(combatPower + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}