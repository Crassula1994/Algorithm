package gold4.num22945;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 개발자의 수를 변수 developerNum에 할당
		int developerNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 각 개발자의 능력치를 저장할 배열 developers 초기화
		int[] developers = new int[developerNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 개발자의 능력치를 배열 developers에 저장
		for (int idx = 0; idx < developers.length; idx++)
			developers[idx] = Integer.parseInt(st.nextToken());
		
		// 팀의 최대 능력치, 두 개발자를 저장할 각 변수 초기화
		int maxAbility = 0;
		int left = 0;
		int right = developerNum - 1;
		
		// while 반복문을 사용해 두 개발자가 서로 교차할 때까지 순회
		while (left < right) {
			
			// min() 메서드를 사용해 해당 위치에서의 팀의 능력치를 계산해 변수 ability에 저장
			int ability = (right - left - 1) * Math.min(developers[left], developers[right]);
			
			// max() 메서드를 사용해 팀의 최대 능력치를 갱신
			maxAbility = Math.max(ability, maxAbility);
			
			// 오른쪽의 개발자가 더 능력치가 높을 경우 왼쪽 개발자를 교체
			if (developers[left] < developers[right]) {
				left++;
				
			// 왼쪽의 개발자가 더 능력치가 높을 경우 경우 오른쪽 개발자를 교체
			} else if (developers[left] > developers[right]) {
				right--;
				
			// 두 개발자의 능력치가 같을 경우 두 개발자를 모두 교체
			} else {
				left++;
				right--;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 팀의 최대 능력치를 출력
		out.write(String.valueOf(maxAbility));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}