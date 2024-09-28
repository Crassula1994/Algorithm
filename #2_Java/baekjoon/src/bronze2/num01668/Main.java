package bronze2.num01668;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 트로피의 개수를 변수 trophyNum에 할당
		int trophyNum = Integer.parseInt(in.readLine());
		
		// 왼쪽과 오른쪽에서 봤을 때 보이는 트로피의 개수, 현재까지 가장 높은 트로피의 높이를 저장할 각 변수 초기화
		int leftCount = 0;
		int rightCount = 0;
		int leftMaxHeight = 0;
		int rightMaxHeight = 0;
		
		// 입력 받은 트로피의 높이를 저장할 배열 trophies 초기화
		int[] trophies = new int[trophyNum];
		
		// for 반복문을 사용해 입력 받은 각 트로피의 높이를 순회
		for (int idx = 0; idx < trophies.length; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 트로피의 높이를 배열 trophies에 저장
			trophies[idx] = Integer.parseInt(in.readLine());
			
			// 현재까지 저장된 가장 높은 트로피의 높이보다 현재 트로피의 높이가 더 높은 경우
			if (leftMaxHeight < trophies[idx]) {
				
				// 현재까지 저장된 가장 높은 트로피의 높이 및 왼쪽에서 봤을 때 보이는 트로피의 개수를 갱신
				leftMaxHeight = trophies[idx];
				leftCount++;
			}
		}
		
		// for 반복문을 사용해 입력 받은 각 트로피의 높이를 거꾸로 순회
		for (int idx = trophies.length - 1; idx >= 0; idx--) {
			
			// 가장 높은 트로피에 도달한 경우 반복문 탈출
			if (rightMaxHeight == leftMaxHeight)
				break;
			
			// 현재까지 저장된 가장 높은 트로피의 높이보다 현재 트로피의 높이가 더 높은 경우
			if (rightMaxHeight < trophies[idx]) {
				
				// 현재까지 저장된 가장 높은 트로피의 높이 및 오른쪽에서 봤을 때 보이는 트로피의 개수를 갱신
				rightMaxHeight = trophies[idx];
				rightCount++;
			}
		}
		
		// write() 메서드를 사용해 왼쪽과 오른쪽에서 봤을 때 보이는 트로피의 개수를 출력
		out.write(leftCount + "\n" + rightCount);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}