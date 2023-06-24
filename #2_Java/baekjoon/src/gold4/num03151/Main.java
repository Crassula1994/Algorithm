package gold4.num03151;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 각 학생의 코딩 실력을 저장할 배열 abilities 초기화
		int[] abilities = new int[studentNum];

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 학생들의 코딩 실력을 배열 abilities에 저장
		for (int idx = 0; idx < abilities.length; idx++)
			abilities[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 abilities를 오름차순으로 정렬
		Arrays.sort(abilities);
		
		// 세 사람의 코딩 실력의 합이 0이 되는 경우의 수를 저장할 변수 count 초기화
		long count = 0;
		
		// for 반복문을 사용해 선택한 한 명의 학생을 순회
		for (int s1 = 0; s1 < abilities.length - 2; s1++) {
			
			// 선택한 첫 학생의 능력치가 0을 초과한 경우 반복문 탈출
			if (abilities[s1] > 0)
				break;
			
			// 나머지 두 명의 학생을 나타낼 각 변수 초기화
			int s2 = s1 + 1;
			int s3 = abilities.length - 1;
			
			// while 반복문을 사용해 두 명의 학생이 교차할 때까지 순회
			while (s2 < s3) {
				
				// 세 명의 능력치의 합을 계산해 변수 sum에 할당
				int sum = abilities[s1] + abilities[s2] + abilities[s3];

				// 세 명의 능력치의 합이 0인 경우
				if (sum == 0) {
					
					// 두 학생의 코딩 실력이 같은 경우
					if (abilities[s2] == abilities[s3]) {
						
						// 코딩 실력이 같은 학생들의 수를 계산해 변수 sameAbilities에 할당
						int sameAbilities = s3 - s2 + 1;
						
						// 경우의 수를 갱신 후 반복문 탈출
						count += sameAbilities * (sameAbilities - 1) / 2;
						break;
					}
					
					// 각 학생들의 같은 능력치를 가진 사람의 수를 나타낼 변수 초기화
					int sameS2 = 1;
					int sameS3 = 1;
					
					// while 반복문을 사용해 두 번째 학생과 같은 능력치를 지니는 학생의 수를 갱신
					while (s2 + 1 < s3 && abilities[s2] == abilities[s2 + 1]) {
						sameS2++;
						s2++;
					}
					
					// while 반복문을 사용해 세 번째 학생과 같은 능력치를 지니는 학생의 수를 갱신
					while (s3 - 1 > s2 && abilities[s3] == abilities[s3 - 1]) {
						sameS3++;
						s3--;
					}
					
					// 경우의 수를 갱신
					count += sameS2 * sameS3;
					
					// 두 명의 학생을 모두 교체
					s2++;
					s3--;
					
				// 세 명의 능력치의 합이 0보다 큰 경우 합을 축소
				} else if (sum > 0) {
					s3--;
					
				// 세 명의 능력치의 합이 0보다 작은 경우 합을 증가
				} else {
					s2++;
				}
			}
		}

		// valueOf() 및 write() 메서드를 사용해 세 사람의 코딩 실력의 합이 0이 되는 경우의 수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}