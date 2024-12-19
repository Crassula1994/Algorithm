package silver4.num20044;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 팀의 수를 변수 teamNum에 할당
		int teamNum = Integer.parseInt(in.readLine());
		
		// 팀의 코딩 역량 중 최솟값의 최댓값을 저장할 변수 minAbility 초기화
		int minAbility = Integer.MAX_VALUE;
		
		// 각 학생의 코딩 역량을 저장할 배열 codingAbilities 초기화
		int[] codingAbilities = new int[teamNum * 2];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 학생의 코딩 역량을 배열 codingAbilities에 저장
		for (int idx = 0; idx < codingAbilities.length; idx++)
			codingAbilities[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 각 학생의 코딩 역량을 오름차순으로 정렬
		Arrays.sort(codingAbilities);
		
		// for 반복문을 사용해 팀의 코딩 역량 중 최솟값의 최댓값을 갱신
		for (int idx = 0; idx < teamNum; idx++)
			minAbility = Math.min(codingAbilities[idx] + codingAbilities[teamNum * 2 - idx - 1], minAbility);
		
		// valueOf() 및 write() 메서드를 사용해 팀의 코딩 역량 중 최솟값의 최댓값을 출력
		out.write(String.valueOf(minAbility));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}