package silver2.num28491;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 칼의 개수를 변수 swordNum에 할당
		int swordNum = Integer.parseInt(in.readLine());
		
		// 쓸모 있는 칼의 개수 및 유용성을 판단할 방어력 기준을 저장할 각 변수 초기화
		int count = 0;
		int lowerLimit = 0;
		
		// 각 칼의 공격력과 방어력을 저장할 2차원 배열 sowrds 초기화
		int[][] swords = new int[swordNum][2];
		
		// for 반복문을 사용해 각 칼의 정보를 순회
		for (int idx = 0; idx < swords.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 칼의 정보를 2차원 배열 swords에 저장
			swords[idx][0] = Integer.parseInt(st.nextToken());
			swords[idx][1] = Integer.parseInt(st.nextToken());			
		}
		
		// sort() 메서드를 사용해 칼을 공격력, 방어력순으로 오름차순 정렬
		Arrays.sort(swords, (s1, s2) -> {
			return (s1[0] == s2[0]) ? s1[1] - s2[1] : s1[0] - s2[0];
		});
		
		// for 반복문을 사용해 공격력이 높은 순으로 칼의 정보를 순회
		for (int idx = swords.length - 1; idx >= 0; idx--) {
			
			// 해당 칼이 쓸모 있는 칼인 경우 쓸모 있는 칼의 개수 및 유용성을 판단할 방어력 기준을 갱신
			if (swords[idx][1] > lowerLimit) {
				count++;
				lowerLimit = swords[idx][1];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 쓸모 있는 칼의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}