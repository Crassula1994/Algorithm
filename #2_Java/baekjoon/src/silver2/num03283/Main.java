package silver2.num03283;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 바코드의 길이를 변수 width에 할당
		int width = Integer.parseInt(in.readLine());
		
		boolean determinable = true;
		
		// 각 바코드의 무늬를 저장할 배열 barcodes 초기화
		int[] barcodes = new int[width];
		
		// 바코드의 자릿수를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// fill() 메서드를 사용해 바코드의 무늬를 초기화
		Arrays.fill(barcodes, '?');
		
		// for 반복문을 사용해 바코드의 각 행을 순회
		for (int r = 0; r < 5; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 바코드의 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 바코드의 각 열을 순회
			for (int c = 0; c < width; c++) {
				
				// 해당 칸의 바코드를 알 수 없는 경우 다음 칸을 순회
				if (line.charAt(c) == '?')
					continue;
				
				// charAt() 메서드를 사용해 바코드의 무늬를 갱신
				barcodes[c] = line.charAt(c);
			}
		}
		
		// for 반복문을 사용해 바코드의 각 칸을 순회
		for (int c = 0; c < width; c++) {
			
			// 해당 바코드의 무늬를 읽을 수 있는 경우 다음 칸을 순회
			if (barcodes[c] != '?')
				continue;
			
			// 바코드가 1칸이고, 그 무늬를 읽을 수 없는 경우 바코드의 무늬를 갱신
			if (c == 0 && width == 1)
				barcodes[c] = 'X';
			
			// 뒤쪽에 연속한 1의 바코드가 나타나는 경우 해당 바코드는 그와 다른 무늬이므로 바코드의 무늬를 갱신
			if (c < width - 2 && barcodes[c + 1] == barcodes[c + 2])
				barcodes[c] = (barcodes[c + 1] == '.') ? 'X' : '.';
			
			// 앞쪽에 연속한 1의 바코드가 나타나는 경우 해당 바코드는 그와 다른 무늬이므로 바코드의 무늬를 갱신
			if (c > 1 && barcodes[c - 1] == barcodes[c - 2])
				barcodes[c] = (barcodes[c - 1] == '.') ? 'X' : '.';
			
			// 양 옆에 연속한 0의 바코드가 나타나는 경우 해당 바코드는 그와 다른 무늬이므로 바코드의 무늬를 갱신
			if (c > 0 && c < width - 1 && barcodes[c - 1] == barcodes[c + 1])
				barcodes[c] = (barcodes[c - 1] == '.') ? 'X' : '.';
			
			// 여전히 바코드의 무늬를 알 수 없는 경우 바코드를 구분할 수 있는지 여부를 갱신 후 반복문 탈출
			if (barcodes[c] == '?') {
				determinable = false;
				break;
			}
		}
		
		// 바코드를 구분할 수 없는 경우 'UNDETERMINABLE' 출력
		if (!determinable) {
			out.write("UNDETERMINABLE");
			
		// 바코드를 구분할 수 있는 경우
		} else {
			
			// for 반복문을 사용해 각 바코드의 위치를 순회
			for (int idx = 0; idx < width;) {
				
				// 바코드의 자릿수가 1인 경우 sb에 1 추가 후 현재 바코드의 위치를 갱신
				if (idx < width - 1 && barcodes[idx + 1] == barcodes[idx]) {
					sb.append(1);
					idx += 2;
					
				// 바코드의 자릿수가 0인 경우 sb에 0 추가 후 현재 바코드의 위치를 갱신
				} else {
					sb.append(0);
					idx += 1;
				}
			}
			
			// toString() 및 write() 메서드를 사용해 바코드의 자릿수를 출력
			out.write(sb.toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}