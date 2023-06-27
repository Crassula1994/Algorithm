package d3.num01216;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Solution 클래스 정의
public class Solution {
    
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < 10; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 번호를 변수 testCase에 할당
			int testCase = Integer.parseInt(in.readLine());
			
			// 글자판의 정보를 저장할 2차원 배열 letterBoard 초기화
			char[][] letterBoard = new char[100][100];
			
			// for 반복문을 사용해 글자판의 각 행을 순회
			for (int r = 0; r < 100; r++) {
				
				// readLine() 메서드를 사용해 입력 받은 글자판의 행의 정보를 변수 line에 할당
				String line = in.readLine();
				
				// for 반복문을 사용해 각 글자를 2차원 배열 letterBoard에 저장
				for (int c = 0; c < 100; c++)
					letterBoard[r][c] = line.charAt(c);
			}
			
			// 가장 긴 회문의 길이를 저장할 변수 maxLength 초기화
			int maxLength = 0;
			
			// for 반복문을 사용해 각 행을 차례로 순회
			for (int r = 0; r < 100; r++) {
				
				// for 반복문을 사용해 각 회문의 길이를 순회
				outer1: for (int l = 100; l > maxLength; l--) {

					// for 반복문을 사용해 각 시작 인덱스를 순회
					outer2: for (int c = 0; c < 101 - l; c++) {
						
						// for 반복문을 사용해 각 글자를 순회
						for (int i = 0; i < l / 2; i++) {
							
							// 두 글자가 대칭이 아닌 경우 다음 시작 인덱스를 순회
							if (letterBoard[r][c + i] != letterBoard[r][c + l - i - 1])
								continue outer2;
						}
						
						// 가장 긴 회문의 길이 갱신 및 반복문 탈출
						maxLength = l;
						break outer1;
					}
				}
			}
			
			// for 반복문을 사용해 각 열을 차례로 순회
			for (int c = 0; c < 100; c++) {
				
				// for 반복문을 사용해 각 회문의 길이를 순회
				outer1: for (int l = 100; l > maxLength; l--) {

					// for 반복문을 사용해 각 시작 인덱스를 순회
					outer2: for (int r = 0; r < 101 - l; r++) {
						
						// for 반복문을 사용해 각 글자를 순회
						for (int i = 0; i < l / 2; i++) {
							
							// 두 글자가 대칭이 아닌 경우 다음 시작 인덱스를 순회
							if (letterBoard[r + i][c] != letterBoard[r + l - i - 1][c])
								continue outer2;
						}
						
						// 가장 긴 회문의 길이 갱신 및 반복문 탈출
						maxLength = l;
						break outer1;
					}
				}
			}
			
			// write() 메서드를 사용해 테스트 케이스의 번호와 가장 긴 회문의 길이를 출력
			out.write("#" + testCase + " " + maxLength + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}