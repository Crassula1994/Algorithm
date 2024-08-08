package silver4.num05534;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 오래된 간판의 수 및 새로 연 편의점의 이름을 각 변수에 할당
		int signNum = Integer.parseInt(in.readLine());
		String targetName = in.readLine();
		
		// 상근이가 만들 수 있는 간판의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 간판을 순회
		outer: for (int sign = 0; sign < signNum; sign++) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 간판의 문자를 배열 characters에 저장
			char[] characters = in.readLine().toCharArray();
			
			// for 반복문을 사용해 가능한 간격을 순회
			for (int gap = 1; (targetName.length() - 1) * gap <= characters.length; gap++) {
			
				// for 반복문을 사용해 가능한 시작 위치를 순회
				for (int start = 0; start + (targetName.length() - 1) * gap < characters.length; start++) {
					
					// 해당 간판으로 새로운 간판을 만들 수 있는지 여부를 저장할 변수 isPossible 초기화
					boolean isPossible = true;
										
					// for 반복문을 사용해 편의점 이름의 각 글자를 순회
					for (int idx = 0; idx < targetName.length(); idx++) {
						
						// 편의점 이름의 글자와 일치하지 않는 경우
						if (targetName.charAt(idx) != characters[start + gap * idx]) {
							
							// 해당 간판으로 새로운 간판을 만들 수 있는지 여부를 갱신 후 반복문 탈출
							isPossible = false;
							break;
						}
					}
					
					// 해당 간판으로 새로운 간판을 만들 수 있는 경우 상근이가 만들 수 있는 간판의 수를 갱신 후 다음 간판 순회
					if (isPossible) {
						count++;
						continue outer;
					}
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 상근이가 만들 수 있는 간판의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}