package silver4.num20125;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정사각형 판의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 심장의 위치, 머리를 찾았는지 여부를 저장할 각 변수 초기화
		int heartRow = 0;
		int heartColumn = 0;
		boolean isDetected = false;
		
		// 쿠키 신체의 길이를 저장할 배열 lengths 초기화
		int[] lengths = new int[5];
		
		// 입력 받은 판의 상태를 저장할 2차원 배열 plate 초기화
		char[][] plate = new char[size + 1][size + 1];
		
		// for 반복문을 사용해 정사각형 판의 각 행을 순회
		for (int r = 1; r <= size; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 정사각형 판의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 정사각형 판의 각 칸을 순회
			for (int c = 1; c <= size; c++) {
			
				// charAt() 메서드를 사용해 정사각형 판의 상태를 2차원 배열 plate에 저장
				plate[r][c] = line.charAt(c - 1);
				
				// 쿠키의 머리를 찾은 경우 심장의 위치, 머리를 찾았는지 여부를 갱신
				if (!isDetected && plate[r][c] == '*') {
					heartRow = r + 1;
					heartColumn = c;
					isDetected = true;
				}
			}
		}
		
		// for 반복문을 사용해 왼쪽 팔을 순회
		for (int c = heartColumn - 1; c > 0; c--) {
			
			// 왼쪽 팔이 끝난 경우 반복문 탈출
			if (plate[heartRow][c] == '_')
				break;
			
			// 왼쪽 팔의 길이를 갱신
			lengths[0]++;
		}
		
		// for 반복문을 사용해 오른쪽 팔을 순회
		for (int c = heartColumn + 1; c <= size; c++) {
			
			// 오른쪽 팔이 끝난 경우 반복문 탈출
			if (plate[heartRow][c] == '_')
				break;
			
			// 오른쪽 팔의 길이를 갱신
			lengths[1]++;
		}
		
		// for 반복문을 사용해 허리를 순회
		for (int r = heartRow + 1; r <= size; r++) {
			
			// 허리가 끝난 경우 반복문 탈출
			if (plate[r][heartColumn] == '_')
				break;
			
			// 허리의 길이를 갱신
			lengths[2]++;
		}
		
		// for 반복문을 사용해 왼쪽 다리를 순회
		for (int r = heartRow + lengths[2] + 1; r <= size; r++) {
			
			// 왼쪽 다리가 끝난 경우 반복문 탈출
			if (plate[r][heartColumn - 1] == '_')
				break;
			
			// 왼쪽 다리의 길이를 갱신
			lengths[3]++;
		}
		
		// for 반복문을 사용해 오른쪽 다리를 순회
		for (int r = heartRow + lengths[2] + 1; r <= size; r++) {
			
			// 오른쪽 다리가 끝난 경우 반복문 탈출
			if (plate[r][heartColumn + 1] == '_')
				break;
			
			// 오른쪽 다리의 길이를 갱신
			lengths[4]++;
		}
		
		// write() 메서드를 사용해 심장의 위치를 출력
		out.write(heartRow + " " + heartColumn + "\n");
		
		// for 반복문을 사용해 쿠키의 각 신체 길이를 출력
		for (int length : lengths)
			out.write(length + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}