package silver4.num01940;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 재료의 개수 및 갑옷을 만드는 데 필요한 수를 각 변수에 할당
		int materialNum = Integer.parseInt(in.readLine());
		int targetNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 재료를 저장할 배열 materials 초기화
		int[] materials = new int[materialNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 materials에 저장
		for (int idx = 0; idx < materialNum; idx++)
			materials[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 materials를 오름차순으로 정렬
		Arrays.sort(materials);

		// 재료의 개수가 1개인 경우 0을 출력
		if (materialNum == 1) {
			out.write(String.valueOf(0));
			
		// 재료의 개수가 2개 이상인 경우
		} else {
			
			// 만들 수 있는 갑옷의 수를 저장할 변수 armorCnt 초기화
			int armorCnt = 0;
				
			// 만들 수 있는 갑옷의 수를 탐색하기 위해 필요한 각 변수 초기화
			int left = 0;
			int right = materialNum - 1;
				
			// while 반복문을 사용해 두 재료가 교차하지 않을 때까지 순회
			while (left < right) {
				
				// 두 재료의 합으로 갑옷을 만들 수 있는 경우 만들 수 있는 갑옷의 수를 갱신
				if (materials[left] + materials[right] == targetNum) {
					armorCnt++;
					left++;
					right--;

				// 두 재료의 합이 더 큰 경우 오른쪽 재료의 값을 조정
				} else if (materials[left] + materials[right] > targetNum) {
					right--;
					
				// 두 재료의 합이 더 작은 경우 왼쪽 재료의 값을 조정
				} else {
					left++;
				}
			}
			
			// valueOf() 및 write() 메서드를 사용해 들 수 있는 갑옷의 수를 출력
			out.write(String.valueOf(armorCnt));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}