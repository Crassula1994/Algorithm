package silver1.num26091;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학회원의 수 및 팀의 최소 능력치를 각 변수에 할당
		int memberNum = Integer.parseInt(st.nextToken());
		int abilityLimit = Integer.parseInt(st.nextToken());
		
		// 동건이가 견학 보낼 수 있는 최대 팀 수를 저장할 변수 maxTeam 초기화
		int maxTeam = 0;
		
		// 각 학회원의 능력치를 저장할 배열 abilities 초기화
		int[] abilities = new int[memberNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 학회원의 능력치를 배열 abilities에 저장
		for (int idx = 0; idx < abilities.length; idx++)
			abilities[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 각 학회원의 능력치를 오름차순으로 정렬
		Arrays.sort(abilities);
		
		// 팀으로 만들 두 학회원의 위치를 나타낼 각 변수 초기화
		int low = 0;
		int high = abilities.length - 1;
		
		// while 반복문을 사용해 더 이상 팀을 만들 수 없을 때까지 순회
		while (low < high) {
			
			// 두 사람의 능력치 합이 최소 능력치를 만족하는 경우
			if (abilities[low] + abilities[high] >= abilityLimit) {
				
				// 동건이가 견학 보낼 수 있는 최대 팀 수를 갱신
				maxTeam++;
				
				// 팀을 이룬 두 학회원을 제외
				low++;
				high--;
			
			// 두 사람의 능력치 합이 최소 능력치를 만족하지 못하는 경우 더 높은 능력치를 가진 학회원을 확인
			} else {
				low++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 동건이가 견학 보낼 수 있는 최대 팀 수를 출력
		out.write(String.valueOf(maxTeam));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}