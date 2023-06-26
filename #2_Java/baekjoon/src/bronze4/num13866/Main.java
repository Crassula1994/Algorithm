package bronze4.num13866;

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
		
		// 네 명의 스킬 레벨을 저장할 배열 skillLevels에 저장
		int[] skillLevels = new int[4];
		
		// for 반복문을 사용해 입력 받은 각 스킬 레벨을 배열 skillLevels에 저장
		for (int idx = 0; idx < 4; idx++)
			skillLevels[idx] = Integer.parseInt(st.nextToken());

		// 두 팀의 스킬 레벨 차이의 최솟값을 출력할 변수 minDiffernce 초기화
		int minDifference = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 가능한 두 팀의 조합을 순회
		for (int c = 1; c < 4; c++) {
			
			// 각 팀의 스킬 레벨의 합을 각 변수에 저장
			int team1 = skillLevels[0] + skillLevels[c];
			int team2 = skillLevels[1] + skillLevels[2] + skillLevels[3] - skillLevels[c];
			
			// abs() 메서드를 사용해 두 팀의 스킬 레벨의 차이를 변수 difference에 할당
			int difference = Math.abs(team1 - team2);
			
			// min() 메서드를 사용해 두 팀의 스킬 레벨 차이의 최솟값을 갱신
			minDifference = Math.min(difference, minDifference);
			
			// 두 팀의 스킬 레벨의 차이가 없는 경우 반복문 탈출
			if (minDifference == 0)
				break;
		}
		
		// valueOf() 및 write() 메서드를 사용해 두 팀의 스킬 레벨 차이의 최솟값을 출력
		out.write(String.valueOf(minDifference));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}