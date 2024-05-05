package bronze1.num11383;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine()); 
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 이미지의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 주어진 이미지를 두 배로 늘렸을 때 동일한 이미지인지를 나타낼 변수 isSame 초기화
		boolean isSame = true;
		
		// 입력 받은 첫 번째 이미지를 두 배로 늘려 저장할 2차원 배열 resizedImage 초기화
		char[][] resizedImage = new char[height][2 * width];
		
		// for 반복문을 사용해 첫 번째 이미지의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 첫 번째 이미지의 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 첫 번째 이미지의 각 열을 순회
			for (int idx = 0; idx < width; idx++) {
				
				// charAt() 메서드를 사용해 해당 이미지의 문자를 변수 character에 할당
				char character = line.charAt(idx);
				
				// 해당 이미지를 두 배로 늘려 2차원 배열 resizedImage에 저장
				resizedImage[r][idx * 2] = character;
				resizedImage[r][idx * 2 + 1] = character;
			}
		}
		
		// for 반복문을 사용해 두 번째 이미지의 각 행을 순회
		outer: for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 두 번째 이미지의 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 두 번째 이미지의 각 열을 순회
			for (int c = 0; c < line.length(); c++) {
				
				// 해당 이미지가 첫 번째 이미지와 일치하지 않는 경우 동일한 이미지인지를 나타낼 변수 갱신 후 반복문 탈출
				if (line.charAt(c) != resizedImage[r][c]) {
					isSame = false;
					break outer;
				}
			}
		}
		
		// 두 이미지가 동일한 이미지인 경우 'Eyfa' 출력
		if (isSame) {
			out.write("Eyfa");
			
		// 두 이미지가 동일한 이미지가 아닌 경우 'Not Eyfa' 출력
		} else {
			out.write("Not Eyfa");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}