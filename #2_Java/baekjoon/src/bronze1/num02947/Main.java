package bronze1.num02947;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 나무 조각의 숫자를 저장할 배열 woodPieces 초기화
	static int[] woodPieces = new int[5];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 나무 조각의 번호를 배열 woodPieces에 저장
		for (int idx = 0; idx < woodPieces.length; idx++)
			woodPieces[idx] = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 순서대로 배열될 때까지 순회
		while (true) {
			
			// for 반복문을 사용해 첫 번째 조각부터 네 번째 조각까지 순회
			for (int i = 0; i < 4; i++) {
				
				// 앞에 놓인 나무 조각 수가 뒤에 놓인 나무 조각 수보다 큰 경우
				if (woodPieces[i] > woodPieces[i + 1]) {
					
					// locationChanger() 메서드를 호출해 각 나무 조각의 위치를 변경
					locationChanger(i);
					
					// for 반복문을 사용해 나무 조각의 순서를 출력
					for (int j = 0; j < woodPieces.length; j++)
						out.write(woodPieces[j] + " ");
					
					// newLine() 메서드를 사용해 줄바꿈 출력
					out.newLine();
				}
			}
			
			// 조각이 순서대로 배열된 경우 반복문 탈출
			if (locationChecker())
				break;
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// locationChanger() 메서드 정의
	public static void locationChanger(int idx) {
		
		// 바꿀 위치의 나무 조각의 수를 임시로 저장할 변수 tempPiece 초기화
		int tempPiece = woodPieces[idx];
		
		// 두 나무 조각의 위치를 변경
		woodPieces[idx] = woodPieces[idx + 1];
		woodPieces[idx + 1] = tempPiece;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// locationChecker() 메서드 정의
	public static boolean locationChecker() {
		
		// for 반복문을 사용해 각 나무 조각의 위치를 순회
		for (int idx = 0; idx < woodPieces.length; idx++) {
			
			// 나무 조각이 순서대로 배열되지 않은 경우 false 반환
			if (woodPieces[idx] != idx + 1)
				return false;
		}
		
		// 나무 조각이 순서대로 배열된 경우 true 반환
		return true;
	}
}