package silver2.num09658;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 돌의 개수를 변수 stoneNum에 할당
		int stoneNum = Integer.parseInt(in.readLine());
		
		// max() 메서드를 사용해 돌의 개수에 따라 상근이가 이길 수 있는지 여부를 저장할 배열 canWin 초기화
		boolean[] canWin = new boolean[Math.max(5, stoneNum + 1)];
		
		// 돌이 2개 또는 4개일 때는 상근이가 이기므로 값을 갱신
		canWin[2] = true;
		canWin[4] = true;
		
		// for 반복문을 사용해 각 돌의 개수를 순회
		for (int idx = 5; idx < canWin.length; idx++) {
			
			// 상근이가 이길 수 있는 경우 값을 갱신
			if (!canWin[idx - 1] || !canWin[idx - 3] || !canWin[idx - 4])
				canWin[idx] = true;
		}
		
		// write() 메서드를 사용해 게임을 이기는 사람을 출력
		out.write((canWin[stoneNum]) ? "SK" : "CY");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}