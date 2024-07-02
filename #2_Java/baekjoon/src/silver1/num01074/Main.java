package silver1.num01074;

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
		
		// nextToken(), parseInt(), pow() 메서드를 사용해 입력 받은 배열의 크기 및 목표로 하는 행과 열의 위치를 각 변수에 할당
		int size = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		int targetRow = Integer.parseInt(st.nextToken());
		int targetCol = Integer.parseInt(st.nextToken());
		
		// orderFinder() 메서드를 호출해 방문 순서를 변수 order에 할당
		int order = orderFinder(size, targetRow, targetCol);

		// valueOf() 및 write() 메서드를 사용해 방문 순서를 출력
		out.write(String.valueOf(order));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// orderFinder() 메서드 정의
	public static int orderFinder(int sizeArr, int targetRow, int targetCol) {
		
		// 해당 위치의 방문 순서 및 배열의 크기, 찾고자 하는 위치를 저장할 변수 order 초기화
		int order = 0;
		int size = sizeArr;
		int r = targetRow;
		int c = targetCol;
		
		// while 반복문을 사용해 해당 행렬의 방문 순서를 찾을 때까지 순회
		while (size > 1) {
			
			// 배열의 크기를 4등분해 갱신
			size /= 2;
			
			// 해당 행과 열의 위치가 2사분면에 위치한 경우 상대 위치 및 방문 순서 갱신
			if (r < size && c < size) {
				order += 0;
			
			// 해당 행과 열의 위치가 1사분면에 위치한 경우 상대 위치 및 방문 순서 갱신
			} else if (r < size && c >= size) {
				order += size * size;
				c -= size;
				
			// 해당 행과 열의 위치가 3사분면에 위치한 경우 상대 위치 및 방문 순서 갱신
			} else if (r >= size && c < size) {
				order += size * size * 2;
				r -= size;
			
			// 해당 행과 열의 위치가 4사분면에 위치한 경우 상대 위치 및 방문 순서 갱신
			} else {
				order += size * size * 3;
				r -= size;
				c -= size;
			} 
		}
		
		// 해당 위치의 방문 순서를 반환
		return order;
	}
}